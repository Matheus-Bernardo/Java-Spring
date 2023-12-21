package br.com.apiCadastrar.cadastro.controller;

import br.com.apiCadastrar.cadastro.DAO.IUsuario;
import br.com.apiCadastrar.cadastro.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired // injeção automática
    private IUsuario dao;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        List<Usuario> lista = dao.findAll();
        return ResponseEntity.status(200).body(lista);
    }
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }
    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = dao.save(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  excluirUsuario(@PathVariable Integer id){
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
