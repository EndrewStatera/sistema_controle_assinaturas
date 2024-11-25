package com.fds.sis_controle_assinaturas.dominio.model;


import java.time.LocalDate;

import com.fds.sis_controle_assinaturas.persistencia.Entities.Promocao;
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
    private PromocaoModel promocao;

    public PagamentoModel(AssinaturaModel assinatura, Float valorPago, LocalDate dataPagamento, PromocaoModel promocao){
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public boolean pagamentoValido(){
        return this.valorPago == promocao.calcularPromocao(assinatura);
    }

    public float valorEstornado(){
        return this.valorPago;
    }

}
