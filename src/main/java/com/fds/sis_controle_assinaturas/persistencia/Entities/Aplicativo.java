package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aplicativo {
    private Long codigo;
    private String nomeAplicativo;
    private Float custoMensal;

    public static AplicativoModel toAplicativoModel(Aplicativo app){
        return new AplicativoModel(app.codigo, app.nomeAplicativo, app.custoMensal);
    }

    public static Aplicativo fromAplicativoModel(Aplicativo app){
        return new Aplicativo(app.codigo, app.nomeAplicativo, app.custoMensal);
    }
}
