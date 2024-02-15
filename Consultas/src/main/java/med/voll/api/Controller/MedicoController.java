package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid  DadosCadastroMedico dados){//Padrão DTO
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao/*faz paginas do retorno em ordem alfabetica pelo nome*/){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);//converte a Lista de médicos para uma List definada no DTO
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")//parametro dinamico
    @Transactional
    /*
    @pathVariable atribui o id passado como parametro na url na variavel da função excluir
     */
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

    }
}
