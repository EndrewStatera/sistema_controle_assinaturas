package com.fds.sis_controle_assinaturas.aplicacao.controller;

import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAplicativo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for managing applications (`AplicativoModel`).
 * Exposes endpoints to retrieve and update application data.
 */
@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {

    private final ServicoAplicativo servicoAplicativo;

    public AplicativoController(ServicoAplicativo servicoAplicativo) {
        this.servicoAplicativo = servicoAplicativo;
    }

    /**
     * Updates the monthly cost of an application.
     *
     * @param id the ID of the application
     * @param novoCusto the new monthly cost to set
     * @return the updated application data, or 400 if the cost is invalid
     */
    @PutMapping("/{id}/custo")
    public ResponseEntity<AplicativoModel> atualizaCusto(@PathVariable Long id, @RequestParam Float novoCusto) {
        if (novoCusto < 0) {
            return ResponseEntity.badRequest().body(null); // Invalid cost
        }
        AplicativoModel updatedApp = servicoAplicativo.atualizaCusto(id, novoCusto);
        if (updatedApp == null) {
            return ResponseEntity.notFound().build(); // Application not found
        }
        return ResponseEntity.ok(updatedApp);
    }
}
