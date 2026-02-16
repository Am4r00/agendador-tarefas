package com.amaro.tarefas.infrastructure.repository;

import com.amaro.tarefas.infrastructure.entity.Tarefas;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefasRepository extends MongoRepository<Tarefas, String> {

    List<Tarefas> findByDataEventoBetween(LocalDateTime comeco, LocalDateTime fim );

    List<Tarefas> findByEmailUsuario(String Email);
}
