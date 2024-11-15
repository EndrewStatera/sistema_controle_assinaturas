package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Assinatura;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IAssinaturaJPA;

import java.util.List;

public class AssinaturaRepository implements IAssinaturaRepository {
    IAssinaturaJPA repository;

    @Override
    public AssinaturaModel salvaAssinatura(AssinaturaModel assinatura) {
        Assinatura assinatura1 = Assinatura.fromAssinaturaModel(assinatura);
        repository.save(assinatura1);
        return Assinatura.toAssinaturaModel(assinatura1);
    }

    @Override
    public List<AssinaturaModel> all() {
        return repository.findAll().stream().map(assinatura -> Assinatura.toAssinaturaModel(assinatura)).toList();
    }

    @Override
    public AssinaturaModel getAssinaturaById(Long id) {
        return Assinatura.toAssinaturaModel(repository.findById(id).orElseThrow());
    }
}
