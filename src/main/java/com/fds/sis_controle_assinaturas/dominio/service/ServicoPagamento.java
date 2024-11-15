package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;

public class ServicoPagamento {
    IPagamentosRepository pagamentos;
    public ServicoPagamento(IPagamentosRepository pagamentos){
        this.pagamentos = pagamentos;
    }

    public static PagamentoDTO paga(AssinaturaDTO assinatura){

        return null;
    }
}
