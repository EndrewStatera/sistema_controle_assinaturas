package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Cliente;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IClienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements IClienteRepository {
    @Autowired
    private IClienteJPA repository;

    @Autowired
    public ClienteRepository(IClienteJPA repository) {
        this.repository = repository;
    }

    @Override
    public ClienteModel getClienteById(Long id) {
        return Cliente.toClienteModel( repository.findById(id).orElseThrow());
    }

    @Override
    public List<ClienteModel> all() {
        return repository.findAll().stream().map(Cliente::toClienteModel).toList();
    }
}
