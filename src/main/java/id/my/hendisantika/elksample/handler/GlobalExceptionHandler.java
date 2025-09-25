package id.my.hendisantika.elksample.handler;

import id.my.hendisantika.elksample.entity.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elk-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 25/09/25
 * Time: 16.58
 * To change this template use File | Settings | File Templates.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleException(RuntimeException ex) {
        log.info("START - handleException, exception: {}", ex.getMessage());

        var exceptionResponse = ExceptionResponse.builder().message(ex.getMessage()).build();

        log.info("END - handleException");

        return ResponseEntity
                .internalServerError()
                .body(exceptionResponse);
    }
}
