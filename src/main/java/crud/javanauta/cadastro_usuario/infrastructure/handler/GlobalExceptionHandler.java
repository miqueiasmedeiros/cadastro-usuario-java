package crud.javanauta.cadastro_usuario.infrastructure.handler;

import crud.javanauta.cadastro_usuario.infrastructure.exceptions.BadRequestExceptions;
import crud.javanauta.cadastro_usuario.infrastructure.exceptions.GlobalExceptions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalExceptions.class)
    public ResponseEntity<Map<String, Object>> handlerPessoaFisicaNaoEncontrada(GlobalExceptions ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", 404,
                        "error", "Not Found",
                        "message", ex.getMessage()
                )
        );
    }


    @ExceptionHandler(BadRequestExceptions.class)
    public ResponseEntity<Map<String, Object>> handleCpfDuplicado(BadRequestExceptions ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status", 400,
                        "error", "Bad Request",
                        "message", ex.getMessage()
                )
        );
    }

}


