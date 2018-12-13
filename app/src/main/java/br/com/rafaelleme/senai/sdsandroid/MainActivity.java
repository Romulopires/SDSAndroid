package br.com.rafaelleme.senai.sdsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.sdsandroid.Util.RetrofitInstance;
import br.com.rafaelleme.senai.sdsandroid.Util.Utils;
import br.com.rafaelleme.senai.sdsandroid.entities.Aula;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseGenerica;
import br.com.rafaelleme.senai.sdsandroid.entities.ClasseTurma;
import br.com.rafaelleme.senai.sdsandroid.entities.Filtro;
import br.com.rafaelleme.senai.sdsandroid.service.AulaService;
import br.com.rafaelleme.senai.sdsandroid.service.ProfessorService;
import br.com.rafaelleme.senai.sdsandroid.service.TurmaService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerTurma;
    Spinner spinnerProf;
    Retrofit retrofit;

    @BindView(R.id.tableLayout)
    TableLayout tb;

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

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @BindView(R.id.rdManha)
    RadioButton rdmanha;

    @BindView(R.id.rdTarde)
    RadioButton rdTarde;

    @BindView(R.id.rdNoite)
    RadioButton rdNoite;


    Integer periodo;
    Boolean professor, turma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = RetrofitInstance.getInstance();

        ButterKnife.bind(this);

        spinnerTurma = findViewById(R.id.spinnerTurma);
        spinnerTurma.setEnabled(false);

        spinnerProf = findViewById(R.id.spinnerProfessor);
        spinnerProf.setEnabled(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                spinnerTurma.setEnabled(true);
                spinnerProf.setEnabled(true);

                switch (checkedId) {
                    case R.id.rdManha:
                        periodo = 1;
                        spinnerTurma.setSelection(0);
                        spinnerProf.setSelection(0);
                        break;

                    case R.id.rdTarde:
                        periodo = 2;
                        spinnerTurma.setSelection(0);
                        spinnerProf.setSelection(0);
                        break;

                    case R.id.rdNoite:
                        periodo = 3;
                        spinnerTurma.setSelection(0);
                        spinnerProf.setSelection(0);
                        break;
                }
            }
        });

        spinnerTurma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                limpar(tb);
                spinnerProf.setEnabled(false);
                if(periodo != null && id != 0){

                }else if(periodo != null){
                    spinnerProf.setEnabled(true);
                }

                //ClasseGenerica cg = (ClasseGenerica) spinnerTurma.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                limpar(tb);
                spinnerTurma.setEnabled(false);

                if (periodo != null && id != 0) {
                    Filtro filtro = new Filtro();
                    filtro.setPeriodo(periodo);
                    filtro.setDia_semana(1);
                    filtro.setColaborador((int) id);
                    pegarAula(filtro, s1);
                    pegarAula(filtro, s2);
                    pegarAula(filtro, s3);
                    pegarAula(filtro, s4);
                    pegarAula(filtro, s5);

                    filtro.setDia_semana(2);
                    pegarAula(filtro, t1);
                    pegarAula(filtro, t2);
                    pegarAula(filtro, t3);
                    pegarAula(filtro, t4);
                    pegarAula(filtro, t5);

                    filtro.setDia_semana(3);
                    pegarAula(filtro, q1);
                    pegarAula(filtro, q2);
                    pegarAula(filtro, q3);
                    pegarAula(filtro, q4);
                    pegarAula(filtro, q5);

                    filtro.setDia_semana(4);
                    pegarAula(filtro, qi1);
                    pegarAula(filtro, qi2);
                    pegarAula(filtro, qi3);
                    pegarAula(filtro, qi4);
                    pegarAula(filtro, qi5);

                    filtro.setDia_semana(5);
                    pegarAula(filtro, sx1);
                    pegarAula(filtro, sx2);
                    pegarAula(filtro, sx3);
                    pegarAula(filtro, sx4);
                    pegarAula(filtro, sx5);

                    filtro.setDia_semana(6);
                    pegarAula(filtro, sa1);
                    pegarAula(filtro, sa2);
                    pegarAula(filtro, sa3);
                    pegarAula(filtro, sa4);
                    pegarAula(filtro, sa5);
                }else if(periodo != null){
                    spinnerTurma.setEnabled(true);
                }
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
                    resposta.add(0, new ClasseGenerica(0, "Selecione"));

                    ArrayAdapter<ClasseGenerica> adapter = new ArrayAdapter<ClasseGenerica>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, resposta.toArray(new ClasseGenerica[resposta.size()]));
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                    spinnerProf.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<ClasseGenerica>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });


        TurmaService turmaService = retrofit.create(TurmaService.class);
        Call<List<ClasseGenerica>> buscaTurma = turmaService.getTurmaNome();
        buscaTurma.enqueue(new Callback<List<ClasseGenerica>>() {
            @Override
            public void onResponse(Call<List<ClasseGenerica>> call, Response<List<ClasseGenerica>> response) {
                if (response.isSuccessful()) {
                    List<ClasseGenerica> resposta = response.body();
                    resposta.add(0, new ClasseGenerica(0, "Selecione"));

                    List<String> lista = new ArrayList<>();
                    lista.add("Selecione");
                    for (ClasseGenerica c : resposta) {
                        lista.add(c.getNome());
                    }
                    ArrayAdapter<ClasseGenerica> adapter = new ArrayAdapter<ClasseGenerica>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, resposta.toArray(new ClasseGenerica[resposta.size()]));
                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                    spinnerTurma.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<ClasseGenerica>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void pegarAula(Filtro filtro, final TextView textView) {
        ClasseGenerica cg = (ClasseGenerica) spinnerProf.getSelectedItem();
        Log.i("Teste", cg.getId().toString());

        AulaService aulaService = RetrofitInstance.getInstance().create(AulaService.class);

        Call<Aula> pegaAula = aulaService.buscaAula(filtro);

        pegaAula.enqueue(new Callback<Aula>() {
            @Override
            public void onResponse(Call<Aula> call, Response<Aula> response) {
                if (response.isSuccessful()) {
                    Aula a = response.body();

                    if (a != null) {
                        textView.setText(Utils.abrevia(a.getNomeDisciplina())+ " \n Sala " + a.getId_sala()
                            + " \n " + a.getNomeTurma().toUpperCase());
                    }
                } else {
                    mens("Não conectamos ao serviço, tente novamente !");
                }
            }

            @Override
            public void onFailure(Call<Aula> call, Throwable t) {
                mens(t.toString());
            }
        });
    }

    private void mens(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void limpar(ViewGroup tb) {

        int count = tb.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = tb.getChildAt(i);
            if (view instanceof ViewGroup) {
                limpar((ViewGroup) view);
                continue;
            }
            if (view instanceof TextView) {
                if (!(((TextView) view).getTag() != null && ((TextView) view).getTag().equals("h1"))) {
                    ((TextView) view).setText("");
                    continue;
                }
            }
        }
    }

   /* public boolean preenchido(){
        if (rdmanha != null || rdTarde != null || rdNoite != null){
            spinnerProf.setEnabled(true);
            spinnerTurma.setEnabled(true);
            return true;
        }
        else {
            return false;
        }
    } */
}
