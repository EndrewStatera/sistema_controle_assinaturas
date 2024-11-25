package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class CriarAssinatura{
    private ServicoAssinatura servicoAssinatura;
    private ServicoCliente servicoCliente;
    private ServicoAplicativo servicoAplicativo;

    public CriarAssinatura(ServicoAssinatura servicoAssinatura, ServicoCliente servicoCliente, ServicoAplicativo servicoAplicativo) {
        this.servicoAssinatura = servicoAssinatura;
        this.servicoCliente = servicoCliente;
        this.servicoAplicativo = servicoAplicativo;
    }

    /*public AssinaturaDTO run(AssinaturaDTO assinatura){
        AssinaturaModel assinaturaModel = new AssinaturaModel(
                aplicativosRepository.getAplicativoById(assinatura.getApp().getCodigo()),
                clienteRepository.getClienteById(assinatura.getCliente().getId()),
                LocalDate.now(),
                LocalDate.now().plusDays(30));

        return AssinaturaDTO.fromAssinaturaModel(servicoAssinatura.criaAssinatura(assinatura));
    }*/

    public AssinaturaDTO run(long cliente, long aplicativo) {
        var clienteModel = servicoCliente.getClienteById(cliente);
        var aplicativoModel = servicoAplicativo.getAppById(aplicativo);
        var assinatura = servicoAssinatura.registrarAssinatura(clienteModel, aplicativoModel);
        return AssinaturaDTO.fromAssinaturaModel(assinatura);
    }
}