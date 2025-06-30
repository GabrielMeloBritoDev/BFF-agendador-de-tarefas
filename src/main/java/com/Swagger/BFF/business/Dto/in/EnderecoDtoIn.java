package com.Swagger.BFF.business.Dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDtoIn {


    private String rua;

    private Long numero;

    private String complemento;

    private String cidade;

    private String estado;

    private String cep;



}
