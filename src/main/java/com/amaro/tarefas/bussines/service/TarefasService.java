package com.amaro.tarefas.bussines.service;

import com.amaro.tarefas.bussines.dto.in.TarefasInDTO;
import com.amaro.tarefas.bussines.dto.out.TarefasDTO;
import com.amaro.tarefas.bussines.mapper.TarefasMapper;
import com.amaro.tarefas.bussines.mapper.TarefasUpdateMapper;
import com.amaro.tarefas.infrastructure.entity.Tarefas;
import com.amaro.tarefas.infrastructure.enums.Status;
import com.amaro.tarefas.infrastructure.exception.ResourceNotFoundException;
import com.amaro.tarefas.infrastructure.repository.TarefasRepository;
import com.amaro.tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;
    private final JwtUtil jwtUtil;
    private final TarefasUpdateMapper tarefasUpdateMapper;


    public TarefasDTO criarTarefa(String token, TarefasInDTO dto) {
        String email = jwtUtil.extractUsername(token.substring(7));
        TarefasDTO tarefasDTO = tarefasMapper.inParaTarefasDTO(dto);

        tarefasDTO.setDataCriacao(LocalDateTime.now());
        tarefasDTO.setStatusTarefa(Status.PENDENTE);
        tarefasDTO.setEmailUsuario(email);
        Tarefas tarefas = tarefasMapper.paraTarefas(tarefasDTO);

        return tarefasMapper.paraTarefasDTO(tarefasRepository.save(tarefas));
    }

    public List<TarefasDTO> buscarTarefaPorDatas(LocalDateTime comeco, LocalDateTime fim) {
        return tarefasMapper.paraTarefaDTO(tarefasRepository.findByDataEventoBetween(comeco, fim));
    }

    public List<TarefasDTO> buscarTarefaPorEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return tarefasMapper.paraTarefaDTO(tarefasRepository.findByEmailUsuario(email));
    }

    public void deletarTarefa(String id) {
        try {
            tarefasRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Tarefa não encontrada !" + e.getCause());
        }
    }

    public TarefasDTO alterarStatus(Status status, String id) {
        try {
            Tarefas tarefas = tarefasRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Tarefa com o id passado não foi econtrado !"));
            tarefas.setStatusTarefa(status);
            return tarefasMapper.paraTarefasDTO(tarefasRepository.save(tarefas));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Houve um erro ao tentar modificar o status " + e.getCause());
        }
    }

    public TarefasDTO atualizarTarefa(TarefasDTO tarefasDTO, String id) {
        try {
            Tarefas tarefas = tarefasRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Tarefa com o id passado não foi econtrado ! "));
            tarefasUpdateMapper.updateTarefas(tarefasDTO,tarefas);
            return tarefasMapper.paraTarefasDTO(tarefasRepository.save(tarefas));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Houve um erro ao tentar modificar a tarefa " + e.getCause());
        }
    }


}
