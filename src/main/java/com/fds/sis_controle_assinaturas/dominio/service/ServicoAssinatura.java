package com.fds.sis_controle_assinaturas.dominio.service;
import java.util.Date;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;

public class ServicoAssinatura {
    private IAssinaturaRepository repository;
    public ServicoAssinatura(IAssinaturaRepository repository){
        this.repository = repository;
    }


}
