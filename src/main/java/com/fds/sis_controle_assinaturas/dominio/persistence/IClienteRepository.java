package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;

import java.util.List;

public interface IClienteRepository {
    public ClienteModel getClienteById(Long id);
    public List<ClienteModel> all();
}
