package com.fds.sis_controle_assinaturas.dominio.model;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Date;

@Getter
@Setter
public class AssinaturaModel {

    private Long id;
    private AplicativoModel app;
    private ClienteModel cliente;
    private Date inicioVigencia;
    private  Date fimVIgencia;

    public AssinaturaModel(Long id, AplicativoModel app, ClienteModel cliente){
        this.id = id;
        this.app = app;
        this.cliente = cliente;
    }

}
