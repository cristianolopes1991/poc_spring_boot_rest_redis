package com.poc.demo.service;

import com.poc.demo.entity.Cliente;
import com.poc.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void saveAll(List<Cliente> clientes) {
        clienteRepository.saveAll(clientes);
    }
}
