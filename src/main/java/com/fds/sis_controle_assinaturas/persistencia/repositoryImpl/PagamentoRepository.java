package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPagamentosRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Pagamento;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IPagamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PagamentoRepository implements IPagamentosRepository {
    @Autowired
    private IPagamentoJPA repository;

    @Autowired
    public PagamentoRepository(IPagamentoJPA repository) {
        this.repository = repository;
    }

    @Override
    public PagamentoModel addPagamento(PagamentoModel pagamento) {
        return Pagamento.toPagamentoModel(repository.save(Pagamento.fromPagamentoModel(pagamento)));
    }
}
