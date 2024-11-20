package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;
import org.springframework.data.repository.CrudRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Pagamento;

public interface IPagamentoJPA extends CrudRepository<Pagamento, Long>{
    
}
