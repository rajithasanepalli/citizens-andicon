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
import com.mouritech.lp.cppc.gateway.locationsync.dto.PARCsVendorLinkDTO;

@RestController
@RequestMapping("system2/locationsync/api")
public class PARCsVendorLinkResource {

	private static final Logger log = LoggerFactory.getLogger(PARCsVendorLinkResource.class);

	@Autowired
	private LSApplicationProperties applicationProperties;

	/**
	 * POST /parcsVendorLink -> Create a new parcsVendorLink.
	 */
	@RequestMapping(value = "/parcsVendorLink", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody PARCsVendorLinkDTO parcsVendorLinkDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[PARCsVendorLink] REST request to save PARCsVendorLink : {}", parcsVendorLinkDTO);
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
		HttpEntity<PARCsVendorLinkDTO> requestbody = new HttpEntity<>(parcsVendorLinkDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri(), HttpMethod.POST, requestbody,
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
	 * PUT /parcsVendorLink -> update parcsVendorLink.
	 * 
	 * @param request
	 * @return
	 * @throws InvalidAPIKeyException
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/parcsVendorLink", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody PARCsVendorLinkDTO parcsVendorLinkDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[PARCsVendorLink] REST request to save PARCsVendorLink : {}", parcsVendorLinkDTO);
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
		HttpEntity<PARCsVendorLinkDTO> requestbody = new HttpEntity<>(parcsVendorLinkDTO, headers);
		ResponseEntity<PARCsVendorLinkDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri(), HttpMethod.PUT, requestbody,
					PARCsVendorLinkDTO.class);
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
	 * GET /parcsVendorLink/:id -> get the "id" parcsVendorLink.
	 * 
	 * @param request
	 * @param parcsVendorLinkId
	 * @return
	 * @throws InvalidAPIKeyException
	 */
	@RequestMapping(value = "/parcsVendorLink", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<PARCsVendorLinkDTO> getParcsVendorLinkById(HttpServletRequest request,
			@RequestParam("id") String parcsVendorLinkId) throws InvalidAPIKeyException {
		log.debug(
				String.format("Rest request to get parcsVendorLink based on parcsVendorLinkId:%s ", parcsVendorLinkId));
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
		String urlParam = "/" + parcsVendorLinkId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<PARCsVendorLinkDTO> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri() + urlParam, HttpMethod.GET,
					getRequest, PARCsVendorLinkDTO.class);
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
	 * GET /parcsVendorLinks -> get all the PARCsVendorLink.
	 */
	@RequestMapping(value = "/parcsVendorLinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PARCsVendorLinkDTO>> getAll(HttpServletRequest request) throws InvalidAPIKeyException {
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
		ParameterizedTypeReference<List<PARCsVendorLinkDTO>> responseType = new ParameterizedTypeReference<List<PARCsVendorLinkDTO>>() {
		};
		ResponseEntity<List<PARCsVendorLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri(), HttpMethod.GET,
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
	 * DELETE /parcsVendorLink/:id -> delete the "id" parcsVendorLink.
	 */
	@RequestMapping(value = "/parcsVendorLink", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @RequestParam("id") String parcsVendorId)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to delete parcsVendor based on parcsVendorId:%s ", parcsVendorId));
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
		String urlParam = "/" + parcsVendorId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri() + urlParam, HttpMethod.DELETE,
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
	 * GET /parcsVendorLink -> get all the parcsVendorLink By vendor_id.
	 */
	@RequestMapping(value = "/parcsVendorLink/byVendorId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PARCsVendorLinkDTO>> getAllByVendorId(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "vendor_id", required = false) String vendorId) throws InvalidAPIKeyException {
		log.debug(
				String.format("Rest request to get parcsVendorLink based on page:%s and Per_page:%s ", page, perPage));
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
		String urlParam = "/byVendorId?page=" + page + "&" + "per_page=" + perPage + "&" + "vendor_id=" + vendorId;
		HttpEntity<MultiValueMap<String, String>> getRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<PARCsVendorLinkDTO>> responseType = new ParameterizedTypeReference<List<PARCsVendorLinkDTO>>() {
		};
		ResponseEntity<List<PARCsVendorLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getParcsVendorLinkUri() + urlParam, HttpMethod.GET,
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
}
