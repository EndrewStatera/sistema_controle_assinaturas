package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;

public interface IAplicativoRepository {
    public AplicativoModel getAplicativoById(Long id);
}
