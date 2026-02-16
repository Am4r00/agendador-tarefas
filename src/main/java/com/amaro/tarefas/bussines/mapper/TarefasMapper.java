package com.amaro.tarefas.bussines.mapper;

import com.amaro.tarefas.bussines.dto.TarefasDTO;
import com.amaro.tarefas.infrastructure.entity.Tarefas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    Tarefas paraTarefas (TarefasDTO dto);
    TarefasDTO paraTarefasDTO(Tarefas tarefas);

    List<TarefasDTO> paraTarefaDTO(List<Tarefas> tarefas);
    List<Tarefas> paraTarefa(List<TarefasDTO> tarefasDTO);
}
