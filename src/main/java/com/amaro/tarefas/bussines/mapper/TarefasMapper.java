package com.amaro.tarefas.bussines.mapper;

import com.amaro.tarefas.bussines.dto.TarefasDTO;
import com.amaro.tarefas.infrastructure.entity.Tarefas;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasMapper {

    Tarefas paraTarefas (TarefasDTO dto);
    TarefasDTO paraTarefasDTO(Tarefas tarefas);
}
