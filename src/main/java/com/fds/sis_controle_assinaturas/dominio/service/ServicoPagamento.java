package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class ServicoPagamento {
    IPagamentosRepository pagamentos;
    public ServicoPagamento(IPagamentosRepository pagamentos){
        this.pagamentos = pagamentos;
    }

    /*
        Ainda falta implementar a funcionalidade de estornar o dinheiro. Como seria?
    */
    public LocalDate efetivaPagamento(AssinaturaModel assinatura, Float valor){
        if(!Objects.equals(valor, assinatura.getApp().getCustoMensal()))
            return assinatura.getFimVigencia();
        else{
            PagamentoModel pagamento = new PagamentoModel(assinatura, valor, LocalDate.now(), null);
            pagamentos.addPagamento(pagamento);
        }
        return assinatura.getFimVigencia();
    }
}
