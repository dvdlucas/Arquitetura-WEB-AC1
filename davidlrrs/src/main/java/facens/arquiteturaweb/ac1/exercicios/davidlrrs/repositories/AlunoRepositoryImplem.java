package facens.arquiteturaweb.ac1.exercicios.davidlrrs.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Repository;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;


@Repository
public class AlunoRepositoryImplem implements AlunoRepository{
    private final List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public List<Aluno> findAll() {
        return alunos;
    }
    @Override
    public Aluno findByRa(Long ra) {
        return alunos.stream()
            .filter(aluno -> aluno.getRa().equals(ra))
            .findFirst()
            .orElse(null);
    }
    @Override
    public Aluno save(Aluno aluno) {
        if(aluno.getRa() == null){
            aluno.setRa(nextId);
            alunos.add(aluno);
        } else {
            alunos.removeIf(a -> a.getRa().equals(aluno.getRa()));
            alunos.add(aluno);
        }
        return aluno;
    }
    @Override
    public Aluno remove(Long ra) {
        Iterator<Aluno> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getRa().equals(ra)) {
                iterator.remove();
                return aluno;
            }
        }
        return null; 
    }

    @Override
    public Aluno update(Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getRa().equals(aluno.getRa())) {
                alunos.set(i, aluno);
                return aluno;
            }
        }
        return null;
    }

    


    
}
