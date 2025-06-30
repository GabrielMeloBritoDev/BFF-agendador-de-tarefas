package com.Swagger.BFF.business;

import com.Swagger.BFF.business.Dto.out.TarefaDtoOut;
import com.Swagger.BFF.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

   private final EmailClient emailClient;

     public void enviarEmail(TarefaDtoOut tarefaDtoOut){
        emailClient.enviarEmail(tarefaDtoOut);
    }
}
