package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "ASSINATURAS")
@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assinatura")
    private Long id;
    //@Column(name = "id_app")
    @OneToOne
    private Aplicativo app;
    //@Column(name = "id_cliente")
    @OneToOne
    private Cliente cliente;
    @Column(name = "inicio_vigencia")
    //@DateTimeFormat
    private LocalDate inicioVigencia;
    @Column(name = "fim_vigencia")
    //@DateTimeFormat
    private  LocalDate fimVigencia;

    protected Assinatura() {}

    public Assinatura(Aplicativo app, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia){
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Assinatura(Long id, Aplicativo app, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia){
        this.id = id;
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
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
        return new AssinaturaModel(assinatura.getId(),
                Aplicativo.toAplicativoModel(assinatura.getApp()),
                Cliente.toClienteModel(assinatura.getCliente()),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia());
    }

    public static Assinatura fromAssinaturaModel(AssinaturaModel assinatura){
        return new Assinatura(assinatura.getId(),
                Aplicativo.fromAplicativoModel(assinatura.getApp()),
                Cliente.fromClienteModel(assinatura.getCliente()),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia());
    }

    @Override
    public String toString(){
        return "id " + this.id + "\n" +
                "app_id: " + this.app.getCodigo() +
                "data_inicio: " + this.getInicioVigencia() +
                "data_fim: " + this.getInicioVigencia();
    }
}
