package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAppById {
    ServicoAplicativo servicoAplicativo;
    @Autowired
    public GetAppById(ServicoAplicativo servicoAplicativo){
        this.servicoAplicativo = servicoAplicativo;
    }
    public AplicativoDTO run(Long id) {
        return AplicativoDTO.fromAppModel(servicoAplicativo.getAppById(id));
    }
}
