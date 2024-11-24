package com.fds.sis_controle_assinaturas.dominio.controller;

import com.fds.sis_controle_assinaturas.dominio.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.service.ServicoAssinatura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final ServicoAssinatura servicoAssinatura;

    public AssinaturaController(ServicoAssinatura servicoAssinatura) {
        this.servicoAssinatura = servicoAssinatura;
    }

    @PostMapping
    public ResponseEntity<AssinaturaDTO> criaAssinatura(@RequestBody AssinaturaDTO assinaturaDTO) {
        AssinaturaDTO novaAssinatura = servicoAssinatura.criarAssinatura(
            assinaturaDTO.getCodigoCliente(),
            assinaturaDTO.getCodigoAplicativo()
        );
        return ResponseEntity.ok(novaAssinatura);
    }
}
