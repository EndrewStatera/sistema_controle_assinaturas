package com.fds.sis_controle_assinaturas.dominio.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fds.sis_controle_assinaturas.aplicacao.dto.AssinaturaDTO;
import com.fds.sis_controle_assinaturas.dominio.auxiliares.StatusAssinatura;
import com.fds.sis_controle_assinaturas.dominio.model.AplicativoModel;
import com.fds.sis_controle_assinaturas.dominio.model.AssinaturaModel;
import com.fds.sis_controle_assinaturas.dominio.model.ClienteModel;
import com.fds.sis_controle_assinaturas.dominio.persistence.IAssinaturaRepository;
import com.fds.sis_controle_assinaturas.interface_adaptadora.controllers.assinatura_adapters.AssinaturaDTOModel;
import org.springframework.stereotype.Service;

/**
 * Service class for managing subscriptions (`AssinaturaModel`).
 * Provides methods to retrieve subscriptions based on various criteria
 * such as status and client.
 */
@Service
public class ServicoAssinatura {

    /**
     * Repository interface for subscription persistence operations.
     */
    private IAssinaturaRepository repository;

    /**
     * Constructs a new `ServicoAssinatura` with the specified repository.
     *
     * @param repository an implementation of `IAssinaturaRepository` used for data access
     */
    public ServicoAssinatura(IAssinaturaRepository repository){
        this.repository = repository;
    }

    /**
     * Retrieves a list of subscriptions filtered by their status.
     *
     * @param status the status to filter subscriptions by, represented by `StatusAssinatura` enum
     * @return a list of `AssinaturaModel` instances matching the specified status
     */
    public List<AssinaturaModel> getAssinaturasByStatus(StatusAssinatura status){
        List<AssinaturaModel> assinaturas = repository.all();

        if(status == StatusAssinatura.ATIVA) {
            assinaturas = repository.all().stream()
                    .filter(AssinaturaModel::isActive)
                    .collect(Collectors.toList());
        }
        else if(status == StatusAssinatura.INATIVA) {
            assinaturas = repository.all().stream()
                    .filter(Predicate.not(AssinaturaModel::isActive))
                    .collect(Collectors.toList());
        }

        return assinaturas;
    }

    /**
     * Retrieves a list of subscriptions associated with a specific client.
     *
     * @param cliente the `ClienteModel` instance representing the client
     * @return a list of `AssinaturaModel` instances associated with the specified client
     
    public List<AssinaturaModel> getAssinaturasByCliente(ClienteModel cliente){
        List<AssinaturaModel> assinaturas = repository.all().stream()
                .filter(assinatura -> assinatura.getCliente().getId().equals(cliente.getId()))
                .collect(Collectors.toList());
        return assinaturas;
    }*/

    public List<AssinaturaModel> assByClientes(long clienteID){
        //return repository.getByCliente(clienteID);
        List<AssinaturaModel> assinaturas = repository.getByCliente(clienteID);
        return assinaturas;
    }

    /**
     * Retrieves a list of subscriptions associated with a specific application client.
     *
     * @param cliente the `AplicativoModel` instance representing the application client
     * @return a list of `AssinaturaModel` instances associated with the specified application client
     */
    public List<AssinaturaModel> getAssinaturasByAplivativo(AplicativoModel cliente){
        List<AssinaturaModel> assinaturas = repository.all().stream()
                .filter(assinatura -> assinatura.getCliente().getId().equals(cliente.getCodigo()))
                .collect(Collectors.toList());
        return assinaturas;
    }

    /**
     * Checks if a subscription with the specified ID exists.
     *
     * @param id the ID of the subscription to check
     * @return `true` if the subscription exists, `false` otherwise
     */
    public boolean getAssinaturaStatus(Long id){
        return repository.getAssinaturaById(id) != null;
    }

    public AssinaturaModel criaAssinatura(AssinaturaDTO assinaturaDTO){
        AssinaturaModel model = AssinaturaDTOModel.toAssinaturaModel(assinaturaDTO);
        return repository.salvaAssinatura(model);
    }

    public List<AssinaturaModel> getAll(){
        return repository.all();
    }

    /**
     * Verifica se uma assinatura é válida com base no ID.
     *
     * @param id o ID da assinatura a ser verificada
     * @return `true` se a assinatura é válida, `false` caso contrário
     */
    public boolean isAssinaturaValida(Long id) {
        AssinaturaModel assinatura = repository.getAssinaturaById(id);
        if (assinatura == null) {
            return false;
        }
        LocalDate hoje = LocalDate.now();
        System.out.println("HEEEEEEEEEEEEEY ESTOU AQUI");
        System.out.println("Assinatura id: " + assinatura.getId());
        System.out.println(assinatura);

        boolean dentroDoPeriodo = 
            (hoje.isEqual(assinatura.getInicioVigencia()) || hoje.isAfter(assinatura.getInicioVigencia())) &&
            (hoje.isEqual(assinatura.getFimVigencia()) || hoje.isBefore(assinatura.getFimVigencia()));

        return assinatura.isActive() && dentroDoPeriodo;
    }

    public AssinaturaModel registrarAssinatura(ClienteModel cliente, AplicativoModel aplicativo){
        if(cliente == null || aplicativo == null){
            return null;
        }
        if(contains(cliente, aplicativo))return null;
        return this.repository.criaAssinatura(cliente, aplicativo);
    }

    public List<AssinaturaModel> getAssinaturaByApp(Long id){
        return this.repository.getByApp(id);
    }

    public boolean contains(ClienteModel cliente, AplicativoModel app){
//        List<AssinaturaModel> assinaturas = repository.all().stream().
//                filter(assinatura -> assinatura.getApp().getCodigo() == app.getCodigo() &&
//                assinatura.getCliente().getId() == cliente.getId()).toList();
        return repository.all().stream().
                anyMatch(assinatura -> Objects.equals(assinatura.getApp().getCodigo(), app.getCodigo()) &&
                        Objects.equals(assinatura.getCliente().getId(), cliente.getId()));
    }
}
