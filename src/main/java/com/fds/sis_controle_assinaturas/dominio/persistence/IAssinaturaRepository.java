package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoEntity;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaEntity;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteEntity;

public interface IAssinaturaRepository {

    public AssinaturaEntity salvaAssinatura(ClienteEntity cliente, AplicativoEntity app);

}
