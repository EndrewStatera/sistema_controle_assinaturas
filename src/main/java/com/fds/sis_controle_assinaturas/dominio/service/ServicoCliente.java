package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicoCliente {
    IClienteRepository clientes;
    @Autowired
    public ServicoCliente(IClienteRepository clientes){
        this.clientes = clientes;
    }

    public ClienteModel getClienteById(Long id){
        return clientes.getClienteById(id);
    }

    public List<ClienteModel> all(){
        return clientes.all();
    }
}
