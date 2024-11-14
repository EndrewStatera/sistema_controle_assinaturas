package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;

public class ServicoPagamento {
    IPagamentosRepository pagamentos;
    public ServicoPagamento(IPagamentosRepository pagamentos){
        this.pagamentos = pagamentos;
    }
}
