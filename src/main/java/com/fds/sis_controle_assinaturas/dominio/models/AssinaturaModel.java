package com.fds.sis_controle_assinaturas.dominio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "assinatura")
public class AssinaturaModel {

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

    public AssinaturaModel() {
    }

    public AssinaturaModel(Long id, AplicativoModel app, ClienteModel cliente) {
        this.id = id;
        this.app = app;
        this.cliente = cliente;
        this.inicioVigencia = LocalDate.now();
        this.fimVigencia = LocalDate.now().plusDays(7);
    }

    public boolean isActive() {
        return this.fimVigencia.isAfter(LocalDate.now());
    }
    public LocalDate pagaAssinatura() {
        if (this.isActive()) {
            this.fimVigencia = fimVigencia.plusDays(30);
        } else {
            this.fimVigencia = LocalDate.now().plusDays(30);
        }
        return this.fimVigencia;
    }
}
