package org.openapi.openapispring.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


// controller advice listen to error that was not handled  and detect it eg.IllegalArgumentException
// global error handler for all controllers.
@ControllerAdvice
public class GlobalErrorHandler {

    // The handler creates a Message object and returns it as a json response with a 400 Bad Request status.
    // Handles invalid product IDs
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Message> handle400Exception(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new Message(ex.getMessage()));
    }

    // Handle product not found cases
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Message> handle404Exception(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message(ex.getMessage()));
    }

    // Handle product not found cases
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Message> handle400Exception(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new Message(ex.getMessage()));
    }



}
