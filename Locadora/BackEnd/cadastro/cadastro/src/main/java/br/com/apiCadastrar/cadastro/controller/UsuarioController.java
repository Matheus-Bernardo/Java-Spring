package br.com.apiCadastrar.cadastro.controller;

import br.com.apiCadastrar.cadastro.DAO.IUsuario;
import br.com.apiCadastrar.cadastro.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired // injeção automática
    private IUsuario dao;

    @GetMapping
    public List<Usuario> listaUsuarios(){

        return (List<Usuario>) dao.findAll();
    }
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
        return novoUsuario;
    }
    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
        return novoUsuario;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario>  excluirUsuario(@PathVariable Integer id){
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
    }

}
