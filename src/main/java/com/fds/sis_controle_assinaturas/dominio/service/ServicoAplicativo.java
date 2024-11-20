package com.fds.sis_controle_assinaturas.dominio.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;

public class ServicoAplicativo {
    IAplicativoRepository apps;
    @Autowired
    public ServicoAplicativo(IAplicativoRepository apps){
        this.apps = apps;
    }
    public AplicativoModel atualizaCusto(Long id, Float novoCusto){
        AplicativoModel app = apps.getAplicativoById(id);
        if(!(novoCusto < 0))
            app.setCustoMensal(novoCusto);
        return app;
    }

}
