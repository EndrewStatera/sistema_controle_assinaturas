package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.auxiliares.StatusAssinatura;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Assinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component

public class GetAssinaturaByStatus {
    ServicoAssinatura service;
    @Autowired
    public GetAssinaturaByStatus(ServicoAssinatura service){
        this.service = service;
    }

    public List<AssinaturaDTO> run(StatusAssinatura status){
        return this.service.getAssinaturasByStatus(status).stream().map(AssinaturaDTO::fromAssinaturaModel).toList();
    }

}
