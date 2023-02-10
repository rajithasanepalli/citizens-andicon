package com.mouritech.lp.cppc.gateway.security;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;

/**
 * REST controller for managing Logout.
 */

@RestController
@RequestMapping("ldap/oauth2/v1")
public class LdapLogoutResource {

	private final Logger log = LoggerFactory
			.getLogger(LdapLogoutResource.class);
	@Autowired
	private LmrApplicationProperties applicationProperties;
	
	@Autowired
	private DarmaApplicationProperties darmaApplicationProperties;

	/**
	 * logout current user
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> logout(HttpServletRequest request)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to logout User:%s ",
				request.getUserPrincipal()));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
	/*	headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));
*/
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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getLdapLogout(), HttpMethod.DELETE,
					getEmployeeRequest, Object.class);

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
