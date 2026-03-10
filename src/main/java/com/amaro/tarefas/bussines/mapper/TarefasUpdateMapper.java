package com.amaro.tarefas.bussines.mapper;

import com.amaro.tarefas.bussines.dto.out.TarefasDTO;
import com.amaro.tarefas.infrastructure.entity.Tarefas;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefasUpdateMapper {

    void updateTarefas(TarefasDTO tarefasDTO, @MappingTarget Tarefas tarefas);
}
