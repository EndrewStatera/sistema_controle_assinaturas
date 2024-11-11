package com.fds.sis_controle_assinaturas.dominio.service;
import java.util.Date;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoEntity;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaEntity;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteEntity;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoEntity;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;

public class ServicoAssinatura {
    private IAssinaturaRepository repository;
    public ServicoAssinatura(IAssinaturaRepository repository){
        this.repository = repository;
    }

}
