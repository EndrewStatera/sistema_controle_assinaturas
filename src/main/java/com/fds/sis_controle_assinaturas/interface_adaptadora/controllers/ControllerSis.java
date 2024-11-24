package com.fds.sis_controle_assinaturas.interface_adaptadora.controllers;

import java.util.List;

import com.fds.sis_controle_assinaturas.aplicacao.casosDeUso.*;
import com.fds.sis_controle_assinaturas.aplicacao.dto.useCasesDTO.AtualizaPrecoDTO;
import com.fds.sis_controle_assinaturas.dominio.auxiliares.StatusAssinatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.PagamentoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;

@EnableAutoConfiguration
@RestController
public class ControllerSis {
    AtualizaPrecoApp atualizaPrecoApp;
    CriarAssinatura criarAssinatura;
    GetAplicativos getAplicativos;
    GetAssinaturaByStatus getAssinaturaByStatus;
    GetAssinaturas getAssinaturas;
    GetClientes getClientes;
    GetClienteById getClienteById;
    GetAppById getAppById;
    CheckAssinaturaByStts checkStatus;


    @Autowired
    public ControllerSis(AtualizaPrecoApp atualizaPrecoApp,
                         CriarAssinatura criarAssinatura,
                         GetAplicativos getAplicativos,
                         GetAssinaturaByStatus getAssinaturaByStatus,
                         GetAssinaturas getAssinaturas,
                         GetClientes getClientes,
                         GetClienteById getClienteById,
                         GetAppById getAppById) {
        this.atualizaPrecoApp = atualizaPrecoApp;
        this.criarAssinatura = criarAssinatura;
        this.getAplicativos = getAplicativos;
        this.getAssinaturaByStatus = getAssinaturaByStatus;
        this.getAssinaturas = getAssinaturas;
        this.getClientes = getClientes;
        this.getClienteById = getClienteById;
        this.getAppById = getAppById;
    }

    @GetMapping("/servcad/clientes")
    public List<ClienteDTO> getClientesCadastrados() {
        return getClientes.run();
    }

    @GetMapping("/servcad/aplicativos")
    public List<AplicativoDTO> getAplicativosCadastrados() {
        
        return getAplicativos.run();
    }

    @GetMapping("/servcad/assinaturas")
    public List<AssinaturaDTO> getAssinaturas() {
        //TODO: process POST request
        
        return getAssinaturas.run();
    }
    
    @PutMapping("/servcad/aplicativos/atualizacusto/{id}")
    public AplicativoDTO postMethodName(@PathVariable("id") Long id, @RequestBody AtualizaPrecoDTO entity) {
        //TODO: process POST request
        entity.setId(id);
        return atualizaPrecoApp.run(entity);
    }
    
    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<AssinaturaDTO> getAssinaturaByType(@PathVariable("tipo") Integer param) {
        return switch (param) {
            case 1 -> getAssinaturaByStatus.run(StatusAssinatura.ATIVA);
            case 2 -> getAssinaturaByStatus.run(StatusAssinatura.INATIVA);
            case 3 -> getAssinaturaByStatus.run(StatusAssinatura.QUALQUER);
            default -> null;
        };
    }

    @GetMapping("/servcad/asscli/{id}")
    public ClienteDTO getClienteById(@PathVariable("id") Long id) {
        return getClienteById.run(id);
    }

    @GetMapping("/servcad/assapp{id}")
    public AplicativoDTO getAppById(@PathVariable("id") Long id) {
        return this.getAppById.run(id);
    }
    
    @PostMapping("/registrarpagamento")
    public PagamentoDTO registerPagamento(@RequestBody PagamentoDTO entity) {
        //TODO: process POST request
        
        return null;
    }

    @GetMapping("/assinvalida/{codass}")
    public Boolean checkAssinaturaStatus(@RequestParam Long codAssinatura) { //não consigo testar, amigo Endrew!!! Tenta aí por favor <33
        return checkStatus.run(codAssinatura);
    }
    
    
}
