package br.com.rafaelleme.senai.sdsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.sdsandroid.Util.RetrofitInstance;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseGenerica;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseTurma;
import br.com.rafaelleme.senai.sdsandroid.service.ProfessorService;
import br.com.rafaelleme.senai.sdsandroid.service.TurmaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = RetrofitInstance.getInstance();

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner3);

        ProfessorService professorService = retrofit.create(ProfessorService.class);
        Call<List<ClasseGenerica>> buscaProfessor = professorService.getNomes();
        buscaProfessor.enqueue(new Callback<List<ClasseGenerica>>() {
            @Override
            public void onResponse(Call<List<ClasseGenerica>> call, Response<List<ClasseGenerica>> response) {
                if (response.isSuccessful()){
                    List<ClasseGenerica> resposta = response.body();

                    List<String> lista = new ArrayList<>();
                    for (ClasseGenerica c : resposta){
                        lista.add(c.getNome());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, lista);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                    spinner.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<ClasseGenerica>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });


        TurmaService turmaService = retrofit.create(TurmaService.class);
        Call<List<ClasseTurma>> buscaTurma = turmaService.getTurmaNome();
        buscaTurma.enqueue(new Callback<List<ClasseTurma>>() {
            @Override
            public void onResponse(Call<List<ClasseTurma>> call, Response<List<ClasseTurma>> response) {
                if (response.isSuccessful()){
                    List<ClasseTurma> resposta = response.body();

                    List<String> lista = new ArrayList<>();
                    for (ClasseTurma c : resposta){
                        lista.add(c.getNome());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, lista);
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                    spinner2.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<ClasseTurma>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
