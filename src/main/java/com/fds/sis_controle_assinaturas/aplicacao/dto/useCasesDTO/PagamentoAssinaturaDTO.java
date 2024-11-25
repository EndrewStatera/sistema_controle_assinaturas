package com.fds.sis_controle_assinaturas.aplicacao.dto.useCasesDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class PagamentoAssinaturaDTO {
    float valorEstornado;
    LocalDate fimVigencia;
    String status;
}
