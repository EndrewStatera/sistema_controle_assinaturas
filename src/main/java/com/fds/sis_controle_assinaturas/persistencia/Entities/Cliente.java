package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "CLIENTES")
@Entity
public class Cliente {
    private static final long SERIAL_ID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    
    public Cliente(Long id, String user, String email){
        this.id = id;
        this.username = user;
        this.email = email;
    }

    public Cliente(String user, String email){
        this.username = user;
        this.email = email;
    }

    public static ClienteModel toClienteModel(Cliente cliente){
        return new ClienteModel(cliente.getId(), cliente.getUsername(), cliente.email );
    }

    public static Cliente fromClienteModel(ClienteModel cliente){
        return new Cliente(cliente.getId(), cliente.getUser(), cliente.getEmail());
    }
}
