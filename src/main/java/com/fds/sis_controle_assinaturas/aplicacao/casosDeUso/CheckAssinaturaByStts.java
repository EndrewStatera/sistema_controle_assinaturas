package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckAssinaturaByStts {
    ServicoAssinatura service;
    @Autowired
    public CheckAssinaturaByStts(ServicoAssinatura service){
        this.service = service;
    }

    public boolean run(long idAssinatura){
        return service.isAssinaturaValida(idAssinatura);
    }
}