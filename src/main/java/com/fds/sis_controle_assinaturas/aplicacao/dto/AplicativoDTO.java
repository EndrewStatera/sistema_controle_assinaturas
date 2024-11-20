package com.fds.sis_controle_assinaturas.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AplicativoDTO{
    private Long codigo;
    private String nomeAplicativo;
    private Float custoMensal;

    public AplicativoDTO(String nomeAplicativo, Float custoMensal){
        this.nomeAplicativo = nomeAplicativo;
        this.custoMensal = custoMensal;
    }
}