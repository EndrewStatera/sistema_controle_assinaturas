package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class CriarAssinatura{
    private IAssinaturaRepository assinaturaRepository;
    private IAplicativoRepository aplicativosRepository;
    private IClienteRepository clienteRepository;
    private ServicoAssinatura servicoAssinatura;

    @Autowired
    public CriarAssinatura(ServicoAssinatura servicoAssinatura,
                           IAssinaturaRepository assinaturaRepository,
                           IClienteRepository clienteRepository,
                           IAplicativoRepository app){
        this.assinaturaRepository = assinaturaRepository;
        this.clienteRepository = clienteRepository;
        this.aplicativosRepository = app;
        this.servicoAssinatura = servicoAssinatura;
    }

    public AssinaturaDTO run(AssinaturaDTO assinatura){
        AssinaturaModel assinaturaModel = new AssinaturaModel(
                aplicativosRepository.getAplicativoById(assinatura.getApp().getCodigo()),
                clienteRepository.getClienteById(assinatura.getCliente().getId()),
                LocalDate.now(),
                LocalDate.now().plusDays(30));

        return AssinaturaDTO.fromAssinaturaModel(servicoAssinatura.criaAssinatura(assinatura));
    }


}