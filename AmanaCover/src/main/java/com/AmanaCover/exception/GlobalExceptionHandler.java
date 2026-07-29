/**
 * Global exception handler for the application.
 *
 * <p>This class centralizes exception handling across all controllers
 * and ensures consistent API error responses.</p>
 *
 * <p>Handled exceptions include:</p>
 * <ul>
 *     <li>ResourceNotFoundException</li>
 *     <li>Validation exceptions</li>
 *     <li>Generic application exceptions</li>
 * </ul>
 *
 * @author Margaret Atieno
 * @since 1.0
 */

package com.AmanaCover.exception;

import com.AmanaCover.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExists(
            UserAlreadyExistsException ex
    ) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "error", ex.getMessage()
                ));
    }
}