package br.com.apiCadastrar.cadastro.controller;

import br.com.apiCadastrar.cadastro.DAO.IUsuario;
import br.com.apiCadastrar.cadastro.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController{

    @Autowired // injeção automática
    private IUsuario dao;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){

        return (List<Usuario>) dao.findAll();
    }
}
