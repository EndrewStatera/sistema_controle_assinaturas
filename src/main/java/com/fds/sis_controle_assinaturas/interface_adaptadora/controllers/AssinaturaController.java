package com.fds.sis_controle_assinaturas.aplicacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fds.sis_controle_assinaturas.dominio.auxiliares.StatusAssinatura;
import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;

import java.util.List;

/**
 * REST Controller for managing subscriptions (`AssinaturaModel`).
 * Exposes endpoints for retrieving and managing subscription data.
 */
@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final ServicoAssinatura servicoAssinatura;

    public AssinaturaController(ServicoAssinatura servicoAssinatura) {
        this.servicoAssinatura = servicoAssinatura;
    }

    /**
     * Retrieves subscriptions by status.
     *
     * @param status the status of subscriptions to filter by
     * @return a list of subscriptions with the specified status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AssinaturaModel>> getAssinaturasByStatus(@PathVariable StatusAssinatura status) {
        List<AssinaturaModel> assinaturas = servicoAssinatura.getAssinaturasByStatus(status);
        return ResponseEntity.ok(assinaturas);
    }

    /**
     * Retrieves subscriptions for a specific client.
     *
     * @param clienteId the ID of the client
     * @return a list of subscriptions for the specified client
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<AssinaturaModel>> getAssinaturasByCliente(@PathVariable Long clienteId) {
        ClienteModel cliente = new ClienteModel();
        cliente.setId(clienteId);
        List<AssinaturaModel> assinaturas = servicoAssinatura.getAssinaturasByCliente(cliente);
        return ResponseEntity.ok(assinaturas);
    }

    /**
     * Retrieves subscriptions for a specific application.
     *
     * @param aplicativoId the ID of the application
     * @return a list of subscriptions for the specified application
     */
    @GetMapping("/aplicativo/{aplicativoId}")
    public ResponseEntity<List<AssinaturaModel>> getAssinaturasByAplicativo(@PathVariable Long aplicativoId) {
        AplicativoModel aplicativo = new AplicativoModel();
        aplicativo.setCodigo(aplicativoId);
        List<AssinaturaModel> assinaturas = servicoAssinatura.getAssinaturasByAplivativo(aplicativo);
        return ResponseEntity.ok(assinaturas);
    }

    /**
     * Checks the status of a specific subscription.
     *
     * @param assinaturaId the ID of the subscription
     * @return true if the subscription exists, false otherwise
     */
    @GetMapping("/{assinaturaId}/status")
    public ResponseEntity<Boolean> getAssinaturaStatus(@PathVariable Long assinaturaId) {
        boolean exists = servicoAssinatura.getAssinaturaStatus(assinaturaId);
        return ResponseEntity.ok(exists);
    }
}
