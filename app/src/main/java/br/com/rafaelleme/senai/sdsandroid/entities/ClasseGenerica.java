package br.com.rafaelleme.senai.sdsandroid.entities;

public class ClasseGenerica {

    private Integer id;
    private String nome;

    public ClasseGenerica() {

    }


    @Override
    public String toString() {
        return nome;
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
}
