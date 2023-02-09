package ru.aservice.app.exception.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.aservice.app.api.model.ErrorDto;
import ru.aservice.app.exception.ResourceNotFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDto> catchResourceNotFoundException(ResourceNotFoundException e) {
        ErrorDto dto = new ErrorDto();
        dto.setCode(HttpStatus.NOT_FOUND.value());
        dto.setDescription(e.getMessage());
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> catchIllegalArgumentException(IllegalArgumentException e) {
        ErrorDto dto = new ErrorDto();
        dto.setCode(HttpStatus.BAD_REQUEST.value());
        dto.setDescription(e.getMessage());
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> catchNullPointerException(NullPointerException e) {
        ErrorDto dto = new ErrorDto();
        dto.setCode(HttpStatus.BAD_REQUEST.value());
        dto.setDescription("NullPointerException");
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
