package com.fds.sis_controle_assinaturas.dominio.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fds.sis_controle_assinaturas.dominio.auxiliares.StatusAssinatura;
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

    public List<AssinaturaModel> getAssinaturasByStatus(StatusAssinatura status){
        List<AssinaturaModel> assinaturas = repository.todas();
        if(status == StatusAssinatura.ATIVA)
            assinaturas = repository.todas().stream().filter(
                    assinaturaModel ->
                            assinaturaModel.getFimVigencia().after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))).toList();
        else if(status == StatusAssinatura.INATIVA)
            assinaturas = repository.todas().stream().filter(
                    assinaturaModel ->
                            !assinaturaModel.getFimVigencia().after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))).toList();
        return assinaturas;
    }

    public List<AssinaturaModel> getAssinaturasByCliente(ClienteModel cliente){
        List<AssinaturaModel> assinaturas = repository.todas().stream().filter(assinatura -> assinatura.getCliente().getId().equals(cliente.getId())).toList();
        return assinaturas;
    }

    public List<AssinaturaModel> getAssinaturasByCliente(AplicativoModel cliente){
        List<AssinaturaModel> assinaturas = repository.todas().stream().filter(assinatura -> assinatura.getCliente().getId().equals(cliente.getCodigo())).toList();
        return assinaturas;
    }

    public boolean getAssinaturaStatus(Long id){
        return repository.getAssinaturaById(id) != null;
    }



}
