package com.fds.sis_controle_assinaturas.persistencia.Entities;

import java.time.LocalDate;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PAGAMENTOS")
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pagamento")
    private Long codigo;
    //@Column(name = "id_assinatura")
    @OneToOne
    private Assinatura assinatura;
    @Column(name = "valor_pago")
    private Float valorPago;
    @Column(name = "data_pagamento")
    @DateTimeFormat
    private LocalDate dataPagamento;
    @ManyToOne
    private Promocao promocao;

    public Pagamento(Assinatura assinatura, Float valorPago, LocalDate dataPagamento, Promocao promocao){
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamento){
        return new Pagamento(Assinatura.fromAssinaturaModel(pagamento.getAssinatura()),
                                pagamento.getValorPago(),
                                pagamento.getDataPagamento(),
                                Promocao.fromPromocaoModel(pagamento.getPromocao()));
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento){
        return new PagamentoModel(pagamento.getCodigo(),
                                    Assinatura.toAssinaturaModel(pagamento.getAssinatura()),
                                    pagamento.getValorPago(),
                                    pagamento.getDataPagamento(),
                                    Promocao.toPromocaoModel(pagamento.getPromocao()));
    }
}
