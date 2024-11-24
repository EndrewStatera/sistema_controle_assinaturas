package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;

public interface IAssinaturaRepository {
    AssinaturaModel save(AssinaturaModel assinatura);
}
