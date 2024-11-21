package com.fds.sis_controle_assinaturas.aplicacao.controller;

import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoPagamento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * REST Controller for managing payments (`PagamentoModel`).
 * Exposes endpoints for payment operations such as effecting and refunding payments.
 */
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final ServicoPagamento servicoPagamento;

    public PagamentoController(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    /**
     * Processes a payment for a subscription.
     *
     * @param assinaturaId the ID of the subscription
     * @param valor the payment amount
     * @return the updated subscription end date
     */
    @PostMapping("/efetivar")
    public ResponseEntity<LocalDate> efetivaPagamento(
            @RequestParam Long assinaturaId, 
            @RequestParam Float valor) {
        // Simulação de busca por AssinaturaModel (substitua por chamada real)
        AssinaturaModel assinatura = new AssinaturaModel();
        assinatura.setId(assinaturaId); // Mock
        assinatura.setFimVigencia(LocalDate.now().plusMonths(1)); // Mock
        assinatura.getApp().setCustoMensal(valor); // Mock, substituir por lógica real

        LocalDate fimVigencia = servicoPagamento.efetivaPagamento(assinatura, valor);
        return ResponseEntity.ok(fimVigencia);
    }

    /**
     * Refunds a payment.
     *
     * @param pagamentoId the ID of the payment to be refunded
     * @return a confirmation message if successful
     */
    @DeleteMapping("/estornar/{pagamentoId}")
    public ResponseEntity<String> estornaPagamento(@PathVariable Long pagamentoId) {
        try {
            servicoPagamento.EstornaPagamento(pagamentoId);
            return ResponseEntity.ok("Pagamento estornado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
