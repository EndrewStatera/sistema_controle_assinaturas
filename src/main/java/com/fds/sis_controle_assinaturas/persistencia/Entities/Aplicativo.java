package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apps")
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_app")
    private Long codigo;
    @Column(name = "name", nullable = false)
    private String nomeAplicativo;
    @Column(name = "price", nullable = false)
    private Float custoMensal;

    public static AplicativoModel toAplicativoModel(Aplicativo app){
        return new AplicativoModel(app.codigo, app.nomeAplicativo, app.custoMensal);
    }

    public static Aplicativo fromAplicativoModel(Aplicativo app){
        return new Aplicativo(app.codigo, app.nomeAplicativo, app.custoMensal);
    }
}
