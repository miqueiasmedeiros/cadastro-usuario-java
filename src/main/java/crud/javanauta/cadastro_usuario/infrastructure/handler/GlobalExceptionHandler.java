package crud.javanauta.cadastro_usuario.infrastructure.handler;

import crud.javanauta.cadastro_usuario.infrastructure.exceptions.PessoaFisicaExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PessoaFisicaExceptions.class)
        public ResponseEntity<Map<String, Object>> handlerPessoaFisicaNaoEncontrada(PessoaFisicaExceptions ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of(
                            "timestamp", LocalDateTime.now(),
                            "status",404,
                            "error", "Not Found",
                            "message", ex.getMessage()
                    )
            );
        }

}
