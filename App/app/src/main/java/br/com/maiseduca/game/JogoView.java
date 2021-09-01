package br.com.maiseduca.game;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import br.com.maiseduca.R;
import br.com.maiseduca.helper.Game123Helper;
import br.com.maiseduca.helper.GameABCHelper;
import br.com.maiseduca.helper.GameCoresHelper;
import br.com.maiseduca.helper.GameFormasHelper;
import br.com.maiseduca.helper.GameHelper;
import br.com.maiseduca.utils.Utils;

public class JogoView extends AppCompatActivity {
    private ImageView imagem;
    private Jogo jogo;
    private String jogoSelecionado;
    private GameHelper gameHelper;
    private SoundPool soundpool;
    private boolean ordenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Remove a Toolbar

        carregaGame();
        configuraTela();
        iniciaGame();
        funcaoBotao();
    }

    private void carregaGame(){
        jogoSelecionado = getIntent().getStringExtra("Jogo");
        ordenado = getIntent().getBooleanExtra("Ordenado",true);

        //if (jogoSelecionado.equals("ABC")) gameHelper = new GameABCHelper();
        //if (jogoSelecionado.equals("123")) gameHelper = new Game123Helper();
        //else if (jogoSelecionado.equals("FORMAS")) gameHelper = new GameFormasHelper();
        //else if (jogoSelecionado.equals("CORES")) gameHelper = new GameCoresHelper();
    }

    @SuppressLint("NewApi")
    private void iniciaGame() {
        configuraSomInicial();
        imagem = findViewById(R.id.activity_game_botao);

        jogo = gameHelper.pegaObjetos(ordenado);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), jogo.getImagem());
        imagem.setImageBitmap(bitmap);
    }

    private void configuraSomInicial(){
        if(Build.VERSION.SDK_INT >= 21){
            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setMaxStreams(3);
            soundpool = builder.build();
        } else {
            soundpool = new SoundPool(3,AudioManager.STREAM_MUSIC,0);
        }
    }

    private void configuraTela() {
        setContentView(R.layout.activity_game);
    }

    private void funcaoBotao() {
        imagem.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                if (Utils.testClique(1000)){
                    imagem.setClickable(false);
                    imagem.setEnabled(false);
                    playSound();

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    jogo = gameHelper.pegaObjetos(ordenado);
                    Bitmap bitmap = BitmapFactory.decodeResource(JogoView.this.getResources(), jogo.getImagem());
                    imagem.setImageBitmap(bitmap);
                    imagem.setClickable(true);
                    imagem.setEnabled(true);
                }
            }
        });
    }

    protected void playSound() {
        final int som = soundpool.load(this,jogo.getSom(),1);
        soundpool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                int streamType = AudioManager.STREAM_MUSIC;
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);
                float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);
                float volume = currentVolumeIndex / maxVolumeIndex;
                JogoView.this.setVolumeControlStream(streamType);

                soundpool.play(som,volume,volume,1,0,1);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
