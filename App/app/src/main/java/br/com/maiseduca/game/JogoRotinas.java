package br.com.maiseduca.game;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.maiseduca.R;
import br.com.maiseduca.helper.Game123Helper;
import br.com.maiseduca.helper.GameABCHelper;
import br.com.maiseduca.helper.GameCoresHelper;
import br.com.maiseduca.helper.GameEmocoes;
import br.com.maiseduca.helper.GameFormasHelper;
import br.com.maiseduca.helper.GamePassaVoltaHelper;
import br.com.maiseduca.helper.GameRotinas;
import br.com.maiseduca.utils.Utils;

public class JogoRotinas extends AppCompatActivity {

    private GamePassaVoltaHelper helper;
    private ImageView botaoPraFrente;
    private ImageView botaoPraTras;
    private ImageView imagem;
    private Jogo rotina;
    private SoundPool soundpool;
    private String jogoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game_rotinas);
        jogoSelecionado = getIntent().getStringExtra("Jogo");

        if (jogoSelecionado.equals("ROTINAS")) helper = new GameRotinas();
        else if (jogoSelecionado.equals("EMOCOES")) helper = new GameEmocoes();
        else if (jogoSelecionado.equals("ABC")) helper = new GameABCHelper();
        else if (jogoSelecionado.equals("123")) helper = new Game123Helper();
        else if (jogoSelecionado.equals("FORMAS")) helper = new GameFormasHelper();
        else if (jogoSelecionado.equals("CORES")) helper = new GameCoresHelper();

        iniciaComponenter();
        comecaJogo();
        configuraSomInicial();
        botaoPraFrente();
        botaoPraTras();
        funcaoBotao();
    }

    private void configuraSomInicial(){
        if(Build.VERSION.SDK_INT >= 21){
            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setMaxStreams(3);
            soundpool = builder.build();
        } else {
            soundpool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        }
    }

    private void funcaoBotao() {
        imagem.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                if (Utils.testClique(1000)){
                    imagem.setClickable(false);
                    playSound();
                    imagem.setClickable(true);
                }
            }
        });
    }

    protected void playSound() {
        JogoRotinas.this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Utils.playSound(soundpool, rotina.getSom(), this);
    }

    private void botaoPraTras() {
        botaoPraTras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                praTras();
            }
        });
    }

    private void botaoPraFrente() {
        botaoPraFrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                praFrente();
            }
        });
    }

    private void iniciaComponenter() {
        botaoPraFrente = findViewById(R.id.activity_game_rotinas_botao_pra_frente);
        botaoPraTras = findViewById(R.id.activity_game_rotinas_botao_pra_tras);
        imagem = findViewById(R.id.activity_game_rotinas_imagem);
    }

    private void comecaJogo() {
        praFrente();
        praTras();
    }

    private void praTras() {
        rotina = helper.pegaAnterior();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), rotina.getImagem());
        imagem.setImageBitmap(bitmap);
    }

    private void praFrente() {
        rotina = helper.pegaProximo();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), rotina.getImagem());
        imagem.setImageBitmap(bitmap);
    }

}
