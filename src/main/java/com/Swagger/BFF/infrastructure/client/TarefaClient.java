package com.Swagger.BFF.infrastructure.client;


import com.Swagger.BFF.business.Dto.in.TarefaDtoIn;
import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import com.Swagger.BFF.infrastructure.Enuns.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@FeignClient(name = "tarefa", url ="${tarefa.url}")
public interface TarefaClient {

    @PostMapping
    TarefaDtoOut gravarTarefa(@RequestBody TarefaDtoIn tarefaDto,
                              @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefaDtoOut> buscarTarefasAgendadasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefaDtoOut> buscarTarefaPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefaDtoOut alteraStatus(@RequestParam("status") StatusNotificacaoEnum statusNotificacaoEnum,
                              @RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PutMapping
    TarefaDtoOut upadateTarefas(@RequestBody TarefaDtoIn tarefaDto, @RequestParam("id") String id,
                                @RequestHeader("Authorization") String token);
}