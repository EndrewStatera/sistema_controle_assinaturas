package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistraPagamento {

    ServicoPagamento servicoPagamento;
    @Autowired
    public RegistraPagamento(ServicoPagamento servicoPagamento){
        this.servicoPagamento = servicoPagamento;
    }

    public PagamentoDTO run(AssinaturaDTO assinaturaDTO, Float valorPago){
        servicoPagamento.efetivaPagamento(pagamento);
    }
}
