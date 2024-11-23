package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAssinaturas {
    ServicoAssinatura servicoAssinatura;
    @Autowired
    public GetAssinaturas(ServicoAssinatura servicoAssinatura){
        this.servicoAssinatura = servicoAssinatura;
    }
    public List<AssinaturaDTO> run(){
        return servicoAssinatura.getAll().stream().map(AssinaturaDTO::fromAssinaturaModel).toList();
    }
}
