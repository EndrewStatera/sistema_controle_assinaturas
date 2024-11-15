package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Aplicativo;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IAppsJPA;

import java.util.List;

public class AplicativosRepository implements IAplicativoRepository {
    private IAppsJPA apps;
    @Override
    public AplicativoModel getAplicativoById(Long id) {
        return Aplicativo.toAplicativoModel(apps.findById(id).orElseThrow());
    }

    @Override
    public List<AplicativoModel> all() {
        List<Aplicativo> app =  apps.findAll();
        return app.stream().map(Aplicativo::toAplicativoModel).toList();
    }
}
