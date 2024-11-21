package com.fds.sis_controle_assinaturas.interface_adaptadora.controllers.assinatura_adapters;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;

public class AssinaturaDTOModel {
    public static AssinaturaModel toAssinaturaModel(AssinaturaDTO assinaturaDTO){
        return new AssinaturaModel(assinaturaDTO.getApp());
    }
}
