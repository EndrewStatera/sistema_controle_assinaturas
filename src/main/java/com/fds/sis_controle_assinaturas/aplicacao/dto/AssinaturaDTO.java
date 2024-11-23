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
    private AplicativoDTO app;
    private ClienteDTO cliente;
    private LocalDate inicioVigencia;
    private  LocalDate fimVigencia;

    public AssinaturaDTO(AplicativoDTO app, ClienteDTO cliente, LocalDate inicioVigencia, LocalDate fimVigencia){
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public static AssinaturaDTO fromAssinaturaModel(AssinaturaModel assinaturaModel){
        return new AssinaturaDTO(assinaturaModel.getId(),
                                    AplicativoDTO.fromAppModel(assinaturaModel.getApp()),
                                    ClienteDTO.fromClieModel(assinaturaModel.getCliente()),
                                    assinaturaModel.getInicioVigencia(),
                                    assinaturaModel.getFimVigencia());
    }
}
