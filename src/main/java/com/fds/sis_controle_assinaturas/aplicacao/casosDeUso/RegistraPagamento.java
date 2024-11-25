package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.useCasesDTO.PagamentoAssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegistraPagamento {

    ServicoPagamento servicoPagamento;
    ServicoAssinatura servicoAssinatura;

    private final static String FAIL_MESSAGE = "VALOR_INCORRETO";
    private final static String SUCCESS_MESSAGE = "PAGAMENTO_OK";
    @Autowired
    public RegistraPagamento(ServicoPagamento servicoPagamento,
                             ServicoAssinatura servicoAssinatura){
        this.servicoPagamento = servicoPagamento;
        this.servicoAssinatura = servicoAssinatura;
    }

    public PagamentoAssinaturaDTO run(PagamentoDTO pagamento, AssinaturaDTO assinaturaDTO, Float valorPago){
        System.out.println("Segunda camada");
        AssinaturaModel assinatura = servicoAssinatura.getAssinaturaById(assinaturaDTO.getId());
        if(assinatura == null)throw new RuntimeException("Assinatura invalida");
        LocalDate dataVigenciaInicial = assinatura.getFimVigencia();
        boolean sucesso = servicoPagamento.efetivaPagamento(assinatura, valorPago, pagamento.getPromocao());
        if(sucesso){
            servicoAssinatura.atualizaAssinatura(assinatura);
            return new PagamentoAssinaturaDTO(0, assinatura.getFimVigencia(), SUCCESS_MESSAGE);
        }

        return new PagamentoAssinaturaDTO(valorPago, assinatura.getFimVigencia(), FAIL_MESSAGE);
    }
}
