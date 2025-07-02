package com.Swagger.BFF.business;


import com.Swagger.BFF.business.Dto.in.Login_In;
import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import com.Swagger.BFF.infrastructure.Enuns.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioSevice usuarioSevice;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
     public void buscaTarefasDaProximaHora(){
         String token = login(converterParaInDto());
        LocalDateTime horaNotificacao = LocalDateTime.now().plusHours(1);
        LocalDateTime horaMaisCinco  = LocalDateTime.now().plusHours(1).plusMinutes(5);
        List<TarefaDtoOut> listaDeTarefas =  tarefaService.buscarTarefasAgendadasPorPeriodo(horaNotificacao,horaMaisCinco,token);
        listaDeTarefas.forEach(tarefa -> {emailService.enviarEmail(tarefa);
                    tarefaService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),token);});
     }
     public String login(Login_In loginIn){
         return  usuarioSevice.loginUsuario(loginIn);
     }
     public Login_In converterParaInDto(){
         return Login_In.builder()
                 .email(email)
                 .senha(senha)
                 .build();
     }
}
