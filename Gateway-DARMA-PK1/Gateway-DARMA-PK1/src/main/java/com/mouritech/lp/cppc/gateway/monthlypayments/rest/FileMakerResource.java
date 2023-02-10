package com.mouritech.lp.cppc.gateway.monthlypayments.rest;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;
import com.mouritech.lp.cppc.gateway.DTO.GatewayResult;
import com.mouritech.lp.cppc.gateway.config.TallySheetApplicationProperties;
import com.mouritech.lp.cppc.gateway.monthlypayments.DTO.MarketingDataDTO;

@RestController
@RequestMapping("filemaker/monthly/api")
public class FileMakerResource {

	private final Logger log = LoggerFactory.getLogger(FileMakerResource.class);

	@Autowired
	private TallySheetApplicationProperties tallySheetApplicationProperties;

	/**
	 * POST /customer -> Create a new GarageFlowDataDTO.
	 */
	@RequestMapping(value = "/marketingFlow", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@Validated @RequestBody MarketingDataDTO marketingDataDTO,
			HttpServletRequest request) throws InvalidAPIKeyException {
		log.debug("[Filemaker] REST request to save customer : {}", marketingDataDTO);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", request.getHeader("content-type"));
		headers.add("Content-Type", request.getHeader("content-type"));

		String apiKey = request.getHeader("API-KEY");
		if (apiKey != null && apiKey.equalsIgnoreCase(tallySheetApplicationProperties.getApiKey())) {
			headers.add("API-KEY", request.getHeader("API-KEY"));
		} else {

			throw new InvalidAPIKeyException("Invalid API Key");
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<MarketingDataDTO> reuestbody = new HttpEntity<>(marketingDataDTO, headers);

		ResponseEntity<Object> result = null;

		try {
			result = restTemplate.exchange(tallySheetApplicationProperties.getFileMaker(), HttpMethod.POST, reuestbody,
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

				return ResponseEntity.ok().body(result.getBody());
			}
		} catch (ResourceAccessException e) {
			result = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			throw new HttpServerErrorException(result.getStatusCode());
		}

	}

	/**
	 * GET /location -> get all locations excluding child entities.
	 */
	@RequestMapping(value = "/marketingFlow/paymentstatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAll(HttpServletRequest request,
			@RequestParam(value = "invoiceNumber") String invoiceNumber,
			@RequestParam(value = "cardType") String cardType, @RequestParam(value = "authCode") String authCode,
			@RequestParam(value = "authcode2") String authcode2, @RequestParam(value = "cardType2") String cardType2,
			@RequestParam(value = "cc1last4") String cc1last4, @RequestParam(value = "cc2last4") String cc2last4)
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

		String urlParam = "?invoiceNumber=" + invoiceNumber + "&" + "cardType=" + cardType + "&" + "authCode="
				+ authCode + "&" + "authcode2=" + authcode2 + "&" + "cardType2=" + cardType2 + "&" + "cc1last4="
				+ cc1last4 + "&" + "cc2last4=" + cc2last4;

		HttpEntity<MultiValueMap<String, String>> getEmployeeRequest = new HttpEntity<>(
				params, headers);
		ResponseEntity<Object> result = null;
		try {
			result = restTemplate.exchange(
					tallySheetApplicationProperties.getFileMaker() + "/" + "paymentstatus" + urlParam, HttpMethod.POST,
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
