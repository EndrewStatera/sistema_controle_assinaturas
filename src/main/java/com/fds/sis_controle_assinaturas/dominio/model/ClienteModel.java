package com.fds.sis_controle_assinaturas.dominio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClienteModel {

    private static final long SERIAL_ID = 1L;

    private Long id;
    private String user;
    private String email;

    public ClienteModel(Long id, String user, String email){
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public ClienteModel(String user, String email){
        this.user = user;
        this.email = email;
    }

}