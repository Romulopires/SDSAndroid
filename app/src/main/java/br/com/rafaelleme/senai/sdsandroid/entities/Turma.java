package br.com.rafaelleme.senai.sdsandroid.entities;

public class Turma {
    private Integer id;
    private String nome;
    private Integer qtd_alunos;
    private Integer divisao;
    private Integer periodo;
    private Integer semestre;
    private Integer id_curso;



    public Turma() {
        // TODO Auto-generated constructor stub
    }

    public Turma(Integer id, String nome, Integer qtd_alunos, Integer divisao, Integer periodo, Integer semestre,
                 Integer id_curso) {
        super();
        this.id = id;
        this.nome = nome;
        this.qtd_alunos = qtd_alunos;
        this.divisao = divisao;
        this.periodo = periodo;
        this.semestre = semestre;
        this.id_curso = id_curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(Integer qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public Integer getDivisao() {
        return divisao;
    }

    public String getFormatDivisao() {
        if(divisao == 1) {
            return "Sim";
        }else {
            return "Não";
        }
    }

    public void setDivisao(Integer divisao) {
        this.divisao = divisao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public String getFormatPeriodo() {
        if(periodo == 1) {
            return "Manha";
        }else if(periodo == 2) {
            return "Tarde";
        }else {
            return "Noite";
        }
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

}
