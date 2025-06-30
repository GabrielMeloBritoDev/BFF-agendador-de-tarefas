package com.Swagger.BFF.controller;


import com.Swagger.BFF.business.Dto.in.TarefaDtoIn;
import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import com.Swagger.BFF.business.TarefaService;
import com.Swagger.BFF.infrastructure.Config.SecurityConfig;
import com.Swagger.BFF.infrastructure.Enuns.StatusNotificacaoEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
@Tag(name = "tarefa", description = "Agendador de tarefas para os usuarios ")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME )
public class TarefaController {

    private final TarefaService tarefaService;


    @Operation(summary = "Salvar tarefas do usuario", description = "Cria uma nova tarefa")
    @PostMapping
    public ResponseEntity<TarefaDtoOut> gravarTarefa(@RequestBody TarefaDtoIn tarefaDto,
                                                     @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(tarefaDto,token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Buscas tarefas de  usuario por periodo", description = "Busca tarefas por periodo de tempo")
    public ResponseEntity<List<TarefaDtoOut>> buscarTarefasAgendadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(
                tarefaService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal,token)
        );
    }


    @GetMapping
    @Operation(summary = "Buscas tarefas de  usuario por email", description = "Busca tarefas por email")
    public ResponseEntity<List<TarefaDtoOut>> buscarTarefaPorEmail(@RequestHeader(
                                                                    name = "Authorization", required = false) String token ){
        return ResponseEntity.ok(tarefaService.buscaTarefaPorEmail(token));
    }
    @DeleteMapping
    @Operation(summary = "Delata tarefas de  usuario por id", description = "Deleta tarefas por Id")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token){
        tarefaService.deletaTarefaPorId(id,token);

        return  ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status da tarefas ", description = "Altera status tarefas")
    public ResponseEntity<TarefaDtoOut> alteraStatus(@RequestParam("status") StatusNotificacaoEnum statusNotificacaoEnum,
                                                     @RequestParam("id") String id,
                                                     @RequestHeader(name = "Authorization", required = false) String token){
        return  ResponseEntity.ok(tarefaService.alteraStatus(statusNotificacaoEnum, id,token));
    }

    @PutMapping
    @Operation(summary = "Altera dados da tarefas ", description = "Altera dados tarefas")
    public ResponseEntity<TarefaDtoOut> upadateTarefas(@RequestBody TarefaDtoIn tarefaDto, @RequestParam("id") String id,
                                                       @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefaService.updateTarefas(tarefaDto,id,token));
    }
}
