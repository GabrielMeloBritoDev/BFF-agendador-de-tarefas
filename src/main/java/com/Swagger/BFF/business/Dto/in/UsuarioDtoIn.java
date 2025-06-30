package com.Swagger.BFF.business.Dto.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDtoIn {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoIn> enderecos;
    private List<TelefoneDtoIn> telefones;
}
