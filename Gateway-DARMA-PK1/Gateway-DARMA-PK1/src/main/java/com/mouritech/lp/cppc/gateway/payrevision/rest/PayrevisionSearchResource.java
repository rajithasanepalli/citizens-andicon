package com.mouritech.lp.cppc.gateway.payrevision.rest;

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
import com.mouritech.lp.cppc.gateway.config.LmrApplicationProperties;
import com.mouritech.lp.cppc.gateway.config.PayrevisionApplicationProperties;

/**
 * REST controller for managing payrollrevisions.
 */

@RestController
@RequestMapping("system2/api/v1")
public class PayrevisionSearchResource {

	private final Logger log = LoggerFactory
			.getLogger(PayrevisionSearchResource.class);

	@Autowired
	private PayrevisionApplicationProperties payrevisionApplicationProperties;

	@Autowired
	private LmrApplicationProperties applicationProperties;
	
	@RequestMapping(value = "/payrevisionsearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> serachRevenue(HttpServletRequest request,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get payrevision based on page:%s and Per_page:%s ",
						searchDTO.getPage(), searchDTO.getPer_page()));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(payrevisionApplicationProperties
								.getApiKey()))) {
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
					payrevisionApplicationProperties.getPayRevisionSearchUri(),
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
	
	@RequestMapping(value = "/payrevision/export", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> payrevisionExport(HttpServletRequest request,
			HttpServletResponse response,
			@Validated @RequestBody SearchDTO searchDTO)
			throws InvalidAPIKeyException {
		log.debug(String
				.format("Rest request to get payrevision"));

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", request.getHeader("authorization"));
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("x-session-id", request.getHeader("x-session-id"));
		headers.add("Accept", request.getHeader("Accept"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null
				&& (apiKey.equalsIgnoreCase(applicationProperties.getApiKey()) || apiKey
						.equalsIgnoreCase(payrevisionApplicationProperties
								.getApiKey()))) {
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
					payrevisionApplicationProperties.getPayrevisionExportUri(),
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

			//HttpStatus.Series series = result.getStatusCode().series();
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
}
