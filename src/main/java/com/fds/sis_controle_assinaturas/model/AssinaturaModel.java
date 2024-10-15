package com.fds.sis_controle_assinaturas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_assinaturas")
public class AssinaturaModel {

    @Id
    @Column(name = "codigo")
    private Long id;
    @Column(name = "aplicativo")
    private Aplicativo app;

}
