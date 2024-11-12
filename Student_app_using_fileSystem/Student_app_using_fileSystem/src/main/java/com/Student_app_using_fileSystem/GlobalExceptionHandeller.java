package com.Student_app_using_fileSystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandeller {

	
	@ExceptionHandler(NoResourceFoundException.class)
	public String noresourceFound(NoResourceFoundException exception) {
		
		StringBuffer s = new StringBuffer();
		
		s.append(" {  ");
		s.append(exception.getMessage());
		s.append(" }. ");
		return s.toString();
		
	}
	
	@ExceptionHandler(NotFound.class)
    public ResponseEntity<String> handleNotFoundException(NotFound ex) {
		
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
