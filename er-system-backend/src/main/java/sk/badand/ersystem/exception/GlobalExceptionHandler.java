package sk.badand.ersystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abadinka on 22. 9. 2016.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler({ServletException.class})
    public void handleBaseException(ServletException e, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Error occured: " + e.getMessage());
    }
}
