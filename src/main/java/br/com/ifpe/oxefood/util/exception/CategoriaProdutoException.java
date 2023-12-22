package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class CategoriaProdutoException extends RuntimeException {

    public static final String MSG_NOME_CATEGORIA = "Essa categoria já existe.";

    public CategoriaProdutoException(String msg) {

        super(String.format(msg));
    }
}
