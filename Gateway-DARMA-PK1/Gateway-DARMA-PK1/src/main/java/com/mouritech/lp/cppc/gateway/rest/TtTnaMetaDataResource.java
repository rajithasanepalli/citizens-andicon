package com.mouritech.lp.cppc.gateway.rest;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.ErrorMessageUtil;
import com.mouritech.lp.cp.exceptions.ErrorResponse;
import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.TtTnaMetaDTO;
import com.mouritech.lp.cppc.gateway.config.ApplicationProperties;

/**
 * REST controller for managing TtTnaMeta.
 */

@RestController
@RequestMapping("system1/api/v1")
public class TtTnaMetaDataResource {

	private final Logger log = LoggerFactory.getLogger(TtTnaMetaDataResource.class);
	@Autowired
	private ApplicationProperties applicationProperties;

	/**
	 * POST /TtTnaMeta -> Create a new TtTnaMeta.
	 */
	@RequestMapping(value = "/payweek/approval", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@Validated @RequestBody TtTnaMetaDTO ttTnaMetaDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[/payweek/approval] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[/payweek/approval] REST request to save TtTnaMeta : {}", ttTnaMetaDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		ttTnaMetaDTO.setSessionId(request.getHeader("x-session-id"));
		// ttTnaMetaDTO.setApproverId(applicationProperties.getApi_key());
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<TtTnaMetaDTO> reuestbody = new HttpEntity<TtTnaMetaDTO>(ttTnaMetaDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(applicationProperties.getTtkMetaAPIUri(), HttpMethod.POST, reuestbody,
					Object.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			} else {
				GatewayResult gatewayResult = new GatewayResult();
				gatewayResult.setStatus(HttpStatus.OK.value());
				gatewayResult.setMessage("Processed Successfully");

				return ResponseEntity.ok().body(gatewayResult);
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<Object>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TtTnaMetaDTO> getEmployeesBasedonLocationIdAndPayweek(HttpServletRequest request,
			@RequestParam("locationId") String locationId, @RequestParam("payweekDate") String payweekDate) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get employees based on locationId:%s and payweekDate:%s ", locationId,
				payweekDate));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "?locationId=" + locationId + "&" + "payweekDate=" + payweekDate;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<TtTnaMetaDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getEmployeesBasedOnLocationIdAndPayweekUri()+urlParam, HttpMethod.POST, getEmployeeRequest,
					TtTnaMetaDTO.class);

			HttpStatus.Series series=result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<TtTnaMetaDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	@ExceptionHandler(InvalidAPIKeyException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.FORBIDDEN.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorResponse> httpClientExceptionHandler(HttpClientErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<ErrorResponse> httpServerExceptionHandler(HttpServerErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

}
