package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;

@Component
public class AssinaturasByCliente {
    ServicoAssinatura service;

    @Autowired
    public AssinaturasByCliente(ServicoAssinatura service){
        this.service = service;
    }

    public List<String> run(long clienteID){
        List<AssinaturaDTO> l = service.assByClientes(clienteID).stream().map(assinatura -> AssinaturaDTO.fromAssinaturaModel(assinatura)).toList();
        return l.stream()
        .map(AssinaturaDTO::toString)
        .toList();
    }
}