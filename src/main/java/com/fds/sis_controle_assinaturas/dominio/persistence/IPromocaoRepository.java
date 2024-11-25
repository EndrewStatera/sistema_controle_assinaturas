package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.PromocaoModel;

public interface IPromocaoRepository {
    public PromocaoModel getPromocaoById(long id);
}
