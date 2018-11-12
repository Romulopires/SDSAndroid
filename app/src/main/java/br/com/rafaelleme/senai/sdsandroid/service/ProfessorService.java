package br.com.rafaelleme.senai.sdsandroid.service;

import java.util.List;

import br.com.rafaelleme.senai.sdsandroid.entities.ClasseGenerica;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfessorService {

    @GET("professor/todos")
    Call<List<ClasseGenerica>> getNomes();
}
