package br.com.maiseduca.utils;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import br.com.maiseduca.game.JogoRotinas;
import br.com.maiseduca.game.JogoView;

public class Utils {
    private static int clk = 0;

    public static boolean testClique(int ms) {

        Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                clk = 0;
            }
        };

        if (clk == 0) {
            clk = 1;
            handler.postDelayed(r, ms);
            return true;
        }
        handler.postDelayed(r, 1000);
        return false;
    }

    public static void playSound(final SoundPool sound, int musica, final Context context) {
        final int som = sound.load(context,musica,1);
        sound.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                int streamType = AudioManager.STREAM_MUSIC;
                AudioManager audioManager = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);
                float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);
                float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);
                float volume = currentVolumeIndex / maxVolumeIndex;
                //activity.setVolumeControlStream(streamType);

                sound.play(som,volume,volume,1,0,1);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
