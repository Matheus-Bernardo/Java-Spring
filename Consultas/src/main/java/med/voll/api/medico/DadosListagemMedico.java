/*

Classe responsável por criar filtros do que retornar nas requisições get,recomendavél por questões de segurança
 */


package med.voll.api.medico;

public record DadosListagemMedico(Long id,String nome,String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
