package br.com.maiseduca.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class GameCoresHelper extends GamePassaVoltaHelper{
    private List<Jogo> listaCores;
    private int sequencia;
    private Jogo corAtual;
    private int QUANTIDADE;
    private int posicaoAtual = 0;

    public GameCoresHelper(){
        listaCores = new ArrayList<>();
        criaObjetos();
        QUANTIDADE = (listaCores.size() -1);
    }

    void criaObjetos() {
        Jogo vermelho = new Jogo(R.drawable.vermelho,R.raw.vermelho);
        Jogo verde = new Jogo(R.drawable.verde,R.raw.verde);
        Jogo preto = new Jogo(R.drawable.preto,R.raw.preto);
        Jogo amarelo = new Jogo(R.drawable.amarelo,R.raw.amarelo);
        Jogo azul = new Jogo(R.drawable.azul,R.raw.azul);
        Jogo branco = new Jogo(R.drawable.branco,R.raw.branco);
        Jogo laranja = new Jogo(R.drawable.laranja,R.raw.laranja);
        Jogo roxo = new Jogo(R.drawable.roxo,R.raw.roxo);

        corAtual = vermelho;

        listaCores.add(vermelho);
        listaCores.add(verde);
        listaCores.add(preto);
        listaCores.add(amarelo);
        listaCores.add(azul);
        listaCores.add(branco);
        listaCores.add(laranja);
        listaCores.add(roxo);
    }

    @Override
    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE) posicaoAtual = 0;
        return listaCores.get(posicaoAtual);
    }

    @Override
    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE;
        return listaCores.get(posicaoAtual);
    }

//    @Override
//    public Jogo pegaObjetos(boolean ordenado){
//        if (ordenado){
//            if (sequencia >= listaCores.size()) sequencia = 0;
//            int i = sequencia;
//            sequencia ++;
//            corAtual = listaCores.get(i);
//        } else {
//            while (corAtual == listaCores.get(0)) {
//                Collections.shuffle(listaCores);
//            }
//
//            corAtual = listaCores.get(0);
//        }
//        return corAtual;
//    }
}
