package com.fds.sis_controle_assinaturas.dominio.model;


import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoModel {

    private Long codigo;
    private AssinaturaModel assinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

}
