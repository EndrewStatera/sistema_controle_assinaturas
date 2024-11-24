package com.fds.sis_controle_assinaturas.dominio.model;

import java.time.LocalDate;

public class AssinaturaModel {
    private Long codigoAssinatura;
    private Long codigoCliente;
    private Long codigoAplicativo;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;

    // Getters e Setters
    public Long getCodigoAssinatura() { return codigoAssinatura; }
    public void setCodigoAssinatura(Long codigoAssinatura) { this.codigoAssinatura = codigoAssinatura; }

    public Long getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(Long codigoCliente) { this.codigoCliente = codigoCliente; }

    public Long getCodigoAplicativo() { return codigoAplicativo; }
    public void setCodigoAplicativo(Long codigoAplicativo) { this.codigoAplicativo = codigoAplicativo; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataEncerramento() { return dataEncerramento; }
    public void setDataEncerramento(LocalDate dataEncerramento) { this.dataEncerramento = dataEncerramento; }
}
