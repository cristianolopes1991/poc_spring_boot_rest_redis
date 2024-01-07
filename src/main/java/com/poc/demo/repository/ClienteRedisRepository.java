package com.poc.demo.repository;

import com.poc.demo.entity.ClienteRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRedisRepository extends CrudRepository <ClienteRedis, String> {
}
