package com.mouritech.lp.cppc.gateway.security;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrDarmaApplicationProperties;

/**
 * REST controller for OAuth Security
 */
@RestController
@RequestMapping("ldap/oauth2/v1")
public class LdapOAuth2AccessTokenResource {

	private final Logger log = LoggerFactory
			.getLogger(LdapOAuth2AccessTokenResource.class);
	@Autowired
	private LmrApplicationProperties applicationProperties;

	@Autowired
	private LmrDarmaApplicationProperties lmrDarmaApplicationProperties;
	
	@Autowired
	private DarmaApplicationProperties darmaApplicationProperties ;

	/**
	 * POST Get Access Token
	 */
	@RequestMapping(value = "/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(HttpServletRequest request,
			@RequestParam("grant_type") String grant_type,
			@RequestParam("scope") String scope,
			@RequestParam("user_type") String userType,
			@RequestParam("companyName") String companyName,
			@RequestParam("username") String username,
			@RequestParam("password") String password)
			throws InvalidAPIKeyException, HttpClientErrorException,
			HttpServerErrorException, URISyntaxException {

		log.debug("[/oauth2/v1/token] Oauth request [grant_type=" + grant_type
				+ ",scope=" + scope + ", Authorization="
				+ request.getHeader("authorization") + ", Content-Type="
				+ request.getHeader("content-type") + ",  api_key="
				+ request.getHeader("API-KEY") + "]");
		String brandCode = null;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey())||
						apiKey.equalsIgnoreCase(darmaApplicationProperties.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {
			throw new InvalidAPIKeyException("Invalid API Key");

		}

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		// params.add("grant_type", grant_type);
		// params.add("scope", scope);
		if (companyName.contains(lmrDarmaApplicationProperties
				.getLanierComapanyName())) {
			//username = "lanierparking\\" + username;
			brandCode = lmrDarmaApplicationProperties.getLanierBrandCode();
		} else if (companyName.contains(lmrDarmaApplicationProperties
				.getAmeriparkComapanyName())) {
			//username = "ameripark\\" + username;
			brandCode = lmrDarmaApplicationProperties.getAmeriparkBrandCode();
		} else if (companyName.contains(lmrDarmaApplicationProperties
				.getPark1ComapanyName())) {
			brandCode = lmrDarmaApplicationProperties.getPark1BrandCode();

		}

		params.add("username", username);
		params.add("password", password);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "?grant_type=" + grant_type + "&" + "scope=" + scope
				+ "&" + "user_type=" + userType + "&" + "companyName="
				+ companyName + "&" + "brandCode=" + brandCode;

		HttpEntity<MultiValueMap<String, String>> accesstokenRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getLdapAccessTokenUri() + urlParam,
					HttpMethod.POST, accesstokenRequest, Object.class);

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

}
