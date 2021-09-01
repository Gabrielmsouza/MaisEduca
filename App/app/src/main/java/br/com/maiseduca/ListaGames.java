package br.com.maiseduca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

import br.com.maiseduca.game.JogoRotinas;
import pl.droidsonroids.gif.GifImageView;

public class ListaGames extends AppCompatActivity {
    private Switch ordenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configuraView();
        inicializa();
    }

    private void configuraView(){
        getSupportActionBar().hide(); //Remove a Toolbar
        setContentView(R.layout.activity_lista_games);
    }

    private void inicializa() {
        ordenado = findViewById(R.id.activity_lista_games_ordenacao);
        botaoAbc();
        botaoNumeros();
        botaoCores();
        botaoFormas();
        botaoRotinas();
        botaoEmocoes();
    }

    private void botaoEmocoes() {
        GifImageView botaoEmocoes = findViewById(R.id.activity_lista_games_botao_emocao);
        botaoEmocoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("EMOCOES");
            }
        });

    }

    private void botaoRotinas() {
        GifImageView botaoRotinas = findViewById(R.id.activity_lista_games_botao_rotinas);
        botaoRotinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("ROTINAS");
            }
        });
    }

    private void botaoAbc() {
        GifImageView botaoAbc = findViewById(R.id.activity_lista_games_botao_abc);
        botaoAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("ABC");
            }
        });
    }

    private void botaoNumeros() {
        GifImageView botaoNumeros = findViewById(R.id.activity_lista_games_botao_numeros);
        botaoNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("123");

            }
        });
    }

    private void botaoCores() {
        GifImageView botaoCores = findViewById(R.id.activity_lista_games_botao_cores);
        botaoCores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("CORES");
            }
        });
    }

    private void botaoFormas() {
        GifImageView botaoFormas = findViewById(R.id.activity_lista_games_botao_formas);
        botaoFormas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirJogo("FORMAS");
            }
        });
    }

    private void abrirJogo(String jogo){
        Intent intent = new Intent(ListaGames.this, JogoRotinas.class);;
        //if (jogo.equals("ROTINAS") || jogo.equals("EMOCOES") || jogo.equals("ABC")) intent = new Intent(ListaGames.this, JogoRotinas.class);
        //else intent = new Intent(ListaGames.this, JogoView.class);

        intent.putExtra("Jogo",jogo);
        intent.putExtra("Ordenado",ordenado.isChecked());
        startActivity(intent);
    }
}
