package com.Swagger.BFF.infrastructure.client;

import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(name = "ViaEmail", url ="${ViaEmail.url}")
public interface EmailClient {
    void enviarEmail(@RequestBody TarefaDtoOut tarefaDto);

}
