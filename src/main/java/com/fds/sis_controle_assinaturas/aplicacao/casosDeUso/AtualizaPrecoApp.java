package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
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

    public AplicativoDTO run(Long id, float novoPreco){
        return AplicativoDTO.fromAppModel(this.service.atualizaCusto(id, novoPreco));
    }
}
