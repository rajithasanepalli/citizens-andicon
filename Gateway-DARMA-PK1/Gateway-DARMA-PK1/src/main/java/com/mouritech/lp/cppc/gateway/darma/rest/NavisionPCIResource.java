package com.mouritech.lp.cppc.gateway.darma.rest;

import java.io.IOException;
import java.io.OutputStream;
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
import com.mouritech.lp.cppc.gateway.DTO.NavisionPCIDTO;
import com.mouritech.lp.cppc.gateway.DTO.SearchDTO;
import com.mouritech.lp.cppc.gateway.config.DarmaApplicationProperties;

/**
 * REST controller for managing Source.
 */

@RestController
@RequestMapping("system2/api/v1")
public class NavisionPCIResource {

	private final Logger log = LoggerFactory.getLogger(NavisionPCIResource.class);

	@Autowired
	private DarmaApplicationProperties applicationProperties;

	
	
	@RequestMapping(value = "/navisionpci/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navsionpciExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navisionPci based on page:%s and Per_page:%s ",
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
					applicationProperties.getNavisionpciExport(), HttpMethod.POST,
					reuestbody, byte[].class);
			if (result.getBody() != null && result.getBody().length > 0) {
				
				//UPDATE BEFORE RETURNING RESPONSE
				ResponseEntity<Boolean> updatedResult = restTemplate.exchange(
						applicationProperties.getNavisionpciExportUpdate(), HttpMethod.POST,
						reuestbody, Boolean.class);
				if(updatedResult.getBody()!=null && updatedResult.getBody().booleanValue()){
					// set content attributes for the response
					response.setContentType("application/octet-stream");
					// set headers for the response
					String headerKey = "Content-Disposition";
					String headerValue = String.format("attachment; filename=\"%s\"",
							"NavisionPCI.xlsx");
					response.setHeader(headerKey, headerValue);
					OutputStream os = response.getOutputStream();
					os.write(result.getBody());
				}
			}

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<byte[]>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	
	
	@RequestMapping(value = "/navisionpci", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<NavisionPCIDTO>> getAllNavisionPCIS(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get navisionPci based on page:%s and Per_page:%s ",
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

		ParameterizedTypeReference<List<NavisionPCIDTO>> responseType = new ParameterizedTypeReference<List<NavisionPCIDTO>>() {
		};
		ResponseEntity<List<NavisionPCIDTO>> result = null;
		try {
			result = restTemplate.exchange(
					applicationProperties.getNavisionpci() ,
					HttpMethod.POST, reuestbody, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<NavisionPCIDTO>>(
					HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;

	}
}
