package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;

public interface IAssinaturaRepository {

    public AssinaturaModel salvaAssinatura(ClienteModel cliente, AplicativoModel app);
    
}
