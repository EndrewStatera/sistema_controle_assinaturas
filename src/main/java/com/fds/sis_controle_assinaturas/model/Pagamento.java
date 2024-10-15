package com.fds.sis_controle_assinaturas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pagamento")
    private Long codigo;
    @Column(name = "pagamento_assinatura")
    private AssinaturaModel assinatura;
    @Column(name = "valor_pago")
    private Float valorPago;
    @Column(name = "data_pagamento")
    private Date dataPagamento;
    @Column(name = "promocao")
    private String promocao;

}
