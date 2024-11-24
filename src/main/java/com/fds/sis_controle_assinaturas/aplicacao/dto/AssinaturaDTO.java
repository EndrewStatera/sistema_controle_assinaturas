package com.fds.sis_controle_assinaturas.dominio.dto;

import java.time.LocalDate;

public class AssinaturaDTO {
    private Long codigoAssinatura;
    private Long codigoCliente;
    private Long codigoAplicativo;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;

    // Construtores
    public AssinaturaDTO() {}

    public AssinaturaDTO(Long codigoAssinatura, Long codigoCliente, Long codigoAplicativo, LocalDate dataInicio, LocalDate dataEncerramento) {
        this.codigoAssinatura = codigoAssinatura;
        this.codigoCliente = codigoCliente;
        this.codigoAplicativo = codigoAplicativo;
        this.dataInicio = dataInicio;
        this.dataEncerramento = dataEncerramento;
    }

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
