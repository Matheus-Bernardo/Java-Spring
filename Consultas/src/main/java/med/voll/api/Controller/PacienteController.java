package med.voll.api.Controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.pacientes.DadosCadastroPaciente;
import med.voll.api.pacientes.DadosListagemPaciente;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));

    }
    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(sort = {"nome"})Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
