package com.mouritech.lp.cppc.gateway.tallysheet.rest;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.SearchDTO;
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.MissingTallySheetAndTotalDTO;

@RestController
@RequestMapping("system4/tally/api/search")
public class TransientsSearchResource {
	private final Logger log = LoggerFactory.getLogger(TransientsSearchResource.class);
	
	
	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;
	/**
	 * POST /search -> 
	 */
	@RequestMapping(value = "/missingdatesandtotals", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MissingTallySheetAndTotalDTO> getMissingDatesAndTotals(
			@Validated @RequestBody SearchDTO searchDTO,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[searchDTO] REST request to recieved from  :",
				request.getRemoteAddr());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Content-Type", request.getHeader("content-type"));

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

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<MissingTallySheetAndTotalDTO> result = null;

		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getMissingDatesAndTotalsUri(), HttpMethod.POST,
					reuestbody,MissingTallySheetAndTotalDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<MissingTallySheetAndTotalDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}
	
	
	
	
	@RequestMapping(value = "/transients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> searchLocation(HttpServletRequest request,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get tallysheet "));

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

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getTransientSearchUri(),
					HttpMethod.POST, reuestbody, Object.class);

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