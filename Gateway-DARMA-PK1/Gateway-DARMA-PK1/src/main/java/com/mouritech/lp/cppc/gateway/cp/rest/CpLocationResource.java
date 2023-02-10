package com.mouritech.lp.cppc.gateway.cp.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.CpLocationDTO;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.LocationDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;
import com.mouritech.lp.cppc.gateway.views.View;

/**
 * REST controller for managing location.
 */
@RestController
@RequestMapping("system3/api/v1")
public class CpLocationResource {

	private final Logger log = LoggerFactory.getLogger(CpLocationResource.class);

	@Autowired
	private LmrApplicationProperties applicationProperties;

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	/**
	 * GET /location/:id -> get the "id" location.
	 */
	@RequestMapping(value = "/location", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<LocationDTO> getLocationBasedOnId(HttpServletRequest request,
			@RequestParam("id") String locationId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get location based on locationId:%s ", locationId));
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

		String urlParam = "/" + locationId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<LocationDTO> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri() + urlParam, HttpMethod.GET,
					getEmployeeRequest, LocationDTO.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<LocationDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /location -> get all locations excluding child entities.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CpLocationDTO>> getAll(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get location based on page:%s and Per_page:%s ", page, perPage));
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

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<CpLocationDTO>> responseType = new ParameterizedTypeReference<List<CpLocationDTO>>() {
		};
		ResponseEntity<List<CpLocationDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri() + urlParam, HttpMethod.GET,
					getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<CpLocationDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * added for client portal GET /locationswithstatement -> get all locations with
	 * statements and location contact
	 */
	@RequestMapping(value = "/locationwithstatements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<LocationDTO>> getAllWithStatements(HttpServletRequest request,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "per_page", required = false) Integer perPage) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get Location based on page:%s and Per_page:%s ", page, perPage));
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

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<LocationDTO>> responseType = new ParameterizedTypeReference<List<LocationDTO>>() {
		};
		ResponseEntity<List<LocationDTO>> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getLocationWithStatementsUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<LocationDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * PUT /location -> update existing Location.
	 */
	@RequestMapping(value = "/location", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Validated @RequestBody CpLocationDTO locationDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[Location] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[Location] REST request to update Location : {}", locationDTO);
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

		HttpEntity<CpLocationDTO> reuestbody = new HttpEntity<CpLocationDTO>(locationDTO, headers);

		ResponseEntity<CpLocationDTO> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri(), HttpMethod.PUT, reuestbody,
					CpLocationDTO.class);

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
			result = new ResponseEntity<CpLocationDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * PUT /location -> upload icon for location.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/iconLocations", method = RequestMethod.PUT, consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Object> create(@RequestParam("file") MultipartFile file,
			@RequestParam("locationID") String locationID, LocationDTO locationDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException, IOException {
		log.debug("[Location] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[Location] REST request to upload Location icon : {}", locationDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		// headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && (apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
				|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey())
				|| apiKey.equalsIgnoreCase(applicationProperties.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

		final String filename = file.getOriginalFilename();
		ByteArrayResource contentsAsResource = new ByteArrayResource(file.getBytes()) {
			@Override
			public String getFilename() {
				return filename;
			}
		};
		map.add("file", contentsAsResource);
		map.add("locationID", locationID);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

		ResponseEntity<Object> result = null;

		try {

			result = restTemplate.exchange(cpApplicationProperties.getLocationIconUpoad() + "/icon", HttpMethod.PUT,
					requestEntity, Object.class);

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
	 * GET /statements -> download location icon.
	 */
	@RequestMapping(value = "/downloadIcon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAllDownload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "iconName") String iconName) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download location icon image  : {}", iconName);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		// headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "/icondownload?iconName=" + iconName;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<byte[]> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getLocationIconUpoad() + urlParam, HttpMethod.GET,
					getEmployeeRequest, byte[].class);

			if (result.getBody() != null && result.getBody().length > 0) {

				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = result.getHeaders().get("Content-Disposition").get(0);
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<byte[]>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * DELETE /location Icon -> DELETE location Icon.
	 */
	@RequestMapping(value = "/deleteIcon/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @PathVariable("id") String id)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to delete location icon based on location id:%s ", id));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
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

		String urlParam = "/icondelete/" + id;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getLocationIconUpoad() + urlParam, HttpMethod.DELETE,
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

	/**
	 * GET /location -> get all locations excluding child entities.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/locations/pos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CpLocationDTO>> getAllPOSLocations(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "per_page", required = false) String perPage) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get pos location based on page:%s and Per_page:%s ", page, perPage));
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

		String urlParam = "/pos" + "?page=" + page + "&" + "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<CpLocationDTO>> responseType = new ParameterizedTypeReference<List<CpLocationDTO>>() {
		};
		ResponseEntity<List<CpLocationDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri() + urlParam, HttpMethod.GET,
					getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<CpLocationDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * POST /location -> Create a new location.
	 */
	@RequestMapping(value = "/location", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody CpLocationDTO locationDTO, HttpServletRequest request)
			throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[location] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[location] REST request to save location : {}", locationDTO);
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

		HttpEntity<CpLocationDTO> reuestbody = new HttpEntity<CpLocationDTO>(locationDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri(), HttpMethod.POST, reuestbody,
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
			result = new ResponseEntity<Object>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}
	
	/**
	 * POST /location -> Create a new location.
	 */
	@RequestMapping(value = "/location/close", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> closeLocations(HttpServletRequest request,
			@RequestParam(value = "locationId", required =true) String locationId,
			@RequestParam(value = "isClosed", required =true) Boolean isClosed)
			throws InvalidAPIKeyException {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
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
		
		String urlParam = "/close"+"?locationId=" + locationId + "&" + "isClosed=" + isClosed;
		
		HttpEntity<Object> reuestbody = new HttpEntity<>(headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri() + urlParam , HttpMethod.POST, reuestbody,
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
	 * GET /location -> get all locations excluding child entities.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/locations/additional", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CpLocationDTO>> getLocations(HttpServletRequest request) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get locations"));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
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

		String urlParam = "/additional";

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(
				params, headers);
		ParameterizedTypeReference<List<CpLocationDTO>> responseType = new ParameterizedTypeReference<List<CpLocationDTO>>() {
		};
		ResponseEntity<List<CpLocationDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpLocationsUri() + urlParam, HttpMethod.GET,
					getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<CpLocationDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}
	

    @JsonView({ View.DropdownLocation.class })
    @RequestMapping(value = { "/cplocationsonly" }, method = { RequestMethod.GET }, produces = { "application/json" })
    @ResponseBody
    public ResponseEntity<List<LocationDTO>> getLocationDropdownListForCP(final HttpServletRequest request, @RequestParam(value = "page", required = false) final String page, @RequestParam(value = "per_page", required = false) final String perPage) throws InvalidAPIKeyException {
        log.debug(String.format("Rest request to get location based on page:%s and Per_page:%s ", page, perPage));
        MultiValueMap<String, String> params = (MultiValueMap<String, String>)new LinkedMultiValueMap();
        MultiValueMap<String, String> headers = (MultiValueMap<String, String>)new LinkedMultiValueMap();
        headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));
        final String apiKey = request.getHeader("API-KEY");
        if (apiKey != null && (apiKey.equalsIgnoreCase(this.cpApplicationProperties.getCpIapiKey()) || apiKey.equalsIgnoreCase(this.cpApplicationProperties.getCpEapiKey()))) {
        	headers.add("API-KEY", request.getHeader("API-KEY"));
            final RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            String urlParam = "?page=" + page + "&" + "per_page=" + perPage;
            HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = (HttpEntity<MultiValueMap<String, String>>)new HttpEntity((Object)params, (MultiValueMap)headers);
            ParameterizedTypeReference<List<LocationDTO>> responseType = new ParameterizedTypeReference<List<LocationDTO>>() {
    		};
            ResponseEntity<List<LocationDTO>> result = null;
           
            try {
                result = (ResponseEntity<List<LocationDTO>>)restTemplate.exchange(String.valueOf(cpApplicationProperties.getLocationDataOnly()) + urlParam, HttpMethod.GET, (HttpEntity)getEmployeeRequest, (ParameterizedTypeReference)responseType, new Object[0]);
                final HttpStatus.Series series = result.getStatusCode().series();
                if (HttpStatus.Series.CLIENT_ERROR.equals((Object)series)) {
                    throw new HttpClientErrorException(result.getStatusCode());
                }
                if (HttpStatus.Series.SERVER_ERROR.equals((Object)series)) {
                    throw new HttpServerErrorException(result.getStatusCode());
                }
            }
            catch (ResourceAccessException e) {
                result = (ResponseEntity<List<LocationDTO>>)new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
                throw new HttpServerErrorException(result.getStatusCode());
            }
            return result;
        }
        throw new InvalidAPIKeyException("Invalid API Key");
    }
}
