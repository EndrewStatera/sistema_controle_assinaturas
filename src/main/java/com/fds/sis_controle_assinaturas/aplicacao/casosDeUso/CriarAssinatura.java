package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.models.AplicativoEntity;
import com.fds.sis_controle_assinaturas.dominio.models.AssinaturaEntity;
import com.fds.sis_controle_assinaturas.dominio.models.ClienteEntity;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAplicativoRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.dominio.persistence.IClienteRepository;
public class CriarAssinatura{
    private IAssinaturaRepository assinaturaRepository;
    public CriarAssinatura(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;

    }

    public AssinaturaDTO run(long id, AplicativoEntity app, ClienteEntity cliente){
        AssinaturaEntity assinatura = new AssinaturaEntity(id, app, cliente);
        return null;
    }
}