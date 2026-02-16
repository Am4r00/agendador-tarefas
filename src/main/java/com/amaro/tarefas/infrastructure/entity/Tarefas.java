package com.amaro.tarefas.infrastructure.entity;

import com.amaro.tarefas.infrastructure.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document("tarefa")
public class Tarefas {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private LocalDateTime dataEvento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private String emailUsuario;
    private Status statusTarefa;
}
