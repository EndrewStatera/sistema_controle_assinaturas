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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AssinaturaModel {

    private Long id;
    private AplicativoModel app;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private  LocalDate fimVigencia;

    public AssinaturaModel(Long id, AplicativoModel app, ClienteModel cliente){
        this.id = id;
        this.app = app;
        this.cliente = cliente;
    }

    public AssinaturaModel(AplicativoModel app, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia){
        this.id = id;
        this.app = app;
        this.cliente = cliente;
    }


    public void setFimVigencia(LocalDate data){
        this.fimVigencia = data;
    }

    public boolean isActive(){
        return this.fimVigencia.isAfter(LocalDate.now());
    }

    public LocalDate pagaAssinatura(int diasAcrescentados){
        if(this.isActive())
            this.fimVigencia = fimVigencia.plusDays(diasAcrescentados);
        else{
            this.fimVigencia = LocalDate.now().plusDays(diasAcrescentados);
        }
        return this.fimVigencia;
    }

    public void activate(){
        this.inicioVigencia = LocalDate.now();
        this.fimVigencia = LocalDate.now().plusDays(7);
    }

    @Override
    public String toString(){
        return "id " + this.id + "\n" +
                "app_id: " + this.app.getCodigo() +
                "data_inicio: " + this.getInicioVigencia() +
                "data_fim: " + this.getInicioVigencia();
    }

}
