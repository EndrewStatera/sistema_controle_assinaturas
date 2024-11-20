package com.fds.sis_controle_assinaturas.aplicacao.dto;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String user;
    private String email;

    public ClienteDTO(String user, String email){
        this.user = user;
        this.email = email;
    }
}
