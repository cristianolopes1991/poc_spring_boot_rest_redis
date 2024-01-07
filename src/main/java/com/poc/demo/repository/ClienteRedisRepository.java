package com.poc.demo.repository;

import com.poc.demo.entity.ClienteRedis;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRedisRepository extends CrudRepository <ClienteRedis, String> {
}
