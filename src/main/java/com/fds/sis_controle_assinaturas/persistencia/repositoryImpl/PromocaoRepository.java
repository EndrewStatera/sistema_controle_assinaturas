package com.fds.sis_controle_assinaturas.persistencia.repositoryImpl;

import com.fds.sis_controle_assinaturas.dominio.model.PromocaoModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IPromocaoRepository;
import com.fds.sis_controle_assinaturas.persistencia.Entities.Promocao;
import com.fds.sis_controle_assinaturas.persistencia.IntJPARepositories.IPromocaoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PromocaoRepository implements IPromocaoRepository {

    private IPromocaoJPA promocoes;
    @Autowired
    public PromocaoRepository(IPromocaoJPA promocoes){
        this.promocoes = promocoes;
    }
    @Override
    public PromocaoModel getPromocaoById(long id) {
        return Promocao.toPromocaoModel(promocoes.findById(id).orElseThrow());
    }
}
