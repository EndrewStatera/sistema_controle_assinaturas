package com.fds.sis_controle_assinaturas.dominio.model;

import java.time.LocalDate;

public interface IPromocao {
    public float calcularPromocao(AssinaturaModel assinaturaModel);
    public LocalDate promoDataVigencia(AssinaturaModel assinatura);
    public long getCodigo();
}
