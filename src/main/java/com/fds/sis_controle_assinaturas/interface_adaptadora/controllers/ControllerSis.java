package com.fds.sis_controle_assinaturas.interface_adaptadora.controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AplicativoDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto;
import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@EnableAutoConfiguration
public class ControllerSis {
    
    @GetMapping("/servcad/clientes")
    public List<ClienteDTO> getClientesCadastrados() {
        return null;
    }

    @GetMapping("/servcad/aplicativos")
    public List<AplicativoDTO> getAplicativosCadastrados() {
        return null;
    }

    @PostMapping("/servcad/assinaturas")
    public List<AssinaturaDTO> getAssinaturas(@RequestBody AssinaturaDTO entity) {
        //TODO: process POST request
        
        return null;
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
