package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClienteById {
    private ServicoCliente clienteServico;
    @Autowired
    public GetClienteById(ServicoCliente clienteServico){
        this.clienteServico = clienteServico;
    }
    public ClienteDTO run(Long id){
        return ClienteDTO.fromClienteModel(this.clienteServico.getClienteById(id));
    }
}
