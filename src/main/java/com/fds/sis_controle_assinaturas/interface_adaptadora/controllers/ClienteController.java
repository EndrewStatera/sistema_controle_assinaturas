package com.fds.sis_controle_assinaturas.aplicacao.controller;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoCliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing clients (`ClienteModel`).
 * Exposes endpoints to retrieve and manage client data.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ServicoCliente servicoCliente;

    public ClienteController(ServicoCliente servicoCliente) {
        this.servicoCliente = servicoCliente;
    }

    /**
     * Retrieves a client by their ID.
     *
     * @param id the ID of the client
     * @return the client data, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getClienteById(@PathVariable Long id) {
        ClienteModel cliente = servicoCliente.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    /**
     * Retrieves a list of all clients.
     *
     * @return a list of all clients
     */
    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllClientes() {
        List<ClienteModel> clientes = servicoCliente.all();
        return ResponseEntity.ok(clientes);
    }
}
