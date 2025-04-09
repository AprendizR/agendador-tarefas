package com.renan.agendadortarefas.services;

import com.renan.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.renan.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.renan.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.renan.agendadortarefas.infrastructure.security.JwtUtil;
import com.renan.agendadortarefas.services.dto.TarefasDTO;
import com.renan.agendadortarefas.services.mapper.TarefasConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasServices {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefas(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}

