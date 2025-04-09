package com.renan.agendadortarefas.services.mapper;


import com.renan.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.renan.agendadortarefas.services.dto.TarefasDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
