package com.segura.seguranca.entidades;

import com.segura.seguranca.entidades.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    //@Column(unique = true)
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Role role;
}