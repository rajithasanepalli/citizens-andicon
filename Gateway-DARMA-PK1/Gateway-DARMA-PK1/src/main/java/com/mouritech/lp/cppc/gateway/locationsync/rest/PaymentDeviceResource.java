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
import com.mouritech.lp.cppc.gateway.locationsync.dto.PaymentDevicesDTO;

@RestController
@RequestMapping("system2/locationsync/api")
public class PaymentDeviceResource {

	private static final Logger log = LoggerFactory.getLogger(PaymentDeviceResource.class);

	@Autowired
	private LSApplicationProperties applicationProperties;

	/**
	 * POST /paymentDevice -> Create a new paymentDevice.
	 */
	@RequestMapping(value = "/paymentDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody PaymentDevicesDTO paymentDevicesDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {
		log.debug("[paymentDevice] REST request to save paymentDevice : {}", paymentDevicesDTO);
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
		HttpEntity<PaymentDevicesDTO> requestbody = new HttpEntity<>(paymentDevicesDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getPaymentDeviceUri(), HttpMethod.POST, requestbody,
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
	 * PUT /paymentDevice -> update paymentDevice.
	 * 
	 * @param paymentDeviceDTO
	 * @param request
	 * @return
	 * @throws InvalidAPIKeyException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/paymentDevice", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody PaymentDevicesDTO paymentDevicesDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {
		log.debug("[paymentDevice] REST request to save paymentDevice : {}", paymentDevicesDTO);
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
		HttpEntity<PaymentDevicesDTO> requestbody = new HttpEntity<>(paymentDevicesDTO, headers);
		ResponseEntity<PaymentDevicesDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getPaymentDeviceUri(), HttpMethod.PUT, requestbody,
					PaymentDevicesDTO.class);
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
	 * GET /paymentDevice/:id -> get the "id" paymentDevice.
	 * 
	 * @param request
	 * @param paymentDeviceId
	 * @return
	 * @throws InvalidAPIKeyException
	 */
	@RequestMapping(value = "/paymentDevice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PaymentDevicesDTO> getPaymentDeviceById(HttpServletRequest request,
			@RequestParam("id") String paymentDeviceId) throws InvalidAPIKeyException {
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
		String urlParam = "/" + paymentDeviceId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<PaymentDevicesDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getPaymentDeviceUri() + urlParam, HttpMethod.GET,
					getRequest, PaymentDevicesDTO.class);
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
	 * GET /paymentDevice -> get all the paymentDevice.
	 */
	@RequestMapping(value = "/paymentDevices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PaymentDevicesDTO>> getAll(HttpServletRequest request,
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
		ParameterizedTypeReference<List<PaymentDevicesDTO>> responseType = new ParameterizedTypeReference<List<PaymentDevicesDTO>>() {
		};
		ResponseEntity<List<PaymentDevicesDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getPaymentDeviceUri() + urlParam, HttpMethod.GET,
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
	 * DELETE /paymentDevice/:id -> delete the "id" paymentDevice.
	 */
	@RequestMapping(value = "/paymentDevice", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @RequestParam("id") String paymentDeviceId)
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
		String urlParam = "/" + paymentDeviceId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getPaymentDeviceUri() + urlParam, HttpMethod.DELETE,
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
