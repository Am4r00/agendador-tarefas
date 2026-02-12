package com.amaro.tarefas.infrastructure.repository;

import com.amaro.tarefas.infrastructure.entity.Tarefas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefasRepository extends MongoRepository<Tarefas, String> {
}
