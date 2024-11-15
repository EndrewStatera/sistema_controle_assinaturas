package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;

import java.util.List;

public class ServicoAplicativo {
    IAplicativoRepository apps;
    public ServicoAplicativo(IAplicativoRepository apps){
        this.apps = apps;
    }


}
