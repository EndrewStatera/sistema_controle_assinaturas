package com.fds.sis_controle_assinaturas.dominio.persistence;

import java.util.List;

import com.fds.sis_controle_assinaturas.dominio.models.PagamentoModel;

public interface IPagamentosRepository {
    public void addPagamento(PagamentoModel pagamento);
    public PagamentoModel findPagamentoById(long id);
    public List<PagamentoModel> all();
}
