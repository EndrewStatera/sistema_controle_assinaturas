package com.fds.sis_controle_assinaturas.dominio.model;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PagamentoModel {

    private Long codigo;
    private AssinaturaModel assinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoModel(AssinaturaModel assinatura, Float valorPago, LocalDate dataPagamento, String promocao){
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

}
