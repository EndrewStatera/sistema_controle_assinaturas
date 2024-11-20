package com.fds.sis_controle_assinaturas.dominio.persistence;

import java.util.Optional;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Pagamento;

public interface IPagamentosRepository {
    public PagamentoModel addPagamento(PagamentoModel pagamento);
    public void removePagamento(Pagamento pagamento);
    Optional<Pagamento> findById(Long id);
}
