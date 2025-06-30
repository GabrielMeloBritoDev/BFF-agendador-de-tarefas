package com.Swagger.BFF.business.Dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDtoOut {


    private String rua;

    private Long numero;

    private String complemento;

    private String cidade;

    private String estado;

    private String cep;



}
