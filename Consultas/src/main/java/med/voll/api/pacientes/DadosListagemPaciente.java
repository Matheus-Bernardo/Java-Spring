/*
Método get(Controller) vai listar os parametros definidos nesta classe
 */

package med.voll.api.pacientes;

public record DadosListagemPaciente(Long id,String nome,String cpf,String email) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(),paciente.getCpf(),paciente.getEmail());
    }
}
