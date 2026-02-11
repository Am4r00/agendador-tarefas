package com.amaro.tarefas.infrastructure.client;

import com.amaro.tarefas.bussines.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "usuario", url = "${usuario.url}")
@Component
public interface UsuarioClient {

    @GetMapping("/{email}")
    UsuarioDTO buscarUsuario(@PathVariable String email,
                             @RequestHeader("Authorization") String token);
}
