package com.fds.sis_controle_assinaturas.dominio.persistence;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAplicativoRepository {
    public AplicativoModel getAplicativoById(Long id);
    public List<AplicativoModel> all();

    public AplicativoModel updateAppPrice(Long id, Float novoPreco);
}
