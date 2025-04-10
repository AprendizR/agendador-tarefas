package com.renan.agendadortarefas.controller;

import com.renan.agendadortarefas.services.TarefasServices;
import com.renan.agendadortarefas.services.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping ("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasDTO
            (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME )LocalDateTime dataInicial,
             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal){
        return ResponseEntity.ok(tarefasServices.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>>buscaTarefasPorEmail(@RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(tarefasServices.buscaTarefasPorEmail(token));

    }

}
