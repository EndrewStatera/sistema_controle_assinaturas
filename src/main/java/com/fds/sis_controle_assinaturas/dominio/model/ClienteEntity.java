package com.fds.sis_controle_assinaturas.dominio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_clientes")
public class ClienteEntity {

    private static final long SERIAL_ID = 1L;

    private Long id;
    private String user;
    private String email;

    public ClienteEntity(Long id, String user, String email){
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public ClienteEntity(String user, String email){
        this.user = user;
        this.email = email;
    }

}
