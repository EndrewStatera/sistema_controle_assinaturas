package com.fds.sis_controle_assinaturas.api.dto;

import java.time.LocalDate;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PagamentoDTO {

    private Long codigo;
    private Long assinaturaCodigo;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    // Constructors
    public PagamentoDTO(Long codigo, Long assinaturaCodigo, Float valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinaturaCodigo = assinaturaCodigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public PagamentoDTO(Long assinaturaCodigo, Float valorPago, LocalDate dataPagamento, String promocao) {
        this.assinaturaCodigo = assinaturaCodigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }



    // Overloaded constructor to create a DTO from a PagamentoModel
    public PagamentoDTO(PagamentoModel model) {
        this.codigo = model.getCodigo();
        this.assinaturaCodigo = model.getAssinatura() != null ? model.getAssinatura().getId() : null; // Assuming AssinaturaModel has a `getCodigo()` method
        this.valorPago = model.getValorPago();
        this.dataPagamento = model.getDataPagamento();
        this.promocao = model.getPromocao();
    }
}
