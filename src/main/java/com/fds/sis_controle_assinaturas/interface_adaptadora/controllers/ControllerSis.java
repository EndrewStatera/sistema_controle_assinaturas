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
import com.fds.sis_controle_assinaturas.aplicacao.dto.CadastAssinaturaDTO;
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
    AssinaturasByCliente assByCliente;
    GetAssinaturaByApp getAssinaturaByApp;

    @Autowired
    public ControllerSis(AtualizaPrecoApp atualizaPrecoApp,
                         CriarAssinatura criarAssinatura,
                         GetAplicativos getAplicativos,
                         GetAssinaturaByStatus getAssinaturaByStatus,
                         GetAssinaturas getAssinaturas,
                         GetClientes getClientes,
                         GetClienteById getClienteById,
                         GetAppById getAppById,
                         CheckAssinaturaByStts checkStatus,
                         AssinaturasByCliente assByCliente,
                         GetAssinaturaByApp getAssinaturaByApp) {
        this.atualizaPrecoApp = atualizaPrecoApp;
        this.criarAssinatura = criarAssinatura;
        this.getAplicativos = getAplicativos;
        this.getAssinaturaByStatus = getAssinaturaByStatus;
        this.getAssinaturas = getAssinaturas;
        this.getClientes = getClientes;
        this.getClienteById = getClienteById;
        this.getAppById = getAppById;
        this.checkStatus = checkStatus;
        this.assByCliente = assByCliente;
        this.getAssinaturaByApp = getAssinaturaByApp;
    }

    @GetMapping("/servcad/clientes") //feito
    public List<ClienteDTO> getClientesCadastrados() {
        return getClientes.run();
    }

    @GetMapping("/servcad/aplicativos") //feito
    public List<AplicativoDTO> getAplicativosCadastrados() {
        
        return getAplicativos.run();
    }

    @GetMapping("/servcad/assinaturas") //feito
    public List<AssinaturaDTO> getAssinaturas() {
        //TODO: process POST request
        
        return getAssinaturas.run();
    }

    @PostMapping("/servcad/assinaturas") //feito 
    public AssinaturaDTO criaAssinatura(@RequestBody CadastAssinaturaDTO assinaturaCadastrada){
        return criarAssinatura.run(assinaturaCadastrada.getCliente(), assinaturaCadastrada.getApp());
    }
    
    @PutMapping("/servcad/aplicativos/atualizacusto/{id}") //feito?
    public AplicativoDTO postMethodName(@PathVariable("id") Long id, @RequestBody AtualizaPrecoDTO entity) {
        //TODO: process POST request
        entity.setId(id);
        return atualizaPrecoApp.run(entity);
    }
    
    @GetMapping("/servcad/assinaturas/{tipo}") //feito
    public List<AssinaturaDTO> getAssinaturaByType(@PathVariable("tipo") Integer param) {
        return switch (param) {
            case 1 -> getAssinaturaByStatus.run(StatusAssinatura.ATIVA);
            case 2 -> getAssinaturaByStatus.run(StatusAssinatura.INATIVA);
            case 3 -> getAssinaturaByStatus.run(StatusAssinatura.QUALQUER);
            default -> null;
        };
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public List<AssinaturaDTO> getAssinaturaByCliente(@PathVariable(value = "codcli") long clienteID){
        return assByCliente.run(clienteID);
    }

    @GetMapping("/servcad/app/{id}")
    public AplicativoDTO getAppById(@PathVariable("id") Long id) {
        return this.getAppById.run(id);
    }@GetMapping("/servcad/assapp/{id}")
    public List<AssinaturaDTO> getAssinaturaByApp(@PathVariable("id") Long id) {
        return this.getAssinaturaByApp.run(id);
    }
    
    @PostMapping("/registrarpagamento")
    public PagamentoDTO registerPagamento(@RequestBody PagamentoDTO entity) {
        //TODO: process POST request

        return null;
    }

    @GetMapping("/assinvalida/{codass}")
    public Boolean checkAssinaturaStatus(@PathVariable("codass") Long codAssinatura) {
        return checkStatus.run(codAssinatura);
    }
}
