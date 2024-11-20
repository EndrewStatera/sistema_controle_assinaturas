package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;

public interface IPagamentosRepository {
    public PagamentoModel addPagamento(PagamentoModel pagamento);
}
