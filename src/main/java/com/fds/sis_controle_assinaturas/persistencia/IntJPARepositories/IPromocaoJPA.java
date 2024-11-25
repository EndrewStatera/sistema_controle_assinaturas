package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;

import com.fds.sis_controle_assinaturas.persistencia.Entities.Promocao;
import org.springframework.data.repository.CrudRepository;

public interface IPromocaoJPA extends CrudRepository<Promocao, Long> {
}
