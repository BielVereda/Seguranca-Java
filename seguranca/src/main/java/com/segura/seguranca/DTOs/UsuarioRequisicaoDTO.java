package com.segura.seguranca.DTOs;

import lombok.Data;

@Data
public class UsuarioRequisicaoDTO {
    private String nome;
    private String email;
    private String senha;
}