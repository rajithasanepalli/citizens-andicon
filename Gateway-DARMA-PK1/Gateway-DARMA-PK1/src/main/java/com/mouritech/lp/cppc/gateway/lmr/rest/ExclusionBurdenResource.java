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

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.ExclusionBurdensDTO;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;

/**
 * REST controller for managing ExclusionBurdens.
 */

@RestController
@RequestMapping("system2/api/v1")
public class ExclusionBurdenResource {

	private final Logger log = LoggerFactory.getLogger(ExclusionBurdenResource.class);
	@Autowired
	private LmrApplicationProperties applicationProperties;

	/**
	 * POST /Burdens -> Create a new Burdens.
	 */
	@RequestMapping(value = "/excburden", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(
			@Validated @RequestBody ExclusionBurdensDTO exclusionBurdensDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[excburden] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[excburden] REST request to save excburden : {}", exclusionBurdensDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// exclusionBurdensDTO.setSessionId(request.getHeader("x-session-id"));
		// exclusionBurdensDTO.setApproverId(applicationProperties.getApi_key());
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

		HttpEntity<ExclusionBurdensDTO> reuestbody = new HttpEntity<ExclusionBurdensDTO>(
				exclusionBurdensDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getExclusionBurdenUri(), HttpMethod.POST,
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
	 * PUT /Burdens -> update a new ExclusionBurdens.
	 */
	@RequestMapping(value = "/excburden", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBurdens(
			@Validated @RequestBody ExclusionBurdensDTO exclusionBurdensDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[excburden] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[excburden] REST request to save Burdens : {}", exclusionBurdensDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// exclusionBurdensDTO.setSessionId(request.getHeader("x-session-id"));
		// exclusionBurdensDTO.setApproverId(applicationProperties.getApi_key());
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

		HttpEntity<ExclusionBurdensDTO> reuestbody = new HttpEntity<ExclusionBurdensDTO>(
				exclusionBurdensDTO, headers);

		ResponseEntity<ExclusionBurdensDTO> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getExclusionBurdenUri(), HttpMethod.PUT,
					reuestbody, ExclusionBurdensDTO.class);

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
			result = new ResponseEntity<ExclusionBurdensDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	@RequestMapping(value = "/excburden", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ExclusionBurdensDTO> getBurdensBasedOnId(
			HttpServletRequest request, @RequestParam("id") String burdensId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get excburden based on burdensId:%s ",
				burdensId));
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

		String urlParam = "/" + burdensId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<ExclusionBurdensDTO> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getExclusionBurdenUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, ExclusionBurdensDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<ExclusionBurdensDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /burdenss -> get all the ExclusionBurdens.
	 */

	@RequestMapping(value = "/excburdens", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ExclusionBurdensDTO>> getAll(
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "location_id", required = false) String locationId)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get excburden based on page:%s and Per_page:%s ",
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

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage + "&"
				+ "location_id=" + locationId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<ExclusionBurdensDTO>> responseType = new ParameterizedTypeReference<List<ExclusionBurdensDTO>>() {
		};

		ResponseEntity<List<ExclusionBurdensDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getExclusionBurdenUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<ExclusionBurdensDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * DELETE /burdens/:id -> delete the "id" ExclusionBurdens.
	 */
	@RequestMapping(value = "/excburden", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteBurdensBasedonId(
			HttpServletRequest request, @RequestParam("id") String burdensId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to delete excburden basedburdensmetaId:%s ",
				burdensId));
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

		String urlParam = "/" + burdensId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getExclusionBurdenUri() + urlParam,
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

	
	
	
	
	
	
	
}
