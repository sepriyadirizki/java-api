package com.bootcamp.rekening.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.rekening.model.dto.CommonRespons;

import javassist.NotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);
		
		@SuppressWarnings("rawtypes")
		@ExceptionHandler(value=UserException.class)
		public ResponseEntity<CommonRespons> resp(UserException e){
			LOGGER.error(e.getMessage());
			LOGGER.warn(e.getMessage());
			LOGGER.info(e.getMessage());
			LOGGER.debug(e.getMessage());
			return new ResponseEntity<CommonRespons> (new CommonRespons(e.getCode(), e.getDescription()), HttpStatus.OK);
		}

		@ExceptionHandler(value=EntityNotFoundException.class)
		public ResponseEntity<CommonRespons> catchEntityNotFound(EntityNotFoundException e){
			LOGGER.error(e.getMessage());
			LOGGER.warn(e.getMessage());
			LOGGER.info(e.getMessage());
			LOGGER.debug(e.getMessage());
			return new ResponseEntity<CommonRespons> (new CommonRespons(e.getCode(), e.getDescription()), HttpStatus.OK);
		}
		
		@ExceptionHandler(value=Exception.class)
		public ResponseEntity<CommonRespons> catchEntityNotFound(Exception e){
			LOGGER.error(e.getMessage());
			LOGGER.warn(e.getMessage());
			LOGGER.info(e.getMessage());
			LOGGER.debug(e.getMessage());
			return new ResponseEntity<CommonRespons> (new CommonRespons("500", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@ExceptionHandler(value=HttpRequestMethodNotSupportedException.class)
		public ResponseEntity<CommonRespons> catchEntityNotFound(HttpRequestMethodNotSupportedException e){
			LOGGER.error(e.getMessage());
			LOGGER.warn(e.getMessage());
			LOGGER.info(e.getMessage());
			LOGGER.debug(e.getMessage());
			return new ResponseEntity<CommonRespons> (new CommonRespons("405", e.getMessage()), HttpStatus.OK);
		}
		

}
