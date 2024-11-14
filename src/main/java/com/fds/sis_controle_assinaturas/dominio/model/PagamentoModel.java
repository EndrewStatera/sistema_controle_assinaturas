package com.fds.sis_controle_assinaturas.dominio.model;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoEntity {

    private Long codigo;
    private AssinaturaEntity assinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

}
