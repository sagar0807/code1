package gov.naco.soch.aop;

import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.util.CommonConstants;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error("EXCEPTION -->", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(CommonConstants.INTERNAL_SERVER_ERROR, null, details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PSQLException.class)
	public final ResponseEntity<Object> handleAllPSQLException(Exception ex, WebRequest request) {
		logger.error("EXCEPTION -->", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(CommonConstants.INTERNAL_SERVER_ERROR, null, details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<Object> handleAccessDeniedAPIExceptions(Exception ex, WebRequest request) {
		logger.error("EXCEPTION -->", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(CommonConstants.FORBIDDEN, null, details);
		return new ResponseEntity(error, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public final ResponseEntity<Object> handleBadCredentialsExceptionException(Exception ex, WebRequest request) {
		logger.error("EXCEPTION -->", ex);
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(CommonConstants.BAD_CREDENTIALS, null, details);
		return new ResponseEntity(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ServiceException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(ServiceException serviceException,
			WebRequest request) {
		logger.error("EXCEPTION -->ServiceException-->", serviceException);
		ErrorResponse errorResponse;
		if (serviceException.getErrorResponse() != null) {
			return new ResponseEntity(serviceException.getErrorResponse(), serviceException.getHttpStatus());
		}
		List<String> details = new ArrayList<>();
		details.add(serviceException.getLocalizedMessage());
		errorResponse = new ErrorResponse(CommonConstants.INTERNAL_SERVER_ERROR, null, details);
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList();

		ErrorDto errorDto;
		FieldError fieldError;

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			errorDto = new ErrorDto();
			if (objectError instanceof FieldError) {
				fieldError = (FieldError) objectError;
				errorDto.setField(fieldError.getField());
			}
			errorDto.setDescription(objectError.getDefaultMessage());
			errorDtoList.add(errorDto);
			detailsSimplified.add(objectError.getDefaultMessage());
		}
		ErrorResponse errorResponse = new ErrorResponse(CommonConstants.VALIDATION_FAILED, errorDtoList,
				detailsSimplified);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}
}