package com.mouritech.lp.cppc.gateway.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.mouritech.lp.cp.exceptions.ErrorMessageUtil;
import com.mouritech.lp.cp.exceptions.ErrorResponse;
import com.mouritech.lp.cp.exceptions.FieldErrorResource;
import com.mouritech.lp.cp.exceptions.InvalidAPIKeyException;

@ControllerAdvice
public class ControllerValidationHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse processValidationError(
			MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();

		return processFieldError(error);
	}

	private ErrorResponse processFieldError(FieldError error) {
		ErrorResponse message = ErrorMessageUtil.getErrorMessage(
				HttpStatus.BAD_REQUEST, null);
		if (error != null) {
			List<FieldErrorResource> fieldErrors = new ArrayList<FieldErrorResource>();
			FieldErrorResource errorResource = new FieldErrorResource();
			errorResource.setMessage(error.getDefaultMessage());
			errorResource.setField(error.getField());
			fieldErrors.add(errorResource);

			message.setFieldErrors(fieldErrors);
		}
		return message;
	}

	@ExceptionHandler(InvalidAPIKeyException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.FORBIDDEN.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorResponse> httpClientExceptionHandler(
			HttpClientErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(
				ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<ErrorResponse> httpServerExceptionHandler(
			HttpServerErrorException ex) {
		ErrorResponse error = ErrorMessageUtil.getErrorMessage(
				ex.getStatusCode(), ex);
		return new ResponseEntity<ErrorResponse>(error, ex.getStatusCode());
	}
}
