package com.fds.sis_controle_assinaturas.aplicacao.dto.useCasesDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaPrecoDTO {
    private Long id;
    private Float novoPreco;

    public AtualizaPrecoDTO(Long id, Float novoPreco) {
        this.id = id;
        this.novoPreco = novoPreco;
    }
}

