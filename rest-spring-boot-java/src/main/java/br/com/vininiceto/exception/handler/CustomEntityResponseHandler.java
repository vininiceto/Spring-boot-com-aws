package br.com.vininiceto.exception.handler;

import br.com.vininiceto.exception.ExpcetionResponse;
import br.com.vininiceto.exception.RequiredObjectNullException;
import br.com.vininiceto.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler
{

   private final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExpcetionResponse> handleAllExceptions(Exception ex, WebRequest request){
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExpcetionResponse response = new ExpcetionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequiredObjectNullException.class)
    public final ResponseEntity<ExpcetionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExpcetionResponse response = new ExpcetionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler( Exception.class)
    public final ResponseEntity<ExpcetionResponse> handleNotFoundxceptions(Exception ex, WebRequest request){
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExpcetionResponse response = new ExpcetionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
