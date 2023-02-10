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
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.TenderTypesLocationLinkDTO;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;

/**
 * REST controller for managing TenderTypesLocationLink.
 */

@RestController
@RequestMapping("system2/api/v1")
public class TenderTypesLocationLinkResource {

	private final Logger log = LoggerFactory
			.getLogger(TenderTypesLocationLinkResource.class);
	@Autowired
	private LmrApplicationProperties applicationProperties;
	
	@Autowired
	private DarmaApplicationProperties darmaApplicationProperties;

	/**
	 * POST /TenderTypesLocationLink -> Create a new TenderTypesLocationLink.
	 */
	@RequestMapping(value = "/tendertypeslocationlink", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(
			@Validated @RequestBody TenderTypesLocationLinkDTO tenderTypesLocationLinkDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[tendertypeslocationlink] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug(
				"[tendertypeslocationlink] REST request to save TenderTypesLocationLink : {}",
				tenderTypesLocationLinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// tenderTypesLocationLinkDTO.setSessionId(request.getHeader("x-session-id"));
		// tenderTypesLocationLinkDTO.setApproverId(applicationProperties.getApi_key());
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

		HttpEntity<TenderTypesLocationLinkDTO> reuestbody = new HttpEntity<TenderTypesLocationLinkDTO>(
				tenderTypesLocationLinkDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getTenderTypesLocationLinkUri(),
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
	 * PUT /TenderTypesLocationLink -> update a new TenderTypesLocationLink.
	 */
	@RequestMapping(value = "/tendertypeslocationlink", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateTttnameta(
			@Validated @RequestBody TenderTypesLocationLinkDTO tenderTypesLocationLinkDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[tendertypeslocationlink] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug(
				"[tendertypeslocationlink] REST request to save TenderTypesLocationLink : {}",
				tenderTypesLocationLinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// tenderTypesLocationLinkDTO.setSessionId(request.getHeader("x-session-id"));
		// tenderTypesLocationLinkDTO.setApproverId(applicationProperties.getApi_key());
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

		HttpEntity<TenderTypesLocationLinkDTO> reuestbody = new HttpEntity<TenderTypesLocationLinkDTO>(
				tenderTypesLocationLinkDTO, headers);

		ResponseEntity<TenderTypesLocationLinkDTO> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getTenderTypesLocationLinkUri(),
					HttpMethod.PUT, reuestbody,
					TenderTypesLocationLinkDTO.class);

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
			result = new ResponseEntity<TenderTypesLocationLinkDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * GET /tendertypeslocationlink/:id -> get the "id" tendertypeslocationlink.
	 */
	@RequestMapping(value = "/tendertypeslocationlink", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TenderTypesLocationLinkDTO> getTenderTypesLocationLnkBasedOnId(
			HttpServletRequest request,
			@RequestParam("id") String tendertypeslocationlinkId)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get tendertypeslocationlink based on tendertypeslocationlinkId:%s ",
						tendertypeslocationlinkId));
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

		String urlParam = "/" + tendertypeslocationlinkId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<TenderTypesLocationLinkDTO> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getTenderTypesLocationLinkUri()
							+ urlParam, HttpMethod.GET, getEmployeeRequest,
					TenderTypesLocationLinkDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<TenderTypesLocationLinkDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /tendertypeslocationlink -> get all tendertypeslocationlink.
	 */
	@RequestMapping(value = "/tendertypeslocationlinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<TenderTypesLocationLinkDTO>> getAll(
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "location_id", required = false) String locationId)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get tendertypeslocationlink based on page:%s and Per_page:%s ",
						page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey())||
						apiKey.equalsIgnoreCase(darmaApplicationProperties.getApiKey()))) {
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

		ParameterizedTypeReference<List<TenderTypesLocationLinkDTO>> responseType = new ParameterizedTypeReference<List<TenderTypesLocationLinkDTO>>() {
		};
		ResponseEntity<List<TenderTypesLocationLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getTenderTypesLocationLinkUri()
							+ urlParam, HttpMethod.GET, getEmployeeRequest,
					responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<TenderTypesLocationLinkDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}
	
	
	
	/**
	 * GET /tendertypeslocationlink -> get all tendertypeslocationlink.
	 */
	@RequestMapping(value = "/dtenderTypesLocationLink", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<TenderTypesLocationLinkDTO>> getTenderTypesLocationLink(
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "location_id", required = false) String locationId)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get tendertypeslocationlink based on page:%s and Per_page:%s ",
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

		ParameterizedTypeReference<List<TenderTypesLocationLinkDTO>> responseType = new ParameterizedTypeReference<List<TenderTypesLocationLinkDTO>>() {
		};
		ResponseEntity<List<TenderTypesLocationLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getDtenderTypesLocationLink()
							+ urlParam, HttpMethod.GET, getEmployeeRequest,
					responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<TenderTypesLocationLinkDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * DELETE /tendertypeslocationlink -> DELETE tendertypeslocationlink.
	 */
	@RequestMapping(value = "/tendertypeslocationlink", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteTenderTypesLocationLnkBasedonId(
			HttpServletRequest request,
			@RequestParam("tenTypeLocLnkId") String tendertypeslocationlinkId)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get tendertypeslocationlink based on tendertypeslocationlinkId:%s ",
						tendertypeslocationlinkId));
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

		String urlParam = "/" + tendertypeslocationlinkId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getTenderTypesLocationLinkUri()
							+ urlParam, HttpMethod.DELETE, getEmployeeRequest,
					Object.class);

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
