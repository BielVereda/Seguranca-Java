package com.segura.seguranca.servicos;

import com.segura.seguranca.DTOs.UsuarioRequisicaoDTO;
import com.segura.seguranca.entidades.Usuario;
import com.segura.seguranca.entidades.enums.Role;
import com.segura.seguranca.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServico(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder){
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(UsuarioRequisicaoDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setRole(Role.ROLE_USUARIO);
        return usuarioRepositorio.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}