package facens.arquiteturaweb.ac1.exercicios.davidlrrs.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;

import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;


@Repository
public class AlunoRepositoryImplem implements AlunoRepository{
    private final JdbcTemplate jdbcTemplate;
    

    public AlunoRepositoryImplem(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aluno> findAll() {
        return jdbcTemplate.query("SELECT * FROM aluno",(resultSet, rowNum) ->{
            System.out.println("Numero da linha "+ rowNum);
            return new Aluno(
                resultSet.getLong("ra"),
                resultSet.getString("nome"),
                resultSet.getString("curso"),
                resultSet.getString("periodo"),
                resultSet.getLong("idade")
            );
        });
    }

    @Override
    public Aluno findByRa(Long ra) {
        String query = "SELECT * FROM aluno WHERE ra = ?";
       
        return jdbcTemplate.queryForObject(query, new Object[]{ra}, (resultSet, rowNum) ->
            new Aluno(
                resultSet.getLong("ra"),
                resultSet.getString("nome"),
                resultSet.getString("curso"),
                resultSet.getString("periodo"),
                resultSet.getLong("idade")
        ));
    }

    @Override
    public Aluno save(Aluno aluno) {
        if (aluno.getRa() != null) {
            String insertQuery = "INSERT INTO public.aluno (ra, nome, curso, periodo, idade) VALUES (?, ?, ?)";
            
            jdbcTemplate.update(insertQuery, aluno.getRa(), aluno.getNome(), aluno.getCurso(), aluno.getPeriodo(), aluno.getIdade());
        } else {
            alunos.removeIf(a -> a.getRa().equals(aluno.getRa()));
            alunos.add(aluno);
            String updateQuery = "UPDATE public.aluno SET nome = ?, curso = ?, periodo = ?, idade = ?, WHERE ra = ?";
            jdbcTemplate.update(updateQuery, aluno.getNome(), aluno.getCurso(), aluno.getPeriodo(), aluno.getIdade());
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
