package com.fds.sis_controle_assinaturas.dominio.auxiliares;

import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.PagamentoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoAssinaturaAdapter {
    PagamentoModel pagamento;
    AssinaturaModel assinaturaModel;
}
