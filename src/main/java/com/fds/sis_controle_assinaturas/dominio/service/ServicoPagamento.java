package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.auxiliares.PagamentoAssinaturaAdapter;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.dominio.model.PromocaoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPromocaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class ServicoPagamento {
    IPagamentosRepository pagamentos;
    IPromocaoRepository promocoes;
    public ServicoPagamento(IPagamentosRepository pagamentos, IPromocaoRepository promocao){
        this.pagamentos = pagamentos;
        this.promocoes = promocao;
    }

    /*
        Ainda falta implementar a funcionalidade de estornar o dinheiro. Como seria?
    */
    public boolean efetivaPagamento(AssinaturaModel assinatura, Float valor, Long id){
        PromocaoModel promocao = promocoes.getPromocaoById(id);
        float calculaTotalPromocao = promocoes.getPromocaoById(id).calcularPromocao(assinatura);
        PagamentoAssinaturaAdapter adapter = new PagamentoAssinaturaAdapter();

        if(valor != calculaTotalPromocao)
            return false;
        else{
            PagamentoModel pagamento = new PagamentoModel(assinatura, valor, LocalDate.now(), promocao);
            if(pagamento.pagamentoValido()) {
                pagamentos.addPagamento(pagamento);
                assinatura.pagaAssinatura(promocao.getDiasProlongados());
                return true;
            }
        }
        return false;
    }
}
