package com.Swagger.BFF.infrastructure.client;

import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(name = "emailClient", url = "${notificacao.url}")
public interface EmailClient {
    @PostMapping
    void enviarEmail(@RequestBody TarefaDtoOut tarefaDto);

}
