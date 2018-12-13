package br.com.rafaelleme.senai.sdsandroid.entities;

public class Filtro {

    private Integer colaborador;
    private Integer dia_semana;
    private Integer periodo;
    private Integer turma;


    public Filtro() {
        // TODO Auto-generated constructor stub
    }

    public Filtro(Integer colaborador, Integer dia_semana, Integer periodo) {

    }

    public Integer getColaborador() {
        return colaborador;
    }
    public void setColaborador(Integer colaborador) {
        this.colaborador = colaborador;
    }
    public Integer getDia_semana() {
        return dia_semana;
    }
    public void setDia_semana(Integer dia_semana) {
        this.dia_semana = dia_semana;
    }
    public Integer getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
    public Integer getTurma() {
        return turma;
    }

    public void setTurma(Integer turma) {
        this.turma = turma;
    }


}
