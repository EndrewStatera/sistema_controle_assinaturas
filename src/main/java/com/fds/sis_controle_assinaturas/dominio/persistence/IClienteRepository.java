package com.fds.sis_controle_assinaturas.dominio.persistence;

import java.util.List;

import com.fds.sis_controle_assinaturas.dominio.models.ClienteModel;

public interface IClienteRepository {
    public ClienteModel getClienteById(Long id);
    public List<ClienteModel> all();
    public void removeClienteById(Long id);
    public void cadastraCliente(ClienteModel cliente);
    
}
