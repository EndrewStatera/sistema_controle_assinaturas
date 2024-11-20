package com.fds.sis_controle_assinaturas.persistencia.Entities;

import java.time.LocalDate;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "assinatura_id", nullable = false)
    private Assinatura assinatura;
    @Column(name = "valor_pago", nullable = false)
    private Float valorPago;
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;
    @Column(name = "promocao")
    private String promocao;

    public Pagamento(Assinatura assinatura, Float valorPago, LocalDate dataPagamento, String promocao){
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamento){
        return new Pagamento(Assinatura.fromAssinaturaModel(pagamento.getAssinatura()),
                                pagamento.getValorPago(),
                                pagamento.getDataPagamento(),
                                pagamento.getPromocao());
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento){
        return new PagamentoModel(pagamento.getCodigo(),
                                    Assinatura.toAssinaturaModel(pagamento.getAssinatura()),
                                    pagamento.getValorPago(),
                                    pagamento.getDataPagamento(),
                                    pagamento.getPromocao());
    }
}
