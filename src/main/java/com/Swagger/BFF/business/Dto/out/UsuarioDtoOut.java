package com.Swagger.BFF.business.Dto.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDtoOut {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoOut> enderecos;
    private List<TelefoneDtoOut> telefones;
}
