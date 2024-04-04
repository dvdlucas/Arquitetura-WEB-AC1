package facens.arquiteturaweb.ac1.exercicios.davidlrrs.repositories;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;
import java.util.List;

public interface AlunoRepository {
    List<Aluno> findAll();
    Aluno findByRa(Long ra);
    Aluno save(Aluno aluno);
    Aluno remove(Long ra);
    Aluno update(Aluno aluno);
}
