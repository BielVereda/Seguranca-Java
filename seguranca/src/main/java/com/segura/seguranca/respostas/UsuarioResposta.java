package com.segura.seguranca.respostas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResposta {
    private long id;
    private String nome;
    private String email;
}
