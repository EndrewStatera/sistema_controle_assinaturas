package com.fds.sis_controle_assinaturas.interface_adaptadora.controllers.assinatura_adapters;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.aplicacao.dto.ClienteDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;

public class AssinaturaDTOModel {
    public static AssinaturaModel toAssinaturaModel(AssinaturaDTO assinaturaDTO){
        return new AssinaturaModel(AplicativoDTOModel.toAppModel(assinaturaDTO.getApp()),
                ClienteDTOModel.toClienteModel(assinaturaDTO.getCliente()),
                assinaturaDTO.getInicioVigencia(),
                assinaturaDTO.getFimVigencia());
    }

    public static AssinaturaDTO toAssinaturaDTO(AssinaturaModel assinatura){
        return new AssinaturaDTO(AplicativoDTOModel.toAppDTO(assinatura.getApp()),
                ClienteDTOModel.toClienteDTO(assinatura.getCliente()),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia());
    }
}
