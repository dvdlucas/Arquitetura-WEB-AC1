package main.java.facens.arquiteturaweb.ac1.exercicios.davidlrrs.model;


public class Aluno {
    private String nome;
    private Long ra;
    private String curso;
    private String periodo;
    private Integer idade;


public Aluno(String nome, Long ra, String curso, String periodo, Integer idade){
        this.nome = nome;
        this.ra = ra;
        this.curso = curso;
        this.periodo = periodo;
        this.idade = idade;
}

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Long getRa(){
        return ra;
    }

    public void setRa(Long ra){
        this.ra = ra;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getPeriodo(){
        return periodo;
    }

    public void setPeriodo(String periodo){
        this.periodo = periodo;
    }

    public Integer getIdade(){
        return idade;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public void update(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


}