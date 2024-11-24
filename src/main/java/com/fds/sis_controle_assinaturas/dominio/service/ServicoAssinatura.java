package com.fds.sis_controle_assinaturas.dominio.service;

import com.fds.sis_controle_assinaturas.dominio.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicoAssinatura {

    private final IAssinaturaRepository assinaturaRepository;

    public ServicoAssinatura(IAssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public AssinaturaDTO criarAssinatura(Long codigoCliente, Long codigoAplicativo) {
        AssinaturaModel novaAssinatura = new AssinaturaModel();
        novaAssinatura.setCodigoCliente(codigoCliente);
        novaAssinatura.setCodigoAplicativo(codigoAplicativo);
        novaAssinatura.setDataInicio(LocalDate.now());
        novaAssinatura.setDataEncerramento(null); // Inicialmente sem data de encerramento

        AssinaturaModel assinaturaSalva = assinaturaRepository.save(novaAssinatura);

        return new AssinaturaDTO(
            assinaturaSalva.getCodigoAssinatura(),
            assinaturaSalva.getCodigoCliente(),
            assinaturaSalva.getCodigoAplicativo(),
            assinaturaSalva.getDataInicio(),
            assinaturaSalva.getDataEncerramento()
        );
    }
}
