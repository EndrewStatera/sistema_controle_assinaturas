package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.PromocaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROMOCAO")
@Entity
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_promocao")
    private long codigo;
    @Column(name="dias_vigencia")
    private int diasProlongados;
    @Column(name = "porcentagem_desconto")
    private float desconto;

    public static PromocaoModel toPromocaoModel(Promocao promocao){
        return new PromocaoModel(promocao.getCodigo(), promocao.getDiasProlongados(), promocao.getDesconto());
    }

    public static Promocao fromPromocaoModel(PromocaoModel promocao){
        return new Promocao(promocao.getCodigo(), promocao.getDiasProlongados(), promocao.getDesconto());
    }
}
