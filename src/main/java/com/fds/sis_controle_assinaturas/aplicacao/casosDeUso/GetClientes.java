package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoCliente;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetClientes {
    ServicoCliente clienteServico;
    @Autowired
    public GetClientes(ServicoCliente cliente){
        this.clienteServico = cliente;
    }
    public List<ClienteDTO> run(){
        return clienteServico.all().stream().map(ClienteDTO::fromClienteModel).toList();
    }
}
