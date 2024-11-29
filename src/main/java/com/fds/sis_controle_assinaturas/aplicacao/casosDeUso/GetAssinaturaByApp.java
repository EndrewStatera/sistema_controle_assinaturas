package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAssinaturaByApp {
    ServicoAssinatura service;

    @Autowired
    public GetAssinaturaByApp(ServicoAssinatura service){
        this.service = service;
    }

    public List<AssinaturaDTO> run(long appId){
        List<AssinaturaDTO> assinaturas = service.getAssinaturaByApp(appId).stream().map(AssinaturaDTO::fromAssinaturaModel).toList();
        return assinaturas;
    }
}
