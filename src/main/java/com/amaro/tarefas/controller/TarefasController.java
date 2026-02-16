package com.amaro.tarefas.controller;

import com.amaro.tarefas.bussines.dto.TarefasDTO;
import com.amaro.tarefas.bussines.mapper.TarefasMapper;
import com.amaro.tarefas.bussines.service.TarefasService;
import com.amaro.tarefas.infrastructure.enums.Status;
import com.amaro.tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscarTarefasPorData(
            @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)LocalDateTime comeco,
            @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)LocalDateTime fim){
        return ResponseEntity.ok(tarefasService.buscarTarefaPorDatas(comeco,fim));
    }

    @GetMapping()
    public ResponseEntity<List<TarefasDTO>> buscarTarefasPorData(@RequestHeader("Authorization")  String token){
        return ResponseEntity.ok(tarefasService.buscarTarefaPorEmail(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam("id") String  id){
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasDTO> alterarStatusTarefa(@RequestParam("status") Status status,
                                                          @RequestParam("id")String id){
        return ResponseEntity.ok(tarefasService.alterarStatus(status, id));
    }

    @PutMapping
    public ResponseEntity<TarefasDTO> alterarTarefa(@RequestBody TarefasDTO tarefasDTO,
                                                    @RequestParam("id") String id){
        return ResponseEntity.ok(tarefasService.atualizarTarefa(tarefasDTO, id));
    }
}
