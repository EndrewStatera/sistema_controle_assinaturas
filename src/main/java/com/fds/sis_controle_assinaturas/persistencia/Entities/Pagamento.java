package com.fds.sis_controle_assinaturas.persistencia.Entities;

import java.time.LocalDate;

import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pagamento {

    private Long codigo;
    private Assinatura assinatura;
    private Float valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public Pagamento(Assinatura assinatura, Float valorPago, LocalDate dataPagamento, String promocao){
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamento){
        return new Pagamento(Assinatura.fromAssinaturaModel(pagamento.getAssinatura()),
                                pagamento.getValorPago(),
                                pagamento.getDataPagamento(),
                                pagamento.getPromocao());
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento){
        return new PagamentoModel(pagamento.getCodigo(),
                                    Assinatura.toAssinaturaModel(pagamento.getAssinatura()),
                                    pagamento.getValorPago(),
                                    pagamento.getDataPagamento(),
                                    pagamento.getPromocao());
    }
}
