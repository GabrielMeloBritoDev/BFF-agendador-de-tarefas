package com.Swagger.BFF.business.Dto.in;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login_In {
    private String email;
    private String senha;
}
