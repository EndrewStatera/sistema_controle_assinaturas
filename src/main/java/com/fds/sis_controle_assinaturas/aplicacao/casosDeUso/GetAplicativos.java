package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class GetAplicativos {
    ServicoAplicativo servicoAplicativo;
    @Autowired
    public GetAplicativos(ServicoAplicativo servicoAplicativo){
        this.servicoAplicativo = servicoAplicativo;
    }
    public List<AplicativoDTO> run(){
        return servicoAplicativo.all().stream().map(AplicativoDTO::fromAppModel).toList();
    }
}
