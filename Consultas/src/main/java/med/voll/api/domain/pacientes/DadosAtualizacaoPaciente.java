package med.voll.api.domain.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull Long id,
        String telefone,
        String nome,
        String email,
        DadosEndereco endereco) {
}
