package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Pagamento;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class ServicoPagamento {
    IPagamentosRepository pagamentos;
    public ServicoPagamento(IPagamentosRepository pagamentos){
        this.pagamentos = pagamentos;
    }

    
    public LocalDate efetivaPagamento(AssinaturaModel assinatura, Float valor){
        if(!Objects.equals(valor, assinatura.getApp().getCustoMensal()))
            return assinatura.getFimVigencia();
        else{
            PagamentoModel pagamento = new PagamentoModel(assinatura, valor, LocalDate.now(), null);
            pagamentos.addPagamento(pagamento);
        }
        return assinatura.getFimVigencia();
    }
/*
        Ainda falta implementar a funcionalidade de estornar o dinheiro. Como seria? Assim?
    */
    public void EstornaPagamento(Long pagamentoId) {
        Pagamento pagamento = pagamentos.findById(pagamentoId)
            .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado."));
        pagamentos.removePagamento(pagamento);
    }
}
