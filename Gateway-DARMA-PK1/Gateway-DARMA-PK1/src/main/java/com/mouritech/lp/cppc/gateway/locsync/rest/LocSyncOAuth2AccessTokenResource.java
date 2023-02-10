package com.mouritech.lp.cppc.gateway.locsync.rest;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.ErrorMessageUtil;
import com.mouritech.lp.cp.exceptions.ErrorResponse;
import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.config.LocSyncApplicationProperties;

/**
 * REST controller for OAuth Security
 */
@RestController
@RequestMapping("/locsync/oauth2/v1")
public class LocSyncOAuth2AccessTokenResource {

	private final Logger log = LoggerFactory.getLogger(LocSyncOAuth2AccessTokenResource.class);
	@Autowired
	private LocSyncApplicationProperties applicationProperties;

	/**
	 * POST Get Access Token
	 */
	@RequestMapping(value = "/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(HttpServletRequest request, @RequestParam("grant_type") String grant_type,
			@RequestParam("scope") String scope)
			throws InvalidAPIKeyException, HttpClientErrorException, HttpServerErrorException, URISyntaxException {

		log.debug("[/locsync/oauth2/v1/token] Oauth request [grant_type=" + grant_type + ",scope=" + scope + ", Authorization="
				+ request.getHeader("authorization") + ", Content-Type=" + request.getHeader("content-type")
				+ ",  api_key=" + request.getHeader("API-KEY") + "]");

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {
			throw new InvalidAPIKeyException("Invalid API Key");

		}

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		// params.add("grant_type", grant_type);
		// params.add("scope", scope);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "?grant_type=" + grant_type + "&" + "scope=" + scope;

		HttpEntity<MultiValueMap<String, String>> accesstokenRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getAccessTokenUri() + urlParam, HttpMethod.POST,
					accesstokenRequest, Object.class);

			HttpStatus.Series series = null;
			result.getStatusCode().series();
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

	@ExceptionHandler(InvalidAPIKeyException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.FORBIDDEN.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorResponse> httpClientExceptionHandler(HttpClientErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<ErrorResponse> httpServerExceptionHandler(HttpServerErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

}
