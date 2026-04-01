package com.segura.seguranca.controladores;

import com.segura.seguranca.DTOs.UsuarioRequisicaoDTO;
import com.segura.seguranca.entidades.Usuario;
import com.segura.seguranca.respostas.UsuarioResposta;
import com.segura.seguranca.servicos.UsuarioServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;

    public UsuarioControlador(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    @PostMapping
    public ResponseEntity<UsuarioResposta> criarUsuario(@RequestBody UsuarioRequisicaoDTO dto) {
        Usuario usuario = usuarioServico.criarUsuario(dto);

        UsuarioResposta resposta = new UsuarioResposta(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResposta>> listarUsuarios() {
        List<Usuario> usuarios = usuarioServico.listarUsuarios();

        List<UsuarioResposta> respostas = usuarios.stream()
                .map(u -> new UsuarioResposta(u.getId(), u.getNome(), u.getEmail()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResposta> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioServico.buscarPorId(id);

        UsuarioResposta resposta = new UsuarioResposta(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );

        return ResponseEntity.ok(resposta);
    }
}
