package com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteJPA extends CrudRepository<Cliente, Long>{
    @Override
    public Optional<Cliente> findById(Long id);
    @Override
    public List<Cliente> findAll();
}
