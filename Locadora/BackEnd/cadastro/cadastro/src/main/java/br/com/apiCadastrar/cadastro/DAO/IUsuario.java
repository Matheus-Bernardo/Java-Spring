package br.com.apiCadastrar.cadastro.DAO;

import br.com.apiCadastrar.cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends JpaRepository<Usuario,Integer> {
}
