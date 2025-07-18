package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoCliente {
    IClienteRepository clientes;
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
