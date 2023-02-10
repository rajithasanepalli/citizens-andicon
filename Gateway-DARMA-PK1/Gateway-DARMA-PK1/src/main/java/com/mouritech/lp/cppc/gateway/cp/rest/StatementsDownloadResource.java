package com.mouritech.lp.cppc.gateway.cp.rest;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrDarmaApplicationProperties;

@RestController
@RequestMapping("system3/api/v1")
public class StatementsDownloadResource {

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	@Autowired
	private LmrDarmaApplicationProperties lmrDarmaApplicationProperties;

	private final Logger log = LoggerFactory.getLogger(StatementsResource.class);

	/**
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/statement/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAllDownload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "filePath") String filePath, @RequestParam(name = "resetKey") String resetKey)
			throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download statements file  : {}", filePath);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		String urlParam = "?filePath=" + filePath + "&resetKey=" + resetKey;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ResponseEntity<byte[]> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getStatementsExtDownload() + urlParam,
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
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/statement/download/userguide", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getDownloadUserGuide(HttpServletRequest request, HttpServletResponse response)
			throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download statements file  : {}");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);

		String urlParam = "/userguide/" + lmrDarmaApplicationProperties.getLanierBrandCode();
		ResponseEntity<byte[]> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getStatementsExtDownload() + urlParam,
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
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/statement/download/icon/userguide", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getDownloadUserGuideForIcon(HttpServletRequest request, HttpServletResponse response)
			throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download statements file  : {}");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String urlParam = "/userguide/" + lmrDarmaApplicationProperties.getiParkBrandCode();
		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(params, headers);

		ResponseEntity<byte[]> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getStatementsExtDownload() + urlParam,
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
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
