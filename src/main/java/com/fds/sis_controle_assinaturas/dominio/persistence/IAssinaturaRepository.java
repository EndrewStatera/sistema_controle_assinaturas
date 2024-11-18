package com.fds.sis_controle_assinaturas.dominio.persistence;

import java.util.List;

import com.fds.sis_controle_assinaturas.dominio.models.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.models.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.models.ClienteModel;

public interface IAssinaturaRepository {

    public AssinaturaModel salvaAssinatura(ClienteModel cliente, AplicativoModel app);
    public List<AssinaturaModel> all();
    public AssinaturaModel getAssinaturaById(Long id);
    public AssinaturaModel saveAssinatura(AssinaturaModel assinatura);

    
}
