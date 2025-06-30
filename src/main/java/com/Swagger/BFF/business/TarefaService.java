package com.Swagger.BFF.business;


import com.Swagger.BFF.business.Dto.in.TarefaDtoIn;
import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import com.Swagger.BFF.infrastructure.Enuns.StatusNotificacaoEnum;
import com.Swagger.BFF.infrastructure.client.TarefaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

 private final TarefaClient tarefaClient;


    public TarefaDtoOut gravarTarefa(TarefaDtoIn tarefaDto, String token) {
        return tarefaClient.gravarTarefa(tarefaDto,token);
    }

    public List<TarefaDtoOut> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefaClient.buscarTarefasAgendadasPorPeriodo(dataFinal,dataInicial, token);
    }

    public List<TarefaDtoOut> buscaTarefaPorEmail(String token) {
        return tarefaClient.buscarTarefaPorEmail(token);
    }

    public void deletaTarefaPorId(String id,String token) {
         tarefaClient.deletaTarefaPorId(id, token);
    }

    public TarefaDtoOut alteraStatus(StatusNotificacaoEnum statusNotificacaoEnum, String id, String token) {
       return  tarefaClient.alteraStatus(statusNotificacaoEnum,id,token);
    }

    public TarefaDtoOut updateTarefas(TarefaDtoIn tarefaDto, String id, String token) {
        return tarefaClient.upadateTarefas(tarefaDto,id, token);
    }


}
