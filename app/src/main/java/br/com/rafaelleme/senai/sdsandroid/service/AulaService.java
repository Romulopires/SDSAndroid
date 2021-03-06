package br.com.rafaelleme.senai.sdsandroid.service;

import br.com.rafaelleme.senai.sdsandroid.entities.Aula;
import br.com.rafaelleme.senai.sdsandroid.entities.Filtro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AulaService {

    @POST("aula/por-filtro")
    Call<Aula> buscaAula(@Body Filtro filtro);

    @POST("aula/por-turma")
    Call<Aula> buscaAulaTurma(@Body Filtro filtro);
}
