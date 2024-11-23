package com.fds.sis_controle_assinaturas.interface_adaptadora.controllers;

import java.util.List;

import com.fds.sis_controle_assinaturas.aplicacao.casosDeUso.*;
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

    @Autowired
    public ControllerSis(AtualizaPrecoApp atualizaPrecoApp,
                         CriarAssinatura criarAssinatura,
                         GetAplicativos getAplicativos,
                         GetAssinaturaByStatus getAssinaturaByStatus,
                         GetAssinaturas getAssinaturas,
                         GetClientes getClientes) {
        this.atualizaPrecoApp = atualizaPrecoApp;
        this.criarAssinatura = criarAssinatura;
        this.getAplicativos = getAplicativos;
        this.getAssinaturaByStatus = getAssinaturaByStatus;
        this.getAssinaturas = getAssinaturas;
        this.getClientes = getClientes;
    }

    @GetMapping("/servcad/clientes")
    public List<ClienteDTO> getClientesCadastrados() {
        return getClientes.run();
    }

    @GetMapping("/servcad/aplicativos")
    public List<AplicativoDTO> getAplicativosCadastrados() {

        return getAplicativos.run();
    }

    @PostMapping("/servcad/assinaturas")
    public List<AssinaturaDTO> getAssinaturas(@RequestBody AssinaturaDTO entity) {
        //TODO: process POST request
        
        return getAssinaturas.run();
    }
    
    @PostMapping("/servcad/aplicativos/atualizacusto/:idAplicativo")
    public AplicativoDTO postMethodName(@RequestBody AplicativoDTO entity) {
        //TODO: process POST request
        
        return null;
    }
    
    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<AssinaturaDTO> getAssinaturaByType(@RequestParam String param) {
        return null;
    }

    @GetMapping("/servcad/asscli/:codcli")
    public ClienteDTO getClienteById(@RequestParam String param) {
        return null;
    }

    @GetMapping("/servcad/assapp/:codapp")
    public AplicativoDTO getAppById(@RequestParam String param) {
        return null;
    }
    
    @PostMapping("/registrarpagamento")
    public PagamentoDTO registerPagamento(@RequestBody PagamentoDTO entity) {
        //TODO: process POST request
        
        return null;
    }

    @GetMapping("/assinvalida/:codass")
    public Boolean checkAssinaturaStatus(@RequestParam String param) {
        return null;
    }
    
    
    
}
