package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Cliente;

public interface IClienteJPA extends CrudRepository<Cliente, Long>{
    ClienteModel getClienteById(Long id);
    List<ClienteModel> all();
}
