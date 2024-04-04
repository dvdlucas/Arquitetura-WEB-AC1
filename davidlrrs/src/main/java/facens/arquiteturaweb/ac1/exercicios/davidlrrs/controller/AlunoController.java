package facens.arquiteturaweb.ac1.exercicios.davidlrrs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.services.AlunoService;
import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;



@RestController

@RequestMapping("/alunos")

public class AlunoController {
    
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return alunoService.getAllAlunos();
    }

    @PostMapping("/add")
    public Aluno createAluno(@RequestBody Aluno aluno){
        return alunoService.createAluno(aluno);
    }

    @GetMapping("/{ra}")
    public Aluno getAlunoByRA(@PathVariable Long ra){
        return alunoService.getAlunoByRA(ra);
    }

    @DeleteMapping("/delete/{ra}")
    public void deletarAluno(@PathVariable Long ra) {
         alunoService.removeAluno(ra);
    }

    @PutMapping("update/")
    public Aluno atualizarAluno(@RequestBody Aluno aluno) {
        return alunoService.updateAluno(aluno);
    }





}
