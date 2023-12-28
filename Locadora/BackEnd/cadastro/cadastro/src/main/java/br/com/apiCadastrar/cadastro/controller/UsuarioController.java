package br.com.apiCadastrar.cadastro.controller;

import br.com.apiCadastrar.cadastro.DAO.IUsuario;
import br.com.apiCadastrar.cadastro.Service.UsuarioService;
import br.com.apiCadastrar.cadastro.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{

    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }
    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  excluirUsuario(@PathVariable Integer id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@Valid @RequestBody Usuario usuario){
        Boolean valid = usuarioService.validarSenha(usuario);
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }

}
