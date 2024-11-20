package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
public class CriarAssinatura{
    private IAssinaturaRepository assinaturaRepository;
    public CriarAssinatura(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;

    }

    public AssinaturaDTO run(AssinaturaDTO assinatura){
        AssinaturaModel assinatura = new AssinaturaModel(assinatura.getApp());
        return null;
    }


}