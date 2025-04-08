package com.renan.agendadortarefas.services.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTO {

    private String email;
    private String senha;
}
