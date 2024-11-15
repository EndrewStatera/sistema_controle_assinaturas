package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;

import com.fds.sis_controle_assinaturas.persistencia.Entities.Aplicativo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface IAppsJPA extends CrudRepository<Aplicativo, Long> {
    public List<Aplicativo> findAll();
}
