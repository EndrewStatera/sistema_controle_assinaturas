package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;

import com.fds.sis_controle_assinaturas.persistencia.Entities.Assinatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAssinaturaJPA extends CrudRepository<Assinatura, Long> {
    public List<Assinatura> findAll();
}
