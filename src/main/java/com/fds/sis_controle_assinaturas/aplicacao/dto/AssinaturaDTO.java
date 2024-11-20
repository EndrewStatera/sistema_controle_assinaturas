package com.fds.sis_controle_assinaturas.aplicacao.dto;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AssinaturaDTO{
    private Long id;
    private AplicativoModel app;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private  LocalDate fimVigencia;

    public AssinaturaDTO(AplicativoModel app, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia){
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }
}
