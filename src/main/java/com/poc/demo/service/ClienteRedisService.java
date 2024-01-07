package com.poc.demo.service;

import com.poc.demo.entity.ClienteRedis;
import com.poc.demo.repository.ClienteRedisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteRedisService {

    private ClienteRedisRepository clienteRedisRepository;

    public ClienteRedisService(ClienteRedisRepository clienteRedisRepository) {
        this.clienteRedisRepository = clienteRedisRepository;
    }

    public ClienteRedis save(ClienteRedis clienteRedis) {
        return clienteRedisRepository.save(clienteRedis);
    }

    public List<ClienteRedis> findAll(){
        return (List<ClienteRedis>) clienteRedisRepository.findAll();
    }
}
