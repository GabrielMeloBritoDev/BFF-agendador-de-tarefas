package com.Swagger.BFF.infrastructure.client;

import com.Swagger.BFF.business.Dto.in.EnderecoDtoIn;
import com.Swagger.BFF.business.Dto.in.Login_In;
import com.Swagger.BFF.business.Dto.in.TelefoneDtoIn;
import com.Swagger.BFF.business.Dto.in.UsuarioDtoIn;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(name = "usuario", url ="${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDtoIn buscarUsuarioPorEmail(@RequestParam("email") String email,
                                       @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDtoIn salvaUsuario(@RequestBody UsuarioDtoIn usuarioDto);

    //Cadastro de login
    @PostMapping("/login")
     String login(@RequestBody Login_In usuarioDto);


    //Deletar usuario por email
    @DeleteMapping("/{email}")
     void deleteUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization")String token);

    @PutMapping
    UsuarioDtoIn atualizarDadosUsuario(@RequestBody UsuarioDtoIn dto,
                                       @RequestHeader("Authorization")String token);

    @PutMapping("/endereco")
    EnderecoDtoIn atualizaEndereco(@RequestBody EnderecoDtoIn enderecoDto,
                                   @RequestParam("id") Long id,
                                   @RequestHeader("Authorization")String token);


    @PutMapping("/telefone")
    TelefoneDtoIn atualizaTelefone(@RequestBody TelefoneDtoIn dto,
                                   @RequestParam("id") Long id,
                                   @RequestHeader("Authorization")String token);

    @PostMapping("endereco")
    EnderecoDtoIn cadastraEndereco(@RequestBody EnderecoDtoIn dto,
                                   @RequestHeader("Authorization") String token);
    @PostMapping("/telefone")
    TelefoneDtoIn cadastraTelefone(@RequestBody TelefoneDtoIn dto,
                                   @RequestHeader("Authorization") String token);

}
