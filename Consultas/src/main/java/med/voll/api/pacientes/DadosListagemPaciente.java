/*
Método get(Controller) vai listar os parametros definidos nesta classe
 */

package med.voll.api.pacientes;

public record DadosListagemPaciente(String nome,String cpf,String email) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(),paciente.getCpf(),paciente.getEmail());
    }
}
