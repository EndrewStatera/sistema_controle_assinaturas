package com.fds.sis_controle_assinaturas.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PromocaoModel implements IPromocao {
    private long codigo = 1;
    private int diasProlongados;
    private float desconto;


    @Override
    public float calcularPromocao(AssinaturaModel assinaturaModel) {
        float custo = assinaturaModel.getApp().getCustoMensal();
        return custo - (custo * (this.desconto/100f));
    }

    @Override
    public LocalDate promoDataVigencia(AssinaturaModel assinatura) {
        if(assinatura.isActive())
            assinatura.setFimVigencia(assinatura.getFimVigencia().plusDays(diasProlongados));
        else{
            assinatura.setFimVigencia(LocalDate.now().plusDays(diasProlongados)) ;
        }
        return assinatura.getFimVigencia();
    }

}
