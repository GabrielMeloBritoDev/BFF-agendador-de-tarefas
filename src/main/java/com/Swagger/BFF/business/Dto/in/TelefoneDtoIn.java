package com.Swagger.BFF.business.Dto.in;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class TelefoneDtoIn {

    private String numero;

    private String ddd;
}

