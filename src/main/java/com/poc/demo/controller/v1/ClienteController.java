package com.poc.demo.controller.v1;

import com.poc.demo.entity.ClienteRedis;
import com.poc.demo.service.ClienteRedisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    private ClienteRedisService clienteRedisService;

    public ClienteController(ClienteRedisService clienteRedisService) {
        this.clienteRedisService = clienteRedisService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteRedis save(@RequestBody ClienteRedis clienteRedis) {
        return clienteRedisService.save(clienteRedis);
    }

    @GetMapping
    public List<ClienteRedis> findAll(){
        return clienteRedisService.findAll();
    }
}
