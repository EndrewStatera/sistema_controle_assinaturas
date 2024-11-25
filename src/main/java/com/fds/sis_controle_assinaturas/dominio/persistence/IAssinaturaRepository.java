package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;

import java.util.List;

public interface IAssinaturaRepository {

    public AssinaturaModel salvaAssinatura(AssinaturaModel assinaturaModel);
    public List<AssinaturaModel> all();
    public  AssinaturaModel getAssinaturaById(Long id);
    public AssinaturaModel criaAssinatura(ClienteModel cliente, AplicativoModel aplicativo);
}
