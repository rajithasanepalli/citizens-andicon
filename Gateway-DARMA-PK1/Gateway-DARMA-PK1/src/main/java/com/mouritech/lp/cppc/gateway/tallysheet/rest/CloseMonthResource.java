package com.mouritech.lp.cppc.gateway.tallysheet.rest;

import java.net.URISyntaxException;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.CloseMonthDTO;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.CloseMonthMessageDTO;

@RestController
@RequestMapping("system4/tally/api")
public class CloseMonthResource {

	private final Logger log = LoggerFactory.getLogger(CloseMonthResource.class);

	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;

	/**
	 * POST /revenue -> Create a new revenue.
	 */
	@RequestMapping(value = "/closemonth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(
			@Validated @RequestBody CloseMonthDTO revenueLockDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[revenue] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[revenue] REST request to save revenue : {}", revenueLockDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<CloseMonthDTO> reuestbody = new HttpEntity<CloseMonthDTO>(revenueLockDTO,
				headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getOpenOrClosedMonthUri(), HttpMethod.POST,
					reuestbody, Object.class);

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
	 * POST /revenue -> Create a new revenue.
	 */
	@RequestMapping(value = "/bulkclosemonth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CloseMonthMessageDTO> closeMonthForAllGarages(
			 @RequestBody CloseMonthDTO revenueLockDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		//MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		log.debug("[revenue] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[revenue] REST request to save revenue : {}", revenueLockDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		
		ParameterizedTypeReference<CloseMonthMessageDTO> responseType = new ParameterizedTypeReference<CloseMonthMessageDTO>() {
		};
		HttpEntity<CloseMonthDTO> reuestbody = new HttpEntity<CloseMonthDTO>(revenueLockDTO,
				headers);

		ResponseEntity<CloseMonthMessageDTO> result = null;

		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getOpenOrClosedMonthUri()+"/"+"bulk", HttpMethod.POST,
					reuestbody, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<CloseMonthMessageDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	}
	
	



