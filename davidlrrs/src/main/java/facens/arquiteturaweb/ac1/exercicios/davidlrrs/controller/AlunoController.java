package main.java.facens.arquiteturaweb.ac1.exercicios.davidlrrs.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;

import javax.annotation.Resource;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.SpringBootApplication;

@SpringBootApplication

@RestController

@RequestMapping("/alunos")

public class AlunoController {
    
    private List<Aluno> alunos = new ArrayList<>();
    private Long nextRa = 1L;

    @PostMapping("/add")
    public Aluno criarAluno(RequestBody Aluno aluno){
        aluno.setRa(nextRa++);
        alunos.add(aluno);
        return "Aluno adicionado com sucesso";
    }
    
    @GetMapping
    public List<Aluno>getAllAlunos(){
        return alunos;
    }

    @GetMapping("/{ra}")
    public Aluno getAlunoByRA(@PathVariable Long ra){
        return alunos.stream()
                .filter(aluno -> aluno.getRa().equals(ra))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("delete/{id}")
    public void deletarAluno(@PathVariable Long ra) {
        boolean removed = alunos.removeIf(aluno -> aluno.getRa().equals(ra));
        return removed ? "Aluno deletado" : "Aluno não encontrado";
    }

    @PutMapping("update/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            if (aluno.getRa().equals(ra)) {
                alunoAtualizado.setRa(aluno.getRa());
                alunos.set(i, alunoAtualizado);
                return alunoAtualizado;
            }
        }
        return null;
    }





}
