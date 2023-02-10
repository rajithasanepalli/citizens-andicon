package com.mouritech.lp.cppc.gateway.lmr.rest;

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

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.ConverterSearchDTO;
import com.mouritech.lp.cppc.gateway.DTO.FilePathDTO;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.SftpFileDetailsDto;
import com.mouritech.lp.cppc.gateway.DTO.UploadDTO;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;

/**
 * REST controller for managing RevenueTypes.
 */

@RestController
@RequestMapping("system2/api/v1")
public class FileHandlerResource {

	private final Logger log = LoggerFactory
			.getLogger(FileHandlerResource.class);
	
	@Autowired
	private LmrApplicationProperties applicationProperties;

	@Autowired
	private DarmaApplicationProperties darmaApplicationProperties;

	/**
	 * POST /RevenueTypes -> Create a new RevenueTypes.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public ResponseEntity<Object> handleFileupload(
			@RequestParam("file") MultipartFile file,
			 UploadDTO uploadDTO, HttpServletRequest request,
			HttpServletResponse response) throws InvalidAPIKeyException,
			URISyntaxException, IOException {
		log.debug("[File] REST request to recieved from  :",
				request.getRemoteAddr());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));

		// adding sessionid and Api_key to request object
		// revenueTypesDTO.setSessionId(request.getHeader("x-session-id"));
		// revenueTypesDTO.setApproverId(applicationProperties.getApi_key());

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(darmaApplicationProperties
								.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		final String filename = file.getOriginalFilename();
		map.add("name", filename);
		map.add("file", filename);
		ByteArrayResource contentsAsResource = new ByteArrayResource(
				file.getBytes()) {
			@Override
			public String getFilename() {
				return filename;
			}
		};
		map.add("file", contentsAsResource);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		/*
		 * HttpEntity<MultipartFile> reuestbody = new HttpEntity<MultipartFile>(
		 * file, headers);
		 */
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(
				map, headers);
		ResponseEntity<Object> result = null;
		String urlParam = "/" + uploadDTO.getBrandCode() + "/"
				+ uploadDTO.getPayGroup() + "/" + uploadDTO.getPayDate();

		try {
			result = restTemplate.exchange(applicationProperties.getUploadUri()
					+ urlParam, HttpMethod.POST, requestEntity, Object.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			} else {
				GatewayResult gatewayResult = new GatewayResult();
				gatewayResult.setStatus(HttpStatus.OK.value());
				gatewayResult.setMessage("File Uploaded Successfully");

				return ResponseEntity.ok().body(gatewayResult);
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<Object>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	@RequestMapping(value = "getfilelist/{BorG}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<SftpFileDetailsDto>> defaultFileUpload(
			@PathVariable("BorG") String BorG, HttpServletRequest request)
			throws InvalidAPIKeyException {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(darmaApplicationProperties
								.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "/" + BorG;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<SftpFileDetailsDto>> responseType = new ParameterizedTypeReference<List<SftpFileDetailsDto>>() {
		};
		ResponseEntity<List<SftpFileDetailsDto>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getGetListUri() + urlParam,
					HttpMethod.GET, getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<SftpFileDetailsDto>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	
	@RequestMapping(value = "getfilelist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getFiles(@RequestBody ConverterSearchDTO searchDTO, HttpServletRequest request)
			throws InvalidAPIKeyException {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(darmaApplicationProperties
								.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		HttpEntity<ConverterSearchDTO> reuestbody = new HttpEntity<ConverterSearchDTO>(
				searchDTO, headers);

		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getGetListUri(),HttpMethod.POST,
					reuestbody, Object.class);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<Object>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navsionpciExport(HttpServletRequest request,
			HttpServletResponse response, @RequestBody FilePathDTO filePathDTO)
			throws InvalidAPIKeyException {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(darmaApplicationProperties
								.getApiKey()))) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		String urlParam = "?filePath=" + filePathDTO.getFilePath() + "&"
				+ "flag=" + filePathDTO.getFlag();
		HttpEntity<MultiValueMap<String, String>> download = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);
		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getDownloadUri() + urlParam,
					HttpMethod.GET, download, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {

				response.setContentType("application/octet-stream");
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = result.getHeaders()
						.get("Content-Disposition").get(0);
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
}
