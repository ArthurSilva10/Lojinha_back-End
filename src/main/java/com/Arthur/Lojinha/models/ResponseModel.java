package com.Arthur.Lojinha.models;

import org.springframework.stereotype.Component;

@Component
public class ResponseModel
{
    private String resposta;

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
