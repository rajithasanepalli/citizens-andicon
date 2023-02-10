package com.mouritech.lp.cppc.gateway.lmr.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.mouritech.lp.cppc.gateway.DTO.RevenueTypesDTO;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;

/**
 * REST controller for managing RevenueTypes.
 */

@RestController
@RequestMapping("system2/api/v1")
public class RevenueTypesResource {

	private final Logger log = LoggerFactory
			.getLogger(RevenueTypesResource.class);
	@Autowired
	private LmrApplicationProperties applicationProperties;

	/**
	 * POST /RevenueTypes -> Create a new RevenueTypes.
	 */
	@RequestMapping(value = "/revenuetype", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(
			@Validated @RequestBody RevenueTypesDTO revenueTypesDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[revenuetypes] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[revenuetypes] REST request to save RevenueTypes : {}",
				revenueTypesDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// revenueTypesDTO.setSessionId(request.getHeader("x-session-id"));
		// revenueTypesDTO.setApproverId(applicationProperties.getApi_key());
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<RevenueTypesDTO> reuestbody = new HttpEntity<RevenueTypesDTO>(
				revenueTypesDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getRevenueTypesUri(),
					HttpMethod.POST, reuestbody, Object.class);

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

	/**
	 * PUT /RevenueTypes -> update a new RevenueTypes.
	 */
	@RequestMapping(value = "/revenuetype", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateTttnameta(
			@Validated @RequestBody RevenueTypesDTO revenueTypesDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[revenuetypes] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[revenuetypes] REST request to save RevenueTypes : {}",
				revenueTypesDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// revenueTypesDTO.setSessionId(request.getHeader("x-session-id"));
		// revenueTypesDTO.setApproverId(applicationProperties.getApi_key());
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<RevenueTypesDTO> reuestbody = new HttpEntity<RevenueTypesDTO>(
				revenueTypesDTO, headers);

		ResponseEntity<RevenueTypesDTO> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getRevenueTypesUri(), HttpMethod.PUT,
					reuestbody, RevenueTypesDTO.class);

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
			result = new ResponseEntity<RevenueTypesDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	@RequestMapping(value = "/revenuetype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<RevenueTypesDTO> getTttnametaBasedOnId(
			HttpServletRequest request,
			@RequestParam("id") String revenuetypesId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get revenuetype based on revenuetypesId:%s ",
				revenuetypesId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + revenuetypesId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<RevenueTypesDTO> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getRevenueTypesUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, RevenueTypesDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<RevenueTypesDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	@RequestMapping(value = "/revenuetypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<RevenueTypesDTO>> getAll(
			HttpServletRequest request, @RequestParam("page") String page,
			@RequestParam("per_page") String perPage)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get revenuetype based on page:%s and Per_page:%s ",
						page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<RevenueTypesDTO>> responseType = new ParameterizedTypeReference<List<RevenueTypesDTO>>() {
		};
		ResponseEntity<List<RevenueTypesDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getRevenueTypesUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<RevenueTypesDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	@RequestMapping(value = "/revenuetype/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteRevenueTypesBasedonId(
			HttpServletRequest request,
			@PathVariable("id") String revenuetypesId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get revenuetype based on revenuetypesId:%s ",
				revenuetypesId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + revenuetypesId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getRevenueTypesUri() + urlParam,
					HttpMethod.DELETE, getEmployeeRequest, Object.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<Object>(HttpStatus.SERVICE_UNAVAILABLE);
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
	public ResponseEntity<ErrorResponse> httpClientExceptionHandler(
			HttpClientErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(
				ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<ErrorResponse> httpServerExceptionHandler(
			HttpServerErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(
				ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

}
