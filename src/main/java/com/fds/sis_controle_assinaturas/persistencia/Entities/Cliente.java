package com.fds.sis_controle_assinaturas.persistencia.Entities;

import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "clientes")
public class Cliente {
    private static final long SERIAL_ID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "user")
    private String user;
    @Column(name = "email")
    private String email;
    
    public Cliente(Long id, String user, String email){
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public Cliente(String user, String email){
        this.user = user;
        this.email = email;
    }

    public static ClienteModel toClienteModel(Cliente cliente){
        return new ClienteModel(cliente.getId(), cliente.getUser(), cliente.email );
    }
}
