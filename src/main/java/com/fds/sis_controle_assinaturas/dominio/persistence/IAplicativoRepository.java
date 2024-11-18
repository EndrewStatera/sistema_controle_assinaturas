package com.fds.sis_controle_assinaturas.dominio.persistence;

import java.util.List;

import com.fds.sis_controle_assinaturas.dominio.models.AplicativoModel;

public interface IAplicativoRepository {
    public AplicativoModel getAplicativoById(Long id);
    public List<AplicativoModel> findAllApps();
    public void cadastraApp(AplicativoModel aplicativo);
    public void removeApp(Long id);
}
