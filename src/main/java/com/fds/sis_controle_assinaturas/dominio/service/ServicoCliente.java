package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;

public class ServicoCliente {
    IClienteRepository clientes;
    public ServicoCliente(IClienteRepository clientes){
        this.clientes = clientes;
    }
}
