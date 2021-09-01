package br.com.maiseduca.helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class GameRotinas extends GamePassaVoltaHelper{
    private int QUANTIDADE_DE_ROTINAS;
    private List<Jogo> listaRotinas;
    private int posicaoAtual = 0;

    public GameRotinas(){
        listaRotinas = new ArrayList<>();
        criaObjetos();
        QUANTIDADE_DE_ROTINAS = (listaRotinas.size() -1);
    }

    void criaObjetos() {
        listaRotinas.add(new Jogo(R.drawable.rotina_brincar_com_os_brinquedos,R.raw.brinquedos));
        listaRotinas.add(new Jogo(R.drawable.rotina_brincar_com_papel,R.raw.atividades));
        listaRotinas.add(new Jogo(R.drawable.rotina_brincar_na_areia,R.raw.areia));
        listaRotinas.add(new Jogo(R.drawable.rotina_brincar_no_parque,R.raw.parque));
        listaRotinas.add(new Jogo(R.drawable.rotina_dormir,R.raw.sono));
        listaRotinas.add(new Jogo(R.drawable.rotina_escovar_os_dentes,R.raw.dentes));
        listaRotinas.add(new Jogo(R.drawable.rotina_estou_com_fome,R.raw.fome));
        listaRotinas.add(new Jogo(R.drawable.rotina_fazer_coco,R.raw.coco));
        listaRotinas.add(new Jogo(R.drawable.rotina_fazer_xixi,R.raw.xixi));
        listaRotinas.add(new Jogo(R.drawable.rotina_ouvir_historias,R.raw.historinha));
        listaRotinas.add(new Jogo(R.drawable.rotina_passear,R.raw.passear));
        listaRotinas.add(new Jogo(R.drawable.rotina_tomar_banho,R.raw.banho));
        listaRotinas.add(new Jogo(R.drawable.rotina_ver_tv,R.raw.desenho));
    }

    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE_DE_ROTINAS) posicaoAtual = 0;
        return listaRotinas.get(posicaoAtual);
    }

    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE_DE_ROTINAS;
        return listaRotinas.get(posicaoAtual);
    }
}
