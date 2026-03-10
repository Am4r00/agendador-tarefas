package com.amaro.tarefas.bussines.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefasInDTO {
    private String nome;

    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
}
