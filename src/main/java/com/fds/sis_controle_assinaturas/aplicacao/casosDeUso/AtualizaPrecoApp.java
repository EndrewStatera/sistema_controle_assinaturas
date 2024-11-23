package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.useCasesDTO.AtualizaPrecoDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class AtualizaPrecoApp {
    ServicoAplicativo service;
    @Autowired
    public AtualizaPrecoApp(ServicoAplicativo service){
        this.service = service;
    }

    public AplicativoDTO run(AtualizaPrecoDTO dto){
        return AplicativoDTO.fromAppModel(this.service.atualizaCusto(dto.getId(), dto.getNovoPreco()));
    }
}
