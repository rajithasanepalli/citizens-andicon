package com.mouritech.lp.cppc.gateway.tallysheet.rest;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.iParkUserDTO;
import com.mouritech.lp.cppc.gateway.views.View;

/**
 * REST controller for managing Tally Users.
 */

@RestController
@RequestMapping("system4/tally/api")
public class TallySheetUserResource {

	private final Logger log = LoggerFactory.getLogger(TallySheetUserResource.class);

	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;

	/**
	 * POST /Users -> Create a new Users.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(
			@Validated @RequestBody iParkUserDTO usersDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[users] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[users] REST request to save Users : {}", usersDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

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

		HttpEntity<iParkUserDTO> reuestbody = new HttpEntity<iParkUserDTO>(
				usersDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTallyUserUri(), HttpMethod.POST,
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
	 * PUT /Users -> update a new Users.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(
			@Validated @RequestBody iParkUserDTO usersDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[users] REST request to recieved from  :",
				request.getRemoteAddr());
		log.debug("[users] REST request to save Users : {}", usersDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// usersDTO.setSessionId(request.getHeader("x-session-id"));
		// usersDTO.setApproverId(applicationProperties.getApi_key());
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		}  else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<iParkUserDTO> reuestbody = new HttpEntity<iParkUserDTO>(
				usersDTO, headers);

		ResponseEntity<iParkUserDTO> result = null;

		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTallyUserUri(), HttpMethod.PUT,
					reuestbody, iParkUserDTO.class);

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
			result = new ResponseEntity<iParkUserDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<iParkUserDTO> getUserBasedOnId(
			HttpServletRequest request, @RequestParam("id") String usersId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get users based on usersId:%s ",
				usersId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

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

		String urlParam = "/" + usersId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<iParkUserDTO> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTallyUserUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, iParkUserDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<iParkUserDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /userss -> get all the userss.
	 */
	@JsonView(View.User.class)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<iParkUserDTO>> getAll(
			HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get users based on page:%s and Per_page:%s ",
						page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

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

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<iParkUserDTO>> responseType = new ParameterizedTypeReference<List<iParkUserDTO>>() {
		};

		ResponseEntity<List<iParkUserDTO>> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTallyUserUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<iParkUserDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * DELETE /users/:id -> delete the "id" users.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteUserBasedOnId(
			HttpServletRequest request, @RequestParam("id") String usersId)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get users basedusersmetaId:%s ",
				usersId));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

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

		String urlParam = "/" + usersId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTallyUserUri() + urlParam,
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
