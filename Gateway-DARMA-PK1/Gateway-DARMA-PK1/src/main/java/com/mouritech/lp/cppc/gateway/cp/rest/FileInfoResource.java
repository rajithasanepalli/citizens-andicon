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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.mouritech.lp.cppc.gateway.DTO.StatementsDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;

@RestController
@RequestMapping("system3/api/v1")
public class FileInfoResource {

	private final Logger log = LoggerFactory.getLogger(FileInfoResource.class);

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	/**
	 * DELETE /locationContact -> DELETE locationContact.
	 */
	@RequestMapping(value = "/fileinfo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(HttpServletRequest request, @PathVariable("id") String id)
			throws InvalidAPIKeyException {
		log.debug(String.format("Rest request to delete fileInfo based on id:%s ", id));
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

		String urlParam = "/" + id;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(
				params, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getCpFileInfoUri() + urlParam, HttpMethod.DELETE,
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
	 * GET /statements -> download statements files.
	 */
	@RequestMapping(value = "/dashboard/download/{typeOfFormat}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> getAllDownload(HttpServletRequest request, HttpServletResponse response,
			@RequestBody StatementsDTO statementsDTO, @PathVariable(value = "typeOfFormat") String typeOfFormat) throws InvalidAPIKeyException {
		log.debug("[StatementsDTO] REST request to download dashboard statements file  : {}", statementsDTO);
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

		HttpEntity<StatementsDTO> requestbody = new HttpEntity<>(statementsDTO, headers);
		String urlPathVariable = "/" + typeOfFormat;
		ResponseEntity<byte[]> result = null;
		try {

			result = restTemplate.exchange(cpApplicationProperties.getDashboardFileDownload() + urlPathVariable, HttpMethod.POST,
					requestbody, byte[].class);

			if (result.getBody() != null && result.getBody().length > 0) {

				response.setContentType("application/octet-stream");
				String headerKey = "Content-Disposition";
				String headerValue = result.getHeaders().get("Content-Disposition").get(0);
				response.setHeader(headerKey, headerValue);
				OutputStream os = response.getOutputStream();
				os.write(result.getBody());
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
