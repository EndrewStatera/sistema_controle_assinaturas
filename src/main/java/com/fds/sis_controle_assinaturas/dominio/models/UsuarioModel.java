package com.fds.sis_controle_assinaturas.dominio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioModel {
    private String usuario;
    private String senha;
}
