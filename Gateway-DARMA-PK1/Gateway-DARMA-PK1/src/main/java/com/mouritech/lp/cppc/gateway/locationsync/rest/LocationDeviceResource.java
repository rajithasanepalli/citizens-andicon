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
import com.mouritech.lp.cppc.gateway.locationsync.dto.LocationDeviceDTO;

@RestController
@RequestMapping("system2/locationsync/api")
public class LocationDeviceResource {

	private static final Logger log = LoggerFactory.getLogger(LocationDeviceResource.class);

	@Autowired
	private LSApplicationProperties applicationProperties;

	/**
	 * POST /locationDevice -> Create a new locationDevice.
	 */
	@RequestMapping(value = "/locationDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody LocationDeviceDTO locationDeviceDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[locationDevice] REST request to save locationDevice : {}", locationDeviceDTO);
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
		HttpEntity<LocationDeviceDTO> requestbody = new HttpEntity<>(locationDeviceDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getLocationDeviceUri(), HttpMethod.POST, requestbody,
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
	 * PUT /locationDevice -> update locationDevice.
	 * 
	 * @param locationDeviceDTO
	 * @param request
	 * @return
	 * @throws InvalidAPIKeyException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/locationDevice", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody LocationDeviceDTO locationDeviceDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[locationDevice] REST request to save locationDevice : {}", locationDeviceDTO);
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
		HttpEntity<LocationDeviceDTO> requestbody = new HttpEntity<>(locationDeviceDTO, headers);
		ResponseEntity<LocationDeviceDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getLocationDeviceUri(), HttpMethod.PUT, requestbody,
					LocationDeviceDTO.class);
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
	 * GET /locationDevice/:id -> get the "id" locationDevice.
	 * 
	 * @param request
	 * @param locationDeviceId
	 * @return
	 * @throws InvalidAPIKeyException
	 */
	@RequestMapping(value = "/locationDevice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<LocationDeviceDTO> getLocationDeviceById(HttpServletRequest request,
			@RequestParam("id") String locationDeviceId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get locationDevice based on locationDeviceId:%s ", locationDeviceId));
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
		String urlParam = "/" + locationDeviceId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<LocationDeviceDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getLocationDeviceUri() + urlParam, HttpMethod.GET,
					getRequest, LocationDeviceDTO.class);
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
	 * GET /locationDevices -> get all the PaymentDevices by location_id.
	 */
	@RequestMapping(value = "/locationDevices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<LocationDeviceDTO>> getAllByLocationId(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "location_id", required = false) String locationId) throws InvalidAPIKeyException {
		log.debug(
				String.format("Rest request to get locationDevices based on page:%s and Per_page:%s ", page, perPage));
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
		String urlParam = "?page=" + page + "&" + "per_page=" + perPage + "&" + "location_id=" + locationId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<LocationDeviceDTO>> responseType = new ParameterizedTypeReference<List<LocationDeviceDTO>>() {
		};
		ResponseEntity<List<LocationDeviceDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getLocationDeviceUri() + urlParam, HttpMethod.GET,
					getRequest, responseType);
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
	 * DELETE /locationDevice/:id -> delete the "id" locationDevice.
	 */
	@RequestMapping(value = "/locationDevice", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @RequestParam("id") String locationDeviceId)
			throws InvalidAPIKeyException {
		log.debug(
				String.format("Rest request to delete locationDevice based on locationDeviceId:%s ", locationDeviceId));
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
		String urlParam = "/" + locationDeviceId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getLocationDeviceUri() + urlParam, HttpMethod.DELETE,
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
}
