package facens.arquiteturaweb.ac1.exercicios.davidlrrs.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Repository;
import facens.arquiteturaweb.ac1.exercicios.davidlrrs.model.Aluno;


@Repository
public class AlunoRepositoryImplem implements AlunoRepository{
    private final SessionFactory sessionFactory;

    
    public AlunoRepositoryImplem(){
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return (Session) sessionFactory.getCurrentSession();
    }

    @Override
    public List<Aluno> findAll() {
        Session session = getSession();
        Transaction transaction = ((SharedSessionContract) session).beginTransaction();
        List<Aluno> alunos = session.createQuery("FROM Alunos", Aluno.class).getResultList();
        transaction.commit();
        return alunos;
    }

    @Override
    public Aluno findByRa(Long ra) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Aluno aluno = session.find(Aluno.class, ra);
        transaction.commit();
        return aluno;
    }

    @Override
    public Aluno save(Aluno aluno) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(aluno);
        transaction.commit();
        return aluno;
    }

    
    @Override
    public Aluno remove(Long ra) {
        Aluno aluno = EntityManager.find(Aluno.class, ra);
        if (aluno != null) {
            EntityManager.remove(aluno);
        }
        return aluno;
    }

    @Override
    public Aluno update(Aluno aluno) {
        return EntityManager.merge(aluno);
    }

    


    
}
