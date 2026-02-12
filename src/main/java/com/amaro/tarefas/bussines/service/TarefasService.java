package com.amaro.tarefas.bussines.service;

import com.amaro.tarefas.bussines.dto.TarefasDTO;
import com.amaro.tarefas.bussines.mapper.TarefasMapper;
import com.amaro.tarefas.infrastructure.entity.Tarefas;
import com.amaro.tarefas.infrastructure.enums.Status;
import com.amaro.tarefas.infrastructure.repository.TarefasRepository;
import com.amaro.tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;
    private final JwtUtil jwtUtil;


    public TarefasDTO criarTarefa (String token, TarefasDTO tarefasDTO){
        String email = jwtUtil.extractUsername(token.substring(7));
        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusTarefa(Status.PENDENTE);
        tarefasDTO.setEmailUsuario(email);
        Tarefas tarefas = tarefasMapper.paraTarefas(tarefasDTO);

        return tarefasMapper.paraTarefasDTO(tarefasRepository.save(tarefas));
    }
}
