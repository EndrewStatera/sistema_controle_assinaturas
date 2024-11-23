package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;

import java.util.List;

public class ServicoAplicativo {
    IAplicativoRepository apps;
    public ServicoAplicativo(IAplicativoRepository apps){
        this.apps = apps;
    }
    public AplicativoModel atualizaCusto(Long id, Float novoCusto){
        AplicativoModel app = apps.getAplicativoById(id);
        if(!(novoCusto < 0))
            app.setCustoMensal(novoCusto);
        return app;
    }

    public List<AplicativoModel> all(){
        return apps.all();
    }

}
