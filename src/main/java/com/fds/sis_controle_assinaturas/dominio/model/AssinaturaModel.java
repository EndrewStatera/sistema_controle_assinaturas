package com.fds.sis_controle_assinaturas.aplicacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_assinaturas")
public class AssinaturaModel {

    @Id
    @Column(name = "codigo")
    private Long id;
    @OneToMany //OneToMany or ManyToOne?
    @JoinColumn(name = "codigo")
    private Aplicativo app;

}
