package facens.arquiteturaweb.ac1.exercicios.davidlrrs.services;

import java.util.List;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;
import facens.arquiteturaweb.ac1.exercicios.davidlrrs.repositories.AlunoRepository;

public class AlunoServiceImplement implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImplement(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoByRA(Long ra) {
        return alunoRepository.findByRa(ra);
    }

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno removeAluno(Long ra) {
        return alunoRepository.remove(ra);
    }

    @Override
    public Aluno updateAluno(Aluno aluno) {
        return alunoRepository.update(aluno);
    }
    
}
