package com.maxlvshv.urfutask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Глобальный обработчик исключений для приложения.
 *
 * Этот класс использует аннотацию @ControllerAdvice для перехвата и обработки
 * исключений, возникающих в контроллерах. Он позволяет централизованно управлять
 * ошибками и возвращать соответствующие ответы клиенту.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<String> handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
