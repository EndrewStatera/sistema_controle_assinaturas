package com.fds.sis_controle_assinaturas.aplicacao.casosDeUso;

import com.fds.sis_controle_assinaturas.dominio.models.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;

public class VerificaAssinatura {
    private final IAssinaturaRepository assinaturaRepository;

    public VerificaAssinatura(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean verificar(Long id){
        AssinaturaModel assinatura = assinaturaRepository.getAssinaturaById(id);
        if (assinatura == null) {
            throw new IllegalArgumentException("Assinatura com esse id: " + id + " não existe");
        }

        assinatura.pagaAssinatura();
        

    }

}
