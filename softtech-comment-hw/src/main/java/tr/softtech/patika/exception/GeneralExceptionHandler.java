package tr.softtech.patika.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import tr.softtech.patika.model.exception.ErrorMessage;

import javax.persistence.EntityNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.MissingFormatArgumentException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<ErrorMessage> handleInvalidStatusException(IllegalStateException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.FORBIDDEN.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorMessage, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {MissingFormatArgumentException.class})
    public ResponseEntity<ErrorMessage> handleMissingArgumentsException(MissingFormatArgumentException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidPropertiesFormatException.class})
    public ResponseEntity<ErrorMessage> handleInvalidPropertiesFormatException(InvalidPropertiesFormatException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest webRequest) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ItemNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ParameterAlreadyExistException.class})
    public ResponseEntity<ErrorMessage> handleFileAlreadyExistsException(ParameterAlreadyExistException ex, WebRequest webRequest){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.CONFLICT.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(webRequest.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
    }

}
