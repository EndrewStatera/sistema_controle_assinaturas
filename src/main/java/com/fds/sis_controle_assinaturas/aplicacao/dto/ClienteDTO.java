package com.fds.sis_controle_assinaturas.aplicacao.dto;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String user;
    private String email;

    public ClienteDTO(Long id, String user, String email){
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public static ClienteDTO fromClieModel(ClienteModel cliModel) {
        return new ClienteDTO(cliModel.getId(), cliModel.getUser(), cliModel.getEmail());
    }
}
