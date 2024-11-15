package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;

import java.util.List;

public interface IAplicativoRepository {
    public AplicativoModel getAplicativoById(Long id);
    public List<AplicativoModel> all();
}
