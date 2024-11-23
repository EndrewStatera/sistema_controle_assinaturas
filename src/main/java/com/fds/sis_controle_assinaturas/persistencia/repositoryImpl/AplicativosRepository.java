package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Aplicativo;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IAppsJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class AplicativosRepository implements IAplicativoRepository {
    @Autowired
    private IAppsJPA apps;

    @Autowired
    public AplicativosRepository(IAppsJPA apps){
        this.apps = apps;
    }
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
