package com.mouritech.lp.cppc.gateway.cp.rest;

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
import com.mouritech.lp.cppc.gateway.DTO.UserDashBoardLinkDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;

/**
 * REST controller for managing userdashboardlink.
 */

@RestController
@RequestMapping("system3/api/v1")
public class UserDashBoardLinkResource {

	private final Logger log = LoggerFactory.getLogger(UserDashBoardLinkResource.class);

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	/**
	 * POST /UserDashBoardLink -> Create a new UserDashBoardLink.
	 */
	@RequestMapping(value = "/userdashboardlink", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@Validated @RequestBody UserDashBoardLinkDTO userdashboardlinkDTO,
			HttpServletRequest request) throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[userdashboardlink] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[userdashboardlink] REST request to save userdashboardlink : {}", userdashboardlinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && (apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<UserDashBoardLinkDTO> reuestbody = new HttpEntity<UserDashBoardLinkDTO>(userdashboardlinkDTO,
				headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri(), HttpMethod.POST,
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
	 * PUT /UserDashBoardLink -> update a new RevenueTypesLocationLink.
	 */
	@RequestMapping(value = "/userdashboardlink", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUserDashBoardLink(
			@Validated @RequestBody UserDashBoardLinkDTO userDashBoardLinkDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[userdashboardlink] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[userdashboardlink] REST request to save RevenueTypesLocationLink : {}", userDashBoardLinkDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && (apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<UserDashBoardLinkDTO> reuestbody = new HttpEntity<UserDashBoardLinkDTO>(userDashBoardLinkDTO,
				headers);

		ResponseEntity<UserDashBoardLinkDTO> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri(), HttpMethod.PUT,
					reuestbody, UserDashBoardLinkDTO.class);

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
			result = new ResponseEntity<UserDashBoardLinkDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * GET /userdashboardlink/:id -> get the "id" userdashboardlink.
	 */
	@RequestMapping(value = "/userdashboardlink", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserDashBoardLinkDTO> getUserDashBoardLinkBasedOnId(HttpServletRequest request,
			@RequestParam("id") String userdashboardlinkId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get userdashboardlink based on userdashboardlinkId:%s ",
				userdashboardlinkId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + userdashboardlinkId;

		HttpEntity<MultiValueMap<String, String>> getUserDashBoardLinkRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<UserDashBoardLinkDTO> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri() + urlParam,
					HttpMethod.GET, getUserDashBoardLinkRequest, UserDashBoardLinkDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<UserDashBoardLinkDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /userdashboardlink -> get all userdashboardlink.
	 */
	@RequestMapping(value = "user/userdashboardlinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<UserDashBoardLinkDTO>> getAllUsersBasedOnDashBoardId(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "dashboard_id", required = false) String dashboardId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get userdashboardlink based on page:%s and Per_page:%s ", page,
				perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "/user" + "?page=" + page + "&" + "per_page=" + perPage + "&" + "dashboard_id=" + dashboardId;

		HttpEntity<MultiValueMap<String, String>> getUserDashBoardLinkRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<UserDashBoardLinkDTO>> responseType = new ParameterizedTypeReference<List<UserDashBoardLinkDTO>>() {
		};
		ResponseEntity<List<UserDashBoardLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri() + urlParam,
					HttpMethod.GET, getUserDashBoardLinkRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<UserDashBoardLinkDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /userdashboardlink -> get all userdashboardlink.
	 */
	@RequestMapping(value = "dashboard/userdashboardlinks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<UserDashBoardLinkDTO>> getAllDashBoardBasedOnUserId(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage,
			@RequestParam(value = "user_id", required = false) String user_id) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get userdashboardlink based on page:%s and Per_page:%s ", page,
				perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && (apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "/dashboard" + "?page=" + page + "&" + "per_page=" + perPage + "&" + "user_id=" + user_id;

		HttpEntity<MultiValueMap<String, String>> getUserDashBoardLinkRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<UserDashBoardLinkDTO>> responseType = new ParameterizedTypeReference<List<UserDashBoardLinkDTO>>() {
		};
		ResponseEntity<List<UserDashBoardLinkDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri() + urlParam,
					HttpMethod.GET, getUserDashBoardLinkRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<UserDashBoardLinkDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * DELETE /userdashboardlink -> DELETE userdashboardlink.
	 */
	@RequestMapping(value = "/userdashboardlink", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteUserDashBoardBasedonId(HttpServletRequest request,
			@RequestParam("id") String userdashboardlinkId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get userdashboardlink based on userdashboardlinkId:%s ",
				userdashboardlinkId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + userdashboardlinkId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpUserDashBoardLinkUri() + urlParam,
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
