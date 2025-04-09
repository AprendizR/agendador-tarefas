package com.renan.agendadortarefas.controller;

import com.renan.agendadortarefas.services.TarefasServices;
import com.renan.agendadortarefas.services.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/tarefas")
@RequiredArgsConstructor

public class TarefasController {

    private final TarefasServices tarefasServices;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader ("authorization") String token){
        return ResponseEntity.ok(tarefasServices.gravarTarefas(token, dto));
    }

}
