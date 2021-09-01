package br.com.maiseduca.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class Game123Helper extends GamePassaVoltaHelper{
    private List<Jogo> listaNumeros;
    private int sequencia;
    private Jogo numeroAtual;
    private int QUANTIDADE;
    private int posicaoAtual = 0;

    public Game123Helper(){
        listaNumeros = new ArrayList<>();
        criaObjetos();
        QUANTIDADE = (listaNumeros.size() -1);
    }

    void criaObjetos() {
        Jogo num0 = new Jogo(R.drawable.numero_zero,R.raw.zero);
        Jogo num1 = new Jogo(R.drawable.numero_um,R.raw.um);
        Jogo num2 = new Jogo(R.drawable.numero_dois,R.raw.dois);
        Jogo num3 = new Jogo(R.drawable.numero_tres,R.raw.tres);
        Jogo num4 = new Jogo(R.drawable.numero_quatro,R.raw.quatro);
        Jogo num5 = new Jogo(R.drawable.numero_cinco,R.raw.cinco);
        Jogo num6 = new Jogo(R.drawable.numero_seis,R.raw.seis);
        Jogo num7 = new Jogo(R.drawable.numero_sete,R.raw.sete);
        Jogo num8 = new Jogo(R.drawable.numero_oito,R.raw.oito);
        Jogo num9 = new Jogo(R.drawable.numero_nove,R.raw.nove);
        numeroAtual = num0;

        listaNumeros.add(num0);
        listaNumeros.add(num1);
        listaNumeros.add(num2);
        listaNumeros.add(num3);
        listaNumeros.add(num4);
        listaNumeros.add(num5);
        listaNumeros.add(num6);
        listaNumeros.add(num7);
        listaNumeros.add(num8);
        listaNumeros.add(num9);
    }

    @Override
    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE) posicaoAtual = 0;
        return listaNumeros.get(posicaoAtual);
    }

    @Override
    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE;
        return listaNumeros.get(posicaoAtual);
    }

//    public Jogo pegaObjetos(boolean ordenado){
//        if (ordenado){
//            if (sequencia >= listaNumeros.size()) sequencia = 0;
//            int i = sequencia;
//            sequencia ++;
//            numeroAtual = listaNumeros.get(i);
//        } else {
//            while (numeroAtual == listaNumeros.get(0)) {
//                Collections.shuffle(listaNumeros);
//            }
//
//            numeroAtual = listaNumeros.get(0);
//        }
//
//        return numeroAtual;
//    }
}
