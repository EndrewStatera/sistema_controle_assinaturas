package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Aplicativo;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Assinatura;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Cliente;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IAssinaturaJPA;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssinaturaRepository implements IAssinaturaRepository {
    @Autowired
    IAssinaturaJPA repository;

    @Autowired
    public AssinaturaRepository(IAssinaturaJPA repository) {
        this.repository = repository;
    }

    @Override
    public AssinaturaModel salvaAssinatura(AssinaturaModel assinatura) {
        Assinatura assinatura1 = Assinatura.fromAssinaturaModel(assinatura);
        repository.save(assinatura1);
        return Assinatura.toAssinaturaModel(assinatura1);
    }

    @Override
    public List<AssinaturaModel> all() {
        return repository.findAll().stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public AssinaturaModel getAssinaturaById(Long id) {
        Assinatura assinatura = repository.findById(id).orElseThrow();
        System.out.println("recem pegando" +assinatura);
        return Assinatura.toAssinaturaModel(repository.findById(id).orElseThrow());
    }

    public AssinaturaModel criaAssinatura(ClienteModel cliente, AplicativoModel aplicativo){
        Cliente c = Cliente.fromClienteModel(cliente);
        Aplicativo a = Aplicativo.fromAplicativoModel(aplicativo);
        LocalDate dataInicio = LocalDate.now();
        LocalDate dataFim = dataInicio.plusDays(7);
        Assinatura assinatura = new Assinatura(a, c, dataInicio, dataFim.plusDays(30));
        repository.save(assinatura);
        return Assinatura.toAssinaturaModel(assinatura);
    }
}
