package com.renan.agendadortarefas.services.mapper;


import com.renan.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.renan.agendadortarefas.services.dto.TarefasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaferasUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
