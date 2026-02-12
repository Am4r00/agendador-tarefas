package com.amaro.tarefas.controller;

import com.amaro.tarefas.bussines.dto.TarefasDTO;
import com.amaro.tarefas.bussines.mapper.TarefasMapper;
import com.amaro.tarefas.bussines.service.TarefasService;
import com.amaro.tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
public class TarefasController {
    private final TarefasService tarefasService;


    @PostMapping
    public ResponseEntity<TarefasDTO> criarTarefa(@RequestHeader("Authorization")  String token,
                                                  @RequestBody TarefasDTO tarefasDTO){
        return ResponseEntity.ok(tarefasService.criarTarefa(token,tarefasDTO));
    }
}
