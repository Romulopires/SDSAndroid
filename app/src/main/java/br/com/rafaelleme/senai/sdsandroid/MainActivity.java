package br.com.rafaelleme.senai.sdsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.sdsandroid.Util.RetrofitInstance;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseGenerica;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseTurma;
import br.com.rafaelleme.senai.sdsandroid.service.ProfessorService;
import br.com.rafaelleme.senai.sdsandroid.service.TurmaService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    Retrofit retrofit;


    @BindView(R.id.s1)
    TextView s1;

    @BindView(R.id.s2)
    TextView s2;


    @BindView(R.id.s3)
    TextView s3;


    @BindView(R.id.s4)
    TextView s4;


    @BindView(R.id.s5)
    TextView s5;


    @BindView(R.id.t1)
    TextView t1;

    @BindView(R.id.t2)
    TextView t2;


    @BindView(R.id.t3)
    TextView t3;


    @BindView(R.id.t4)
    TextView t4;


    @BindView(R.id.t5)
    TextView t5;


    @BindView(R.id.q1)
    TextView q1;

    @BindView(R.id.q2)
    TextView q2;


    @BindView(R.id.q3)
    TextView q3;


    @BindView(R.id.q4)
    TextView q4;


    @BindView(R.id.q5)
    TextView q5;


    @BindView(R.id.qi1)
    TextView qi1;

    @BindView(R.id.qi2)
    TextView qi2;


    @BindView(R.id.qi3)
    TextView qi3;


    @BindView(R.id.qi4)
    TextView qi4;


    @BindView(R.id.qi5)
    TextView qi5;


    @BindView(R.id.sx1)
    TextView sx1;

    @BindView(R.id.sx2)
    TextView sx2;

    @BindView(R.id.sx3)
    TextView sx3;

    @BindView(R.id.sx4)
    TextView sx4;

    @BindView(R.id.sx5)
    TextView sx5;

    @BindView(R.id.sa1)
    TextView sa1;

    @BindView(R.id.sa2)
    TextView sa2;

    @BindView(R.id.sa3)
    TextView sa3;

    @BindView(R.id.sa4)
    TextView sa4;

    @BindView(R.id.sa5)
    TextView sa5;












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = RetrofitInstance.getInstance();

        ButterKnife.bind(this);

        spinner = findViewById(R.id.spinnerTurma);
        spinner2 = findViewById(R.id.spinnerProfessor);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ClasseGenerica cg = (ClasseGenerica) spinner.getSelectedItem();
                Log.i("Teste", cg.getId().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ClasseTurma cg = (ClasseTurma) spinner.getSelectedItem();
                Log.i("Teste", cg.getId().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ProfessorService professorService = retrofit.create(ProfessorService.class);
        Call<List<ClasseGenerica>> buscaProfessor = professorService.getNomes();
        buscaProfessor.enqueue(new Callback<List<ClasseGenerica>>() {
            @Override
            public void onResponse(Call<List<ClasseGenerica>> call, Response<List<ClasseGenerica>> response) {
                if (response.isSuccessful()) {
                    List<ClasseGenerica> resposta = response.body();

                    List<String> lista = new ArrayList<>();
                    lista.add("Selecione");
                    for (ClasseGenerica c : resposta) {
                        lista.add(c.getNome());
                    }
                    ArrayAdapter<ClasseGenerica> adapter = new ArrayAdapter<ClasseGenerica>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, resposta.toArray(new ClasseGenerica[resposta.size()]));
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
                if (response.isSuccessful()) {
                    List<ClasseTurma> resposta = response.body();

                    List<String> lista = new ArrayList<>();
                    lista.add("Selecione");
                    for (ClasseTurma c : resposta) {
                        lista.add(c.getNome());
                    }
                    ArrayAdapter<ClasseTurma> adapter = new ArrayAdapter<ClasseTurma>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, resposta.toArray(new ClasseTurma[resposta.size()]));
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
