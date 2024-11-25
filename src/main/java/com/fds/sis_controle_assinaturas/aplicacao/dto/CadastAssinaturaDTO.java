package com.fds.sis_controle_assinaturas.aplicacao.dto;

public class CadastAssinaturaDTO {
    private long cliente;
    private long app;

    public CadastAssinaturaDTO(long cliente, long app) {
        this.cliente = cliente;
        this.app = app;
    }

    public long getCliente() {
        return cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public long getApp() {
        return app;
    }

    public void setApp(long app) {
        this.app = app;
    }
}