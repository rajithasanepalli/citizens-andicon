package com.mouritech.lp.cppc.gateway.monthlypayments.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;
import com.mouritech.lp.cppc.gateway.monthlypayments.DTO.StatesDTO;
import com.mouritech.lp.cppc.gateway.monthlypayments.DTO.TimeParkDTO;
import com.mouritech.lp.cppc.gateway.monthlypayments.DTO.VehicleMakesDTO;
import com.mouritech.lp.cppc.gateway.monthlypayments.DTO.VehicleModelsDTO;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.CitiesDTO;
import com.mouritech.lp.cppc.gateway.tallysheet.DTO.ZipCodesDTO;
import com.mouritech.lp.cppc.gateway.views.TallySheetView;

@RestController
@RequestMapping("iparksystem/monthly/api")
public class DropDownResource {

	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;

	/**
	 * GET /garage -> get all garages.
	 */
	@JsonView(TallySheetView.DropdownGarages.class)
	@RequestMapping(value = "/vehiclemakes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<VehicleMakesDTO>> getAllVehicleMakes(HttpServletRequest request)
			throws InvalidAPIKeyException {

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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<VehicleMakesDTO>> responseType = new ParameterizedTypeReference<List<VehicleMakesDTO>>() {
		};
		ResponseEntity<List<VehicleMakesDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getVehiclemakes(), HttpMethod.GET,
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
	 * Get /transients/:id -> get the "id" transients.
	 */

	/**
	 * GET /garage -> get all garages.
	 */
	@JsonView(TallySheetView.DropdownGarages.class)
	@RequestMapping(value = "/vehiclemodels/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<VehicleModelsDTO>> getAllVehicleModels(HttpServletRequest request,
			@PathVariable("id") String id) throws InvalidAPIKeyException {

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

		String urlParam = "/" + id;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<VehicleModelsDTO>> responseType = new ParameterizedTypeReference<List<VehicleModelsDTO>>() {
		};
		ResponseEntity<List<VehicleModelsDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getVehiclemodels() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

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
	@RequestMapping(value = "/cities/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CitiesDTO>> getAllCitiess(HttpServletRequest request, @PathVariable("id") String id)
			throws InvalidAPIKeyException {

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

		String urlParam = "/" + id;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<CitiesDTO>> responseType = new ParameterizedTypeReference<List<CitiesDTO>>() {
		};
		ResponseEntity<List<CitiesDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getCities() + urlParam, HttpMethod.GET,
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

	// @JsonView(TallySheetView.DropdownGarages.class)
	@RequestMapping(value = "/zipcodes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ZipCodesDTO>> getAllZipCodes(HttpServletRequest request) throws InvalidAPIKeyException {

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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<ZipCodesDTO>> responseType = new ParameterizedTypeReference<List<ZipCodesDTO>>() {
		};
		ResponseEntity<List<ZipCodesDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getZipCodes(), HttpMethod.GET,
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
	@RequestMapping(value = "/zipcodes/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAllZipCodesByCode(HttpServletRequest request, @PathVariable("code") String code)
			throws InvalidAPIKeyException {

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

		String urlParam = "/" + code;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getZipCodes() + urlParam, HttpMethod.GET,
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
	@JsonView(TallySheetView.DropdownGarages.class)
	@RequestMapping(value = "/timepark", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<TimeParkDTO>> getAllTimePark(HttpServletRequest request) throws InvalidAPIKeyException {

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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<TimeParkDTO>> responseType = new ParameterizedTypeReference<List<TimeParkDTO>>() {
		};
		ResponseEntity<List<TimeParkDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getTimepark(), HttpMethod.GET,
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
	@JsonView(TallySheetView.DropdownGarages.class)
	@RequestMapping(value = "/states", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatesDTO>> getAllStates(HttpServletRequest request) throws InvalidAPIKeyException {

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

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);
		ParameterizedTypeReference<List<StatesDTO>> responseType = new ParameterizedTypeReference<List<StatesDTO>>() {
		};
		ResponseEntity<List<StatesDTO>> result = null;
		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getStates(), HttpMethod.GET,
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
	 * GET /location -> get all locations excluding child entities.
	 */
	@RequestMapping(value = "/residenttypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAll(HttpServletRequest request,
			@RequestParam(value = "garageId") String garageId
			)
			throws InvalidAPIKeyException {
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

		String urlParam = "?garageId=" + garageId ;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(
				params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getResident()+ urlParam, HttpMethod.GET,
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
