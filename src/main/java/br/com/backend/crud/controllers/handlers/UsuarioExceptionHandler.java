package br.com.backend.crud.controllers.handlers;

import br.com.backend.crud.exceptions.UsuarioNaoProcessadoException;
import br.com.backend.crud.messages.UsuarioMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(UsuarioNaoProcessadoException.class)
    public ResponseEntity unprocessable(UsuarioNaoProcessadoException ex) {
        logger.error(String.format(UsuarioMessage.LOG_USUARIO_NAO_PROCESSADO, ex.getUsuario()), ex);

        return ResponseEntity.status(ex.getStatus()).body(ex.getResponseErro());
    }
}
