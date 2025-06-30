package com.Swagger.BFF.business;

import com.Swagger.BFF.business.Dto.in.EnderecoDtoIn;
import com.Swagger.BFF.business.Dto.in.Login_In;
import com.Swagger.BFF.business.Dto.in.TelefoneDtoIn;
import com.Swagger.BFF.business.Dto.in.UsuarioDtoIn;
import com.Swagger.BFF.infrastructure.client.UsuarioClient;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioSevice {

   private final UsuarioClient usuarioClient;

    public UsuarioDtoIn salvaUsuario(UsuarioDtoIn usuarioDto){

        return  usuarioClient.salvaUsuario(usuarioDto);
    }

    public String loginUsuario(Login_In usuarioDto){
        return  usuarioClient.login(usuarioDto);
    }



    public UsuarioDtoIn buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscarUsuarioPorEmail(email,token);
    }


    public void deletaUsuarioPorEmail(String email,String token){
         usuarioClient.deleteUsuarioPorEmail(email, token);
    }

    public UsuarioDtoIn atualizarDadosUsuario(String token , UsuarioDtoIn dto){
     return  usuarioClient.atualizarDadosUsuario(dto, token);

    }
    public EnderecoDtoIn atualizaEndereco(EnderecoDtoIn enderecoDto, Long id, String token){
        return usuarioClient.atualizaEndereco(enderecoDto, id ,token);
    }


    public TelefoneDtoIn atualizaTelefone (Long id, TelefoneDtoIn telefoneDto, String token){
        return  usuarioClient.atualizaTelefone( telefoneDto, id,token);

    }

    public EnderecoDtoIn cadastraEndereco(String token, EnderecoDtoIn enderecoDto){
       return usuarioClient.cadastraEndereco(enderecoDto,token);
    }


    public TelefoneDtoIn cadastraTelefone(String token, TelefoneDtoIn telefoneDto){
       return usuarioClient.cadastraTelefone(telefoneDto,token);
    }
}
