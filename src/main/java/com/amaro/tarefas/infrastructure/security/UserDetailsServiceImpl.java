package com.amaro.tarefas.infrastructure.security;

import com.amaro.tarefas.bussines.dto.UsuarioDTO;
import com.amaro.tarefas.infrastructure.client.UsuarioClient;
import com.amaro.usuario.infrastructure.entity.Usuario;
import com.amaro.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails loadUserByUsername(String email, String token) {
        UsuarioDTO usuarioDTO = client.buscarUsuario(email, token);
        return User.withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha()).build();
    }
}
