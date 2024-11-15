package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Assinatura {
    private Long id;
    private AplicativoModel app;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private  LocalDate fimVigencia;

    public Assinatura(Long id, AplicativoModel app, ClienteModel cliente){
        this.id = id;
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = LocalDate.now();
    }

    public void setFimVigencia(LocalDate data){
        this.fimVigencia = data;
    }

    public boolean isActive(){
        return this.fimVigencia.isAfter(LocalDate.now());
    }

    public LocalDate pagaAssinatura(){
        if(this.isActive())
            this.fimVigencia = fimVigencia.plusDays(30);
        else{
            this.fimVigencia = LocalDate.now().plusDays(30);
        }
        return this.fimVigencia;
    }

    public static AssinaturaModel toAssinaturaModel(Assinatura assinatura){
        return new AssinaturaModel(assinatura.getId(), assinatura.getApp(), assinatura.getCliente());
    }

    public static Assinatura fromAssinaturaModel(AssinaturaModel assinatura){
        return new Assinatura(assinatura.getId(), assinatura.getApp(), assinatura.getCliente());
    }
}
