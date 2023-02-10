package com.mouritech.lp.cppc.gateway.darma.rest;

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

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.SearchDTO;
import com.mouritech.lp.cppc.gateway.DTO.SourceDTO;
import com.mouritech.lp.cppc.gateway.DTO.vwNavisionDTO;
import com.mouritech.lp.cppc.gateway.DTO.vwSourcesForPostingDTO;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;

/**
 * REST controller for managing Source.
 */

@RestController
@RequestMapping("system2/api/v1")
public class SourceResource {

	private final Logger log = LoggerFactory.getLogger(SourceResource.class);

	@Autowired
	private DarmaApplicationProperties applicationProperties;

	/**
	 * 
	 * GET /source/:id -> GET ALL SOURCES BY REVENUE ID............!
	 * 
	 */

	@RequestMapping(value = "source/{revenueid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<SourceDTO>> getSourceByRevenueId(
			HttpServletRequest request, @RequestParam("page") String page,
			@RequestParam("per_page") String perPage,
			@PathVariable String revenueid) throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get source based on page:%s and Per_page:%s ",
				page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "/source/" + revenueid + "?page=" + page + "&"
				+ "per_page=" + perPage;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<SourceDTO>> responseType = new ParameterizedTypeReference<List<SourceDTO>>() {
		};
		ResponseEntity<List<SourceDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getSourceByRevenueUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<SourceDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * DELETE /source/:id -> DELETE SOURCES BY ID......!
	 */
	@RequestMapping(value = "/source/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> deleteSource(HttpServletRequest request,
			@PathVariable String id) throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get source based on revenueId:%s ", id));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + id;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(applicationProperties.getSourceUri()
					+ urlParam, HttpMethod.DELETE, getEmployeeRequest,
					Object.class);

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
	 * PUT /source -> RECONCILE SOURCE UPDATE.........!
	 */
	@RequestMapping(value = "/source/reconcile", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> reconcileUpdate(
			@Validated @RequestBody List<SourceDTO> sourceDTOs,
			HttpServletRequest request) throws InvalidAPIKeyException,
			URISyntaxException {
		log.debug("[revenueAndsource] REST request to recieved from  :",
				request.getRemoteAddr());

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// revenueDTO.setSessionId(request.getHeader("x-session-id"));
		// revenueDTO.setApproverId(applicationProperties.getApi_key());
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<List<SourceDTO>> reuestbody = new HttpEntity<List<SourceDTO>>(
				sourceDTOs, headers);

		ResponseEntity<SourceDTO> result = null;

		try {
			result = restTemplate.exchange(
					applicationProperties.getSourceReconcileUpdateUri(),
					HttpMethod.PUT, reuestbody, SourceDTO.class);

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
			result = new ResponseEntity<SourceDTO>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * GET /source -> GET ALL SOURCES FOR RECONCILE.........!
	 */
	@RequestMapping(value = "/source/reconcile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<vwSourcesForPostingDTO>> getSourceReconcile(
			HttpServletRequest request, @RequestParam("page") String page,
			@RequestParam("per_page") String perPage)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get reconcile based on page:%s and Per_page:%s ",
						page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
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
		ParameterizedTypeReference<List<vwSourcesForPostingDTO>> responseType = new ParameterizedTypeReference<List<vwSourcesForPostingDTO>>() {
		};
		ResponseEntity<List<vwSourcesForPostingDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getSourceReconcileUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<vwSourcesForPostingDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	/**
	 * GET /source -> GET ALL SOURCES FOR NAVISION.........!
	 */
	@RequestMapping(value = "/source/navision", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<vwNavisionDTO>> getSourceNavision(
			HttpServletRequest request, @RequestParam("page") String page,
			@RequestParam("per_page") String perPage,
			@RequestParam(value = "flag", required = false) Boolean flag)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navision based on page:%s and Per_page:%s ",
						page, perPage));
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "?page=" + page + "&" + "per_page=" + perPage + "&"
				+ "flag=" + flag;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ParameterizedTypeReference<List<vwNavisionDTO>> responseType = new ParameterizedTypeReference<List<vwNavisionDTO>>() {
		};
		ResponseEntity<List<vwNavisionDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getSourceNavisionUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<vwNavisionDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	// export

	@RequestMapping(value = "/navision/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navisionExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO,
			@RequestParam(value = "flag", required = false) Boolean flag)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navision based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		String urlParam = "?flag=" + flag;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getNavisonExport() + urlParam,
					HttpMethod.POST, reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "vwNavision.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();
			/*
			 * if (HttpStatus.Series.CLIENT_ERROR.equals(series)) { throw new
			 * HttpClientErrorException(result.getStatusCode()); } else if
			 * (HttpStatus.Series.SERVER_ERROR.equals(series)) { throw new
			 * HttpServerErrorException(result.getStatusCode()); }
			 */
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(value = "/navisionnew/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navisionNewExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO,
			@RequestParam(value = "flag", required = false) Boolean flag)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navisionNew based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		String urlParam = "?flag=" + flag;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getNavisonNewExport() + urlParam,
					HttpMethod.POST, reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "vwNavisionNew.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();
			/*
			 * if (HttpStatus.Series.CLIENT_ERROR.equals(series)) { throw new
			 * HttpClientErrorException(result.getStatusCode()); } else if
			 * (HttpStatus.Series.SERVER_ERROR.equals(series)) { throw new
			 * HttpServerErrorException(result.getStatusCode()); }
			 */
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/navisionnewameri/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navisionNewExportForAmeriPark(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO,
			@RequestParam(value = "flag", required = false) Boolean flag)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navisionNew based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		String urlParam = "?flag=" + flag;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getNavisonNewAmeriExport() + urlParam,
					HttpMethod.POST, reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "vwNavisionNewAmeri.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();
			/*
			 * if (HttpStatus.Series.CLIENT_ERROR.equals(series)) { throw new
			 * HttpClientErrorException(result.getStatusCode()); } else if
			 * (HttpStatus.Series.SERVER_ERROR.equals(series)) { throw new
			 * HttpServerErrorException(result.getStatusCode()); }
			 */
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	@RequestMapping(value = "/navisionnewpk1/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navisionNewExportForPk1(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO,
			@RequestParam(value = "flag", required = false) Boolean flag)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navisionNew based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		String urlParam = "?flag=" + flag;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getNavisonNewpk1Export() + urlParam,
					HttpMethod.POST, reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "vwNavisionNewPk1.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();
			/*
			 * if (HttpStatus.Series.CLIENT_ERROR.equals(series)) { throw new
			 * HttpClientErrorException(result.getStatusCode()); } else if
			 * (HttpStatus.Series.SERVER_ERROR.equals(series)) { throw new
			 * HttpServerErrorException(result.getStatusCode()); }
			 */
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(value = "/reconcile/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> reconcileExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get reconcile based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getReconcileExport(),
					HttpMethod.POST, reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "vwReconcile.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();

		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(value = "/source/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> sourceExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get source based on page:%s and Per_page:%s ",
				searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& apiKey.equalsIgnoreCase(applicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<SearchDTO> reuestbody = new HttpEntity<SearchDTO>(searchDTO,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getSourceExport(), HttpMethod.POST,
					reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				// set content attributes for the response
				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", "source.xlsx");
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			}

			HttpStatus.Series series = result.getStatusCode().series();

		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
