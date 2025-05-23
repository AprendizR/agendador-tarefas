package com.renan.agendadortarefas.infrastructure.repository;

import com.renan.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.renan.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum
            (LocalDateTime dataInicial, LocalDateTime dataFinal, StatusNotificacaoEnum status);

    List<TarefasEntity> findByEmailUsuario(String token);
}
