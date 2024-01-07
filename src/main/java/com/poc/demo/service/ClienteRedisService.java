package com.poc.demo.service;

import com.poc.demo.entity.Cliente;
import com.poc.demo.entity.ClienteRedis;
import com.poc.demo.repository.ClienteRedisRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class ClienteRedisService {

    private final int MINUTO = 1000 * 60;
    private final long MINUTOS = MINUTO * 1;

    private ClienteRedisRepository clienteRedisRepository;

    private ClienteService clienteService;

    public ClienteRedisService(ClienteRedisRepository clienteRedisRepository, ClienteService clienteService) {
        this.clienteRedisRepository = clienteRedisRepository;
        this.clienteService = clienteService;
    }

    public List<ClienteRedis> findAll(){
        return (List<ClienteRedis>) clienteRedisRepository.findAll();
    }

    public ClienteRedis save(ClienteRedis clienteRedis) {
        return clienteRedisRepository.save(clienteRedis);
    }

    @Scheduled(fixedDelay = MINUTOS)
    public void sincronizarClienteBancoDeDados(){
        List<ClienteRedis> clientesRedisList = findAll();

        if(CollectionUtils.isEmpty(clientesRedisList)) {
            System.out.println("Lista de Clientes Redis nula ou invalida");

        } else {
            List<Cliente> clientes = new ArrayList<>();

            clientesRedisList
                    .forEach(clienteRedis -> {
                        Cliente cliente = new Cliente();
                        cliente.setCpf(clienteRedis.getCpf());
                        cliente.setEmail(clienteRedis.getEmail());
                        cliente.setNome(clienteRedis.getNome());

                        clientes.add(cliente);
                    });
            clienteService.saveAll(clientes);
            clienteRedisRepository.deleteAll(clientesRedisList);
        }
    }
}
