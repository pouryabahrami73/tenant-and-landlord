package ir.bs.tenant_and_landlord.controller;

import ir.bs.tenant_and_landlord.domain.dto.ErrorDTO;
import ir.bs.tenant_and_landlord.exception.AuthenticationException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
@EnableWebMvc
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = Logger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = AuthenticationException.class)
    protected ResponseEntity<ErrorDTO> handleAuthentication(AuthenticationException e) {
        logger.debug("requested entity not found exception handling...", e);
        logger.error(e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(e.getStatusCode(), e.getMessage(), Collections.singletonList(e.getMessage())));
    }

}
