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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.DashBoardClientDTO;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.DTO.PdfVarianceExplanation;
import com.mouritech.lp.cppc.gateway.DTO.VarianceExplanationDTO;
import com.mouritech.lp.cppc.gateway.config.CpApplicationProperties;

/**
 * REST controller for managing TN:VarianceExplanation.
 */
@RestController
@RequestMapping("system3/api/v1")
public class VarianceExplanationResource {

	private final Logger log = LoggerFactory.getLogger(VarianceExplanationResource.class);

	@Autowired
	private CpApplicationProperties cpApplicationProperties;

	/**
	 * POST /variance -> Create a new variance.
	 */
	@RequestMapping(value = "/varianceexp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@Validated @RequestBody List<VarianceExplanationDTO> varianceExplanationDTO,
			HttpServletRequest request) throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[TNforVarianceExplanation] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[TNforVarianceExplanation] REST request to save TNforVarianceExplanation : {}",
				varianceExplanationDTO);
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

		HttpEntity<List<VarianceExplanationDTO>> reuestbody = new HttpEntity<List<VarianceExplanationDTO>>(
				varianceExplanationDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getVarianceExplanation(), HttpMethod.POST,
					reuestbody, Object.class);

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
	 * PUT /variance -> update a new variance.
	 */
	@RequestMapping(value = "/varianceexp", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Validated @RequestBody VarianceExplanationDTO varianceExplanationDTO,
			HttpServletRequest request) throws InvalidAPIKeyException, URISyntaxException {
		log.debug("[TNforVarianceExplanation] REST request to recieved from  :", request.getRemoteAddr());
		log.debug("[TNforVarianceExplanation] REST request to save TNforVarianceExplanation : {}",
				varianceExplanationDTO);
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

		HttpEntity<VarianceExplanationDTO> reuestbody = new HttpEntity<VarianceExplanationDTO>(varianceExplanationDTO,
				headers);

		ResponseEntity<DashBoardClientDTO> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getVarianceExplanation(), HttpMethod.PUT, reuestbody,
					DashBoardClientDTO.class);

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
			result = new ResponseEntity<DashBoardClientDTO>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * GET /varianceexp/:id -> get the variance based on month ,year and location.
	 */
	@RequestMapping(value = "/varianceexp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<VarianceExplanationDTO>> getVariance(HttpServletRequest request,
			@RequestParam("month") Integer month, @RequestParam("year") Integer year,
			@RequestParam("locationId") String locationId) throws InvalidAPIKeyException {
		log.debug(String.format(
				"Rest request to get TNforVarianceExplanationDTO based on month %s, year %s and location %s ", month,
				year, locationId));

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

		String urlParam = "?month=" + month + "&" + "year=" + year + "&" + "locationId=" + locationId;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<MultiValueMap<String, String>>(
				params, headers);

		ParameterizedTypeReference<List<VarianceExplanationDTO>> responseType = new ParameterizedTypeReference<List<VarianceExplanationDTO>>() {
		};
		ResponseEntity<List<VarianceExplanationDTO>> result = null;

		try {
			result = restTemplate.exchange(cpApplicationProperties.getVarianceExplanation() + urlParam, HttpMethod.GET,
					getEmployeeRequest, responseType);

			HttpStatus.Series series = result.getStatusCode().series();
			if (HttpStatus.Series.CLIENT_ERROR.equals(series)) {
				throw new HttpClientErrorException(result.getStatusCode());
			} else if (HttpStatus.Series.SERVER_ERROR.equals(series)) {
				throw new HttpServerErrorException(result.getStatusCode());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<List<VarianceExplanationDTO>>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

		return result;
	}

	// export

	@SuppressWarnings("unused")
	@RequestMapping(value = "/varianceExporToPDF", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> navisionExport(@RequestBody PdfVarianceExplanation varianceExplanation,
			HttpServletRequest request, HttpServletResponse response) throws InvalidAPIKeyException {
		/*
		 * log.debug(String
		 * .format("Rest request to get navision based on page:%s and Per_page:%s ",
		 * searchDTO.getPage(), searchDTO.getPer_page()));
		 */

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

		HttpEntity<PdfVarianceExplanation> reuestbody = new HttpEntity<PdfVarianceExplanation>(varianceExplanation,
				headers);

		ResponseEntity<byte[]> result = null;
		try {
			result = restTemplate.exchange(cpApplicationProperties.getVarianceExport(), HttpMethod.POST, reuestbody,
					byte[].class);
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

			HttpStatus.Series series = result.getStatusCode().series();
		} catch (ResourceAccessException e) {
			throw new HttpServerErrorException(result.getStatusCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
