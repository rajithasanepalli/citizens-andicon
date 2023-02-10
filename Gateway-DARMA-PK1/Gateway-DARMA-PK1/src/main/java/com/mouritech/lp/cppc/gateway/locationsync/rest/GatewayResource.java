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
import com.mouritech.lp.cppc.gateway.locationsync.dto.GatewayDTO;

@RestController
@RequestMapping("system2/locationsync/api")
public class GatewayResource {

	private static final Logger log = LoggerFactory.getLogger(GatewayResource.class);

	@Autowired
	private LSApplicationProperties applicationProperties;

	/**
	 * POST /gateway -> Create a new gateway.
	 */
	@RequestMapping(value = "/gateway", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody GatewayDTO gatewayDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[gateway] REST request to save gateway : {}", gatewayDTO);
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
		HttpEntity<GatewayDTO> requestbody = new HttpEntity<>(gatewayDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri(), HttpMethod.POST, requestbody,
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
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
	}

	/**
	 * PUT /gateway -> update gateway.
	 * 
	 * @param gatewayDTO
	 * @param request
	 * @return
	 * @throws InvalidAPIKeyException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/gateway", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody GatewayDTO gatewayDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[gateway] REST request to save gateway : {}", gatewayDTO);
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
		HttpEntity<GatewayDTO> requestbody = new HttpEntity<>(gatewayDTO, headers);
		ResponseEntity<GatewayDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri(), HttpMethod.PUT, requestbody,
					GatewayDTO.class);
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
	 * GET /gateway/:id -> get the "id" gateway.
	 * 
	 * @param request
	 * @param gatewayId
	 * @return
	 * @throws InvalidAPIKeyException
	 */
	@RequestMapping(value = "/gateway", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<GatewayDTO> getGatewayById(HttpServletRequest request, @RequestParam("id") String gatewayId)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get gateway based on gatewayId:%s ", gatewayId));
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
		String urlParam = "/" + gatewayId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<GatewayDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri() + urlParam, HttpMethod.GET, getRequest,
					GatewayDTO.class);
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
	 * GET /gateway -> get all the gateway.
	 */
	@RequestMapping(value = "/gateways", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<GatewayDTO>> getAll(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage) throws InvalidAPIKeyException {
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
		String urlParam = "/pagination?page=" + page + "&" + "per_page=" + perPage;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<GatewayDTO>> responseType = new ParameterizedTypeReference<List<GatewayDTO>>() {
		};
		ResponseEntity<List<GatewayDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri() + urlParam, HttpMethod.GET,
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
	 * DELETE /gateway/:id -> delete the "id" gateway.
	 */
	@RequestMapping(value = "/gateway", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @RequestParam("id") String gatewayId)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to delete gateway based on gatewayId:%s ", gatewayId));
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
		String urlParam = "/" + gatewayId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri() + urlParam, HttpMethod.DELETE,
					getRequest, Object.class);
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
	 * GET /gateway -> get all the gateway.
	 */
	@RequestMapping(value = "/gateways/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<GatewayDTO>> getAllGateways(HttpServletRequest request) throws InvalidAPIKeyException {
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
		ParameterizedTypeReference<List<GatewayDTO>> responseType = new ParameterizedTypeReference<List<GatewayDTO>>() {
		};
		ResponseEntity<List<GatewayDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getGatewayUri(), HttpMethod.GET, getEmployeeRequest,
					responseType);
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
