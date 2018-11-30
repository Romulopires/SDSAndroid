package br.com.rafaelleme.senai.sdsandroid.service;

import java.util.List;

import br.com.rafaelleme.senai.sdsandroid.entities.ClasseGenerica;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseTurma;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TurmaService {

    @GET("turma/todos")
    Call<List<ClasseGenerica>> getTurmaNome();
}
