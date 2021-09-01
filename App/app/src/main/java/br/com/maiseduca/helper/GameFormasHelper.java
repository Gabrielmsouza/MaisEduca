package br.com.maiseduca.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class GameFormasHelper extends GamePassaVoltaHelper{
    private List<Jogo> listaFormas;
    private int sequencia;
    private Jogo formaAtual;
    private int QUANTIDADE;
    private int posicaoAtual = 0;

    public GameFormasHelper(){
        listaFormas = new ArrayList<>();
        criaObjetos();
        QUANTIDADE = (listaFormas.size() -1);
    }

    void criaObjetos() {
        Jogo quadrado = new Jogo(R.drawable.quadrado,R.raw.quadrado);
        Jogo circulo = new Jogo(R.drawable.circulo,R.raw.circulo);
        Jogo triangulo = new Jogo(R.drawable.triangulo,R.raw.triangulo);
        Jogo pentagono = new Jogo(R.drawable.pentagono,R.raw.pentagono);
        Jogo retangulo = new Jogo(R.drawable.retangulo,R.raw.retangulo);
        Jogo trapezio = new Jogo(R.drawable.trapezio,R.raw.trapezio);

        formaAtual = quadrado;

        listaFormas.add(circulo);
        listaFormas.add(quadrado);
        listaFormas.add(triangulo);
        listaFormas.add(pentagono);
        listaFormas.add(retangulo);
        listaFormas.add(trapezio);
    }

    @Override
    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE) posicaoAtual = 0;
        return listaFormas.get(posicaoAtual);
    }

    @Override
    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE;
        return listaFormas.get(posicaoAtual);
    }

//    @Override
//    public Jogo pegaObjetos(boolean ordenado){
//        if (ordenado){
//            if (sequencia >= listaFormas.size()) sequencia = 0;
//            int i = sequencia;
//            sequencia ++;
//            formaAtual = listaFormas.get(i);
//        } else {
//            while (formaAtual == listaFormas.get(0)) {
//                Collections.shuffle(listaFormas);
//            }
//
//            formaAtual = listaFormas.get(0);
//        }
//        return formaAtual;
//    }
}
