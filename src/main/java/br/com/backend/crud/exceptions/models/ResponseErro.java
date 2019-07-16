package br.com.backend.crud.exceptions.models;

import java.util.Date;

public class ResponseErro {

    private final Date timestamp;
    private final String processo;
    private final String mensagem;

    public ResponseErro(Date timestamp, String processo, String mensagem) {
        this.timestamp = timestamp;
        this.processo = processo;
        this.mensagem = mensagem;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getProcesso() {
        return processo;
    }
}
