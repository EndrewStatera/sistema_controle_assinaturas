package com.fds.sis_controle_assinaturas.persistencia.Entities;

public class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [usuario=" + usuario + ", senha=" + senha + "]";
    }
}
