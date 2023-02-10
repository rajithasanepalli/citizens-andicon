package com.mouritech.lp.cppc.gateway.locationsync.rest;

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
import com.mouritech.lp.cppc.gateway.config.LSApplicationProperties;
import com.mouritech.lp.cppc.gateway.constants.GatewayConstants;
import com.mouritech.lp.cppc.gateway.locationsync.dto.GatewayProcessorLinkDTO;

@RestController
@RequestMapping("system2/locationsync/api")
public class GatewayProcessorLinkResource {

	private static final Logger log = LoggerFactory.getLogger(GatewayProcessorLinkResource.class);

	@Autowired
	private LSApplicationProperties applicationProperties;

	/**
	 * POST /gatewayProcessorLink -> Create a new gatewayProcessorLink.
	 */
	@RequestMapping(value = "/gatewayProcessorLink", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody GatewayProcessorLinkDTO gatewayProcessorLinkDTO,
			HttpServletRequest request) throws InvalidAPIKeyException {

		log.debug("[gatewayProcessorLink] REST request to save gatewayProcessorLink : {}", gatewayProcessorLinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GatewayProcessorLinkDTO> requestbody = new HttpEntity<>(gatewayProcessorLinkDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri(), HttpMethod.POST,
					requestbody, Object.class);
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
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
	}

	/**
	 * PUT /gatewayProcessorLink -> update gatewayProcessorLink.
	 * 
	 * @param gatewayProcessorLinkDTO
	 * @param request
	 * @return
	 * @throws InvalidAPIKeyException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/gatewayProcessorLink", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody GatewayProcessorLinkDTO gatewayProcessorLinkDTO,
			HttpServletRequest request) throws InvalidAPIKeyException {

		log.debug("[gatewayProcessorLink] REST request to save gatewayProcessorLink : {}", gatewayProcessorLinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<GatewayProcessorLinkDTO> requestbody = new HttpEntity<>(gatewayProcessorLinkDTO, headers);
		ResponseEntity<GatewayProcessorLinkDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri(), HttpMethod.PUT,
					requestbody, GatewayProcessorLinkDTO.class);
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
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
	}

	/**
	 * GET /gatewayProcessorLink/:id -> get the "id" gatewayProcessorLink.
	 * 
	 * @param request
	 * @param gatewayProcessorLinkId
	 * @return
	 * @throws InvalidAPIKeyException
	 */
	@RequestMapping(value = "/gatewayProcessorLink", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GatewayProcessorLinkDTO> getGatewayProcessorLinkById(HttpServletRequest request,
			@RequestParam("id") String gatewayProcessorLinkId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get gatewayProcessorLink based on gatewayProcessorLinkId:%s ",
				gatewayProcessorLinkId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		headers.add(GatewayConstants.ACCEPT, request.getHeader(GatewayConstants.ACCEPT));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "/" + gatewayProcessorLinkId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<GatewayProcessorLinkDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri() + urlParam,
					HttpMethod.GET, getRequest, GatewayProcessorLinkDTO.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /gatewayProcessorLink -> get all the gatewayProcessorLink.
	 */
	@RequestMapping(value = "/gatewayProcessorLinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<GatewayProcessorLinkDTO>> getAll(HttpServletRequest request)
			throws InvalidAPIKeyException {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		headers.add(GatewayConstants.ACCEPT, request.getHeader(GatewayConstants.ACCEPT));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<GatewayProcessorLinkDTO>> responseType = new ParameterizedTypeReference<List<GatewayProcessorLinkDTO>>() {
		};
		ResponseEntity<List<GatewayProcessorLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri(), HttpMethod.GET,
					getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * DELETE /gatewayProcessorLink/:id -> delete the "id" gatewayProcessorLink.
	 */
	@RequestMapping(value = "/gatewayProcessorLink", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @RequestParam("id") String gatewayProcessorLinkId)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to delete gatewayProcessorLink based on gatewayProcessorLinkId:%s ",
				gatewayProcessorLinkId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		headers.add(GatewayConstants.ACCEPT, request.getHeader(GatewayConstants.ACCEPT));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "/" + gatewayProcessorLinkId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri() + urlParam,
					HttpMethod.DELETE, getRequest, Object.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /gatewayProcessorLink -> get all the gatewayProcessorLink By
	 * processor_id.
	 */
	@RequestMapping(value = "/gatewayProcessorLink/byProcessorId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<GatewayProcessorLinkDTO>> getAllGatewayByProcessorId(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "processor_id", required = false) String processorId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get gatewayProcessorLink based on page:%s and Per_page:%s ", page,
				perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(GatewayConstants.AUTHORIZATION, request.getHeader(GatewayConstants.AUTHORIZATION));
		headers.add(GatewayConstants.CONTENT_TYPE, request.getHeader(GatewayConstants.CONTENT_TYPE));
		headers.add(GatewayConstants.X_SESSION_ID, request.getHeader(GatewayConstants.X_SESSION_ID));
		headers.add(GatewayConstants.ACCEPT, request.getHeader(GatewayConstants.ACCEPT));
		String apiKey = request.getHeader(GatewayConstants.API_KEY);
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add(GatewayConstants.API_KEY, request.getHeader(GatewayConstants.API_KEY));
		} else {
			throw new InvalidAPIKeyException(GatewayConstants.INVALID_API_KEY);
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "/byProcessorId?page=" + page + "&" + "per_page=" + perPage + "&" + "processor_id="
				+ processorId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<GatewayProcessorLinkDTO>> responseType = new ParameterizedTypeReference<List<GatewayProcessorLinkDTO>>() {
		};
		ResponseEntity<List<GatewayProcessorLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayProcessorLinkUri() + urlParam,
					HttpMethod.GET, getRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}
}
