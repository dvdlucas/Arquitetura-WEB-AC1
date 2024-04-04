package facens.arquiteturaweb.ac1.exercicios.davidlrrs.services;

import java.util.List;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;

public interface AlunoService {
    List<Aluno> getAllAlunos();
    Aluno getAlunoByRA(Long ra);
    Aluno createAluno(Aluno aluno);
    Aluno removeAluno(Long ra);
    Aluno updateAluno(Aluno aluno);
 }
