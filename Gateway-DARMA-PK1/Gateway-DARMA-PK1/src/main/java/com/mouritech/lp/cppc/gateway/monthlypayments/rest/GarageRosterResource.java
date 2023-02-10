package com.mouritech.lp.cppc.gateway.monthlypayments.rest;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;

@RestController
@RequestMapping("iparksystem/monthly/api")
public class GarageRosterResource {

	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;

	/**
	 * GET /garageRoster -> get all garages.
	 */
	@RequestMapping(value = "/garageroster", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAllVehicleModels(HttpServletRequest request,
			@RequestParam(value = "garageId") Integer garageId) throws InvalidAPIKeyException {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "?garageId=" + garageId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<Object> responseType = new ParameterizedTypeReference<Object>() {
		};
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getGarageRoster() + urlParam, HttpMethod.GET,
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
	 * GET /garage -> get all garages.
	 */
	@RequestMapping(value = "/garageroster/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAll(HttpServletRequest request, @RequestParam(value = "garageId") Integer garageId,
			@RequestParam(value = "accountCode") Integer accountCode) throws InvalidAPIKeyException {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "?garageId=" + garageId + "&" + "accountCode=" + accountCode;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getGarageRoster() + "/" + "details" + urlParam, HttpMethod.GET,
					getEmployeeRequest, Object.class);

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
	 * GET /garage -> get all garages.
	 */
	@RequestMapping(value = "/garageroster/detailsview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getDetailsView(HttpServletRequest request,@RequestParam(value = "tenantId") Integer tenantId) throws InvalidAPIKeyException {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "?tenantId=" + tenantId;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getGarageRoster() + "/" + "detailsview" + urlParam, HttpMethod.GET,
					getEmployeeRequest, Object.class);

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
