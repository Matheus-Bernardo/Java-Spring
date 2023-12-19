package br.com.apiCadastrar.cadastro.DAO;

import br.com.apiCadastrar.cadastro.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario,Integer> {
}
