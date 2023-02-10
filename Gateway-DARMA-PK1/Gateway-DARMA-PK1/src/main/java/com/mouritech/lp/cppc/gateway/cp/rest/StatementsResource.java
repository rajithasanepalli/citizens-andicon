package com.mouritech.lp.cppc.gateway.cp.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
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
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.PublishedLocationsDTO;
import com.mouritech.lp.cppc.gateway.DTO.SearchDTO;
import com.mouritech.lp.cppc.gateway.DTO.StatementsDTO;
import com.mouritech.lp.cppc.gateway.DTO.StatusLocationsDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;
import com.mouritech.lp.cppc.gateway.views.View;

/**
 * REST controller for managing Statements.
 */
@RestController
@RequestMapping("system3/api/v1")
public class StatementsResource {

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	private final Logger log = LoggerFactory.getLogger(StatementsResource.class);

	/**
	 * POST /statements -> post the statement with file.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/statements", method = RequestMethod.POST, consumes = {
		MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Object> create(@RequestParam("file") MultipartFile[] file, StatementsDTO statementsDTO,
		HttpServletRequest request) throws InvalidAPIKeyException, URISyntaxException, IOException {
		log.debug("[Statements] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[Statements] REST request to save Statements : {}", statementsDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && (apiKey.equalsIgnoreCase(cpApplicationProperties.getCpIapiKey())
			|| apiKey.equalsIgnoreCase(cpApplicationProperties.getCpEapiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {
			throw new InvalidAPIKeyException("Invalid API Key");
		}
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		for (MultipartFile multipartFile : file) {
			final String filename = multipartFile.getOriginalFilename();
			ByteArrayResource contentsAsResource = new ByteArrayResource(multipartFile.getBytes()) {

				@Override
				public String getFilename() {
					return filename;
				}
			};
			map.add("file", contentsAsResource);
		}
		map.add("statementsDTO", statementsDTO);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri(), HttpMethod.POST, requestEntity,
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
	 * GET /statements/:id -> get the "id" statement.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/statements/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<StatementsDTO> getStatementOnId(HttpServletRequest request,
		@PathVariable("id") String statementId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get statements based on statementsId:%s ", statementId));
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
		String urlParam = "/" + statementId;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<StatementsDTO> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.GET,
				getEmployeeRequest, StatementsDTO.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<StatementsDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /statements -> get all the statements page.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/statements", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatementsDTO>> getAll(HttpServletRequest request,
		@RequestParam(value = "page", required = false) String page,
		@RequestParam(value = "per_page", required = false) String perPage) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get statements based on page:%s and Per_page:%s ", page, perPage));
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
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ParameterizedTypeReference<List<StatementsDTO>> responseType =
			new ParameterizedTypeReference<List<StatementsDTO>>() {
			};
		ResponseEntity<List<StatementsDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.GET,
				getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<StatementsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	@JsonView(View.Statement.class)
	@RequestMapping(value = "/statements/location/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatementsDTO>> getAllStatementWithLocation(HttpServletRequest request,
		@RequestParam(value = "page", required = false) String page,
		@RequestParam(value = "per_page", required = false) String perPage, @PathVariable("id") String locationId)
		throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get statements based on page:%s and Per_page:%s ", page, perPage));
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
		String urlParam = "/" + locationId + "?page=" + page + "&" + "per_page=" + perPage;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ParameterizedTypeReference<List<StatementsDTO>> responseType =
			new ParameterizedTypeReference<List<StatementsDTO>>() {
			};
		ResponseEntity<List<StatementsDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementWithLocationIdUri() + urlParam,
				HttpMethod.GET, getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<StatementsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * DELETE /statements/:id -> delete the "id" statements.
	 */
	@RequestMapping(value = "/statements/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteStatementsBasedonId(HttpServletRequest request,
		@PathVariable("id") String statementId) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to get burdeninfo based on statementsId:%s ", statementId));
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
		String urlParam = "/" + statementId;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.DELETE,
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
	 * GET /statements-> get all statements.
	 */
	@JsonView(View.Statement.class)
	@RequestMapping(value = "/statementslist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatementsDTO>> getAllStatements(HttpServletRequest request)
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
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ParameterizedTypeReference<List<StatementsDTO>> responseType =
			new ParameterizedTypeReference<List<StatementsDTO>>() {
			};
		ResponseEntity<List<StatementsDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsListUri(), HttpMethod.GET,
				getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<StatementsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAllDownload(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(name = "filePath") String filePath) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download statements file  : {}", filePath);
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
		String urlParam = "?filePath=" + filePath;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsDownloadUri() + urlParam,
				HttpMethod.GET, getEmployeeRequest, byte[].class);
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
	 * PUT /statements -> update a new statements.
	 */
	@RequestMapping(value = "/approvalprocess", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> approveStatements(@Validated @RequestBody List<StatementsDTO> statementsDTO,
		HttpServletRequest request) throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[statements] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[statements] REST request to update statements : {}", statementsDTO);
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
		HttpEntity<List<StatementsDTO>> reuestbody = new HttpEntity<List<StatementsDTO>>(statementsDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getApproveStatementsUri(), HttpMethod.PUT,
				reuestbody, Object.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.ALREADY_REPORTED.equals(result.getStatusCode())) {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String, GatewayResult> gatewayResult =
					(LinkedHashMap<String, GatewayResult>) result.getBody();
				return ResponseEntity.ok().body(gatewayResult);
			} else if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
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
	 * PUT /statements -> update a statements with multiple file.
	 */
	@RequestMapping(value = "/statements", method = RequestMethod.PUT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Object> updateStatements(@RequestParam("file") MultipartFile[] file,
		StatementsDTO statementsDTO, HttpServletRequest request)
		throws InvalidAPIKeyException, URISyntaxException, IOException {
		log.debug("[statements] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[statements] REST request to save statements : {}", file, statementsDTO);
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
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		for (MultipartFile multipartFile : file) {
			final String filename = multipartFile.getOriginalFilename();
			ByteArrayResource contentsAsResource = new ByteArrayResource(multipartFile.getBytes()) {

				@Override
				public String getFilename() {
					return filename;
				}
			};
			map.add("file", contentsAsResource);
		}
		map.add("statementsDTO", statementsDTO);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri(), HttpMethod.PUT, requestEntity,
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
	 * GET /statements-> get all statements by status.
	 */
	@RequestMapping(value = "/statementslist/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatusLocationsDTO>> getStatementsByStatus(HttpServletRequest request,
		@PathVariable("status") String status) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to get all statements by statement status");
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
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ParameterizedTypeReference<List<StatusLocationsDTO>> responseType =
			new ParameterizedTypeReference<List<StatusLocationsDTO>>() {
			};
		ResponseEntity<List<StatusLocationsDTO>> result = null;
		String urlParam = "/" + status;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsListUri() + urlParam, HttpMethod.GET,
				getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<StatusLocationsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /statements-> get all statements by status.
	 */
	@RequestMapping(value = "/publishedlastmonth/{locationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<StatusLocationsDTO> getPublishedLastMonth(HttpServletRequest request,
		@PathVariable("locationId") String locationId) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to get all statements by statement status");
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
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<StatusLocationsDTO> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + "/pubstatus/" + locationId,
				HttpMethod.GET, getEmployeeRequest, StatusLocationsDTO.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<StatusLocationsDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /Locations which are not yet final,near to deadline of three days
	 */
	@RequestMapping(value = "/statementsforfinal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<StatusLocationsDTO>> getStatmentsForFinal(HttpServletRequest request)
		throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to get all statements by statement status");
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
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ParameterizedTypeReference<List<StatusLocationsDTO>> responseType =
			new ParameterizedTypeReference<List<StatusLocationsDTO>>() {
			};
		ResponseEntity<List<StatusLocationsDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsListUri() + "/final", HttpMethod.GET,
				getEmployeeRequest, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<StatusLocationsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/download/zip", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> downloadZip(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(name = "locationId") String locationId, @RequestParam(name = "month") Integer month,
		@RequestParam(name = "year") Integer year) throws InvalidAPIKeyException {
		log.debug("REST request to download statements as zip file based on location id %s, month %s and year %s:",
			locationId, month, year);
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
		String urlParam = "/zip" + "?locationId=" + locationId + "&" + "month=" + month + "&" + "year=" + year;
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest =
			new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsDownloadUri() + urlParam,
				HttpMethod.GET, getEmployeeRequest, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {
				/*
				 * response.setContentType("application/octet-stream"); // set headers for the response String headerKey
				 * = "Content-Disposition"; String headerValue = result.getHeaders() .get("Content-Disposition").get(0);
				 * response.setHeader(headerKey, headerValue);
				 */
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			} else {
				/*
				 * GatewayResult gatewayResult = new GatewayResult();
				 * gatewayResult.setStatus(HttpStatus.NO_CONTENT.value()); gatewayResult.setMessage("No Content");
				 */
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
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

	// export to excel call
	@RequestMapping(value = "/statements/excelexport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> statementExcelExport(HttpServletRequest request, HttpServletResponse response,
		@Validated @RequestBody SearchDTO searchDTO) throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to export get statements based ", searchDTO.getPage(),
			searchDTO.getPer_page()));
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
		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO, headers);
		ResponseEntity<byte[]> result = null;
		String urlParam = "/approvalexcel";
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.POST,
				reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {
				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", "NavisionPCI.xlsx");
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

	// pdfexport for approval process
	@RequestMapping(value = "/statements/pdfexport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> statementPdfExport(@RequestBody SearchDTO searchDTO, HttpServletRequest request,
		HttpServletResponse response) throws InvalidAPIKeyException {
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
		// String urlParam = "?flag=" + flag;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO, headers);
		ResponseEntity<byte[]> result = null;
		String urlParam = "/pdfexport";
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.POST,
				reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {
				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", "varianceExpor.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}
			@SuppressWarnings("unused")
			HttpStatus.Series series = result.getStatusCode().series();
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * GET /Specific for multiple location search in External portal
	 */
	@RequestMapping(value = "/publishedlocationlist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<PublishedLocationsDTO>> getPublishedLocationsMonth(
		@RequestBody List<PublishedLocationsDTO> publishedLocationsDTO, HttpServletRequest request,
		HttpServletResponse response) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to get all statements by statement status");
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
		HttpEntity<List<PublishedLocationsDTO>> reuestbody =
			new HttpEntity<List<PublishedLocationsDTO>>(publishedLocationsDTO, headers);
		ParameterizedTypeReference<List<PublishedLocationsDTO>> responseType =
			new ParameterizedTypeReference<List<PublishedLocationsDTO>>() {
			};
		ResponseEntity<List<PublishedLocationsDTO>> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + "/publishedlocationlist",
				HttpMethod.POST, reuestbody, responseType);
			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<PublishedLocationsDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}
		return result;
	}

	/**
	 * GET /Specific for multiple location search in External portal
	 */
	@RequestMapping(value = "/statements/unapprove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> unapproveStatement(HttpServletRequest request, HttpServletResponse response,
		@RequestBody StatementsDTO statementsDTO) throws InvalidAPIKeyException {
		log.debug("[location] REST request to un-approve statement for month %s and year %s and location %s",
			statementsDTO.getMonth(), statementsDTO.getYear(), statementsDTO.getLocation().getId());
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
		String urlParam = "/unapprove";
		HttpEntity<StatementsDTO> reuestbody = new HttpEntity<>(statementsDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.POST,
				reuestbody, Object.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (result.getStatusCodeValue() == 208) {
				GatewayResult gatewayResult = new GatewayResult();
				gatewayResult.setStatus(HttpStatus.ALREADY_REPORTED.value());
				gatewayResult.setMessage("The statement has already been published, cannot be un-approved");
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(gatewayResult);
			} else if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
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

	@RequestMapping(value = "/statements/customdocs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> generateCustomPdfAndExcel(HttpServletRequest request, HttpServletResponse response,
		@RequestBody StatementsDTO statementsDTO) throws InvalidAPIKeyException {
		log.debug("[location] REST request to generate custom PDF and Excel for month %s and year %s and location %s",
			statementsDTO.getMonth(), statementsDTO.getYear(), statementsDTO.getLocation().getId());
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
		String urlParam = "/customdocs";
		HttpEntity<StatementsDTO> reuestbody = new HttpEntity<>(statementsDTO, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getStatementsUri() + urlParam, HttpMethod.POST,
				reuestbody, Object.class);
			HttpStatus.Series series = result.getStatusCode().series();
			if (result.getStatusCodeValue() == 208) {
				GatewayResult gatewayResult = new GatewayResult();
				gatewayResult.setStatus(HttpStatus.ALREADY_REPORTED.value());
				gatewayResult.setMessage("The statement has already been published, cannot be un-approved");
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(gatewayResult);
			} else if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
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
}
