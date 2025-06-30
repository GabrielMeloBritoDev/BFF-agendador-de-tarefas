package com.Swagger.BFF.controller;


import com.Swagger.BFF.business.Dto.in.EnderecoDtoIn;
import com.Swagger.BFF.business.Dto.in.Login_In;
import com.Swagger.BFF.business.Dto.in.TelefoneDtoIn;
import com.Swagger.BFF.business.Dto.in.UsuarioDtoIn;
import com.Swagger.BFF.business.Dto.out.UsuarioDtoOut;
import com.Swagger.BFF.business.UsuarioSevice;
import com.Swagger.BFF.infrastructure.Config.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Cadastro e login de usuario ")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME )
public class usuarioController {


    private final UsuarioSevice usuarioService;


    //Cadastro de usuario feito!
    @PostMapping
    @Operation(summary = "Salvar usuario", description = "Cria um novo usuário")

    public ResponseEntity<UsuarioDtoIn> salvaUsuario(@RequestBody UsuarioDtoIn usuarioDto){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDto));
    }
    //Cadastro de login
    @PostMapping("/login")
    @Operation(summary = "Login usuario", description = "Login do usuário")
    public String login(@RequestBody Login_In usuarioDto){
     return usuarioService.loginUsuario(usuarioDto);
    }


    //Buscar usuario por email
    @GetMapping
    @Operation(summary = "Buscar dados do usuario", description = "Buscar dados do usuário")
    public ResponseEntity<UsuarioDtoIn>  buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                               @RequestHeader("Authorization")String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    //Deletar usuario por email
    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuario", description = "Apaga o usuário")
    public ResponseEntity<Void> deleteUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader("Authorization")String token){
        usuarioService.deletaUsuarioPorEmail(email,token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados do usuario", description = "atualizar dados do usuário")
    public ResponseEntity<UsuarioDtoIn> atualizarDadosUsuario(@RequestBody UsuarioDtoIn dto,
                                                              @RequestHeader("Authorization")String token){

        return   ResponseEntity.ok(usuarioService.atualizarDadosUsuario(token,dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço do usuario", description = "Atulalizar endereço do usuário")
    public ResponseEntity<EnderecoDtoIn> atualizaEndereco(@RequestBody EnderecoDtoIn enderecoDto,
                                                          @RequestParam("id") Long id,
                                                          @RequestHeader("Authorization")String token){
        return   ResponseEntity.ok(usuarioService.atualizaEndereco(enderecoDto,id, token));
    }


    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone do  usuario", description = "Atulizar telefone do usuário")
    public ResponseEntity<TelefoneDtoIn> atualizaTelefone(@RequestBody TelefoneDtoIn dto,
                                                          @RequestParam("id") Long id,
                                                          @RequestHeader("Authorization")String token){
        return   ResponseEntity.ok(usuarioService.atualizaTelefone(id,dto,token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Cadastra um novo endereço do  usuario", description = "Cadastra um novo endereço do usuário")
    public ResponseEntity<EnderecoDtoIn> cadastraEndereco(@RequestBody EnderecoDtoIn dto,
                                                          @RequestHeader(name

 = "Authorization", required = false) String token){
        return   ResponseEntity.ok(usuarioService.cadastraEndereco(token, dto));
    }
    @PostMapping("/telefone")
    @Operation(summary = "Cadastra um novo telefone do  usuario", description = "Cadastra um novo telefone do usuário")
    public ResponseEntity<TelefoneDtoIn> cadastraTelefone(@RequestBody TelefoneDtoIn dto,
                                                          @RequestHeader(name

 = "Authorization", required = false) String token){
        return   ResponseEntity.ok(usuarioService.cadastraTelefone(token,dto));
    }
}
