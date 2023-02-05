package spring.rest.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> handleException(NoSuchEmployeeException exception){

        EmployeeExceptionResponse response = new EmployeeExceptionResponse();
        response.setInfo(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> handleException(NegativeIdNumberException e){

        EmployeeExceptionResponse response = new EmployeeExceptionResponse();
        response.setInfo(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> handleException(Exception e){

        EmployeeExceptionResponse response = new EmployeeExceptionResponse();
        response.setInfo(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
