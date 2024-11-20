package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assinaturas")
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private AplicativoModel app;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;
    @Column(name = "inicio_vigencia", nullable = false)
    private LocalDate inicioVigencia;
    @Column(name = "fim_vigencia", nullable = false)
    private LocalDate fimVigencia;

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
