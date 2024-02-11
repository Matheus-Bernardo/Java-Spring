/*
Classe recebe herança do Jpa- que é responsável por fazer manipulaçoes Sql
 */

package med.voll.api.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
