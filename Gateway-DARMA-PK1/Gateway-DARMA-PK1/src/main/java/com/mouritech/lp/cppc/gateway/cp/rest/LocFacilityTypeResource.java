package com.mouritech.lp.cppc.gateway.cp.rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.LocFacilityTypeDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;

/**
 * REST controller for managing Statements.
 */
@RestController
@RequestMapping("system3/api/v1")
public class LocFacilityTypeResource {

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	private final Logger log = LoggerFactory.getLogger(LocFacilityTypeResource.class);

	/**
	 * GET /statements-> get all statements.
	 */
	@RequestMapping(value = "/locfacilitytype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<LocFacilityTypeDTO>> getAllStatements(HttpServletRequest request)
			throws InvalidAPIKeyException {

		log.debug("[StatementsDTO] REST request to get all statements");
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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<LocFacilityTypeDTO>> responseType = new ParameterizedTypeReference<List<LocFacilityTypeDTO>>() {
		};
		ResponseEntity<List<LocFacilityTypeDTO>> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getLocfacilitytype(), HttpMethod.GET,
					getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<LocFacilityTypeDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

}
