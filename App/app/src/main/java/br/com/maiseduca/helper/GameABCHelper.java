package br.com.maiseduca.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class GameABCHelper extends GamePassaVoltaHelper{
    private List<Jogo> listaAlfabeto;
    private int sequencia;
    private Jogo letraAtual;
    private int posicaoAtual = 0;
    private int QUANTIDADE;

    public GameABCHelper(){
        listaAlfabeto = new ArrayList<>();
        criaObjetos();
        QUANTIDADE = (listaAlfabeto.size() -1);
    }

    void criaObjetos() {
        Jogo letraA = new Jogo(R.drawable.letra_a,R.raw.a);
        Jogo letraB = new Jogo(R.drawable.letra_b,R.raw.b);
        Jogo letraC = new Jogo(R.drawable.letra_c,R.raw.c);
        Jogo letraD = new Jogo(R.drawable.letra_d,R.raw.d);
        Jogo letraE = new Jogo(R.drawable.letra_e,R.raw.e);
        Jogo letraF = new Jogo(R.drawable.letra_f,R.raw.f);
        Jogo letraG = new Jogo(R.drawable.letra_g,R.raw.g);
        Jogo letraH = new Jogo(R.drawable.letra_h,R.raw.h);
        Jogo letraI = new Jogo(R.drawable.letra_i,R.raw.i);
        Jogo letraJ = new Jogo(R.drawable.letra_j,R.raw.j);
        Jogo letraK = new Jogo(R.drawable.letra_k,R.raw.k);
        Jogo letraL = new Jogo(R.drawable.letra_l,R.raw.l);
        Jogo letraM = new Jogo(R.drawable.letra_m,R.raw.m);
        Jogo letraN = new Jogo(R.drawable.letra_n,R.raw.n);
        Jogo letraO = new Jogo(R.drawable.letra_o,R.raw.o);
        Jogo letraP = new Jogo(R.drawable.letra_p,R.raw.p);
        Jogo letraQ = new Jogo(R.drawable.letra_q,R.raw.q);
        Jogo letraR = new Jogo(R.drawable.letra_r,R.raw.r);
        Jogo letraS = new Jogo(R.drawable.letra_s,R.raw.s);
        Jogo letraT = new Jogo(R.drawable.letra_t,R.raw.t);
        Jogo letraU = new Jogo(R.drawable.letra_u,R.raw.u);
        Jogo letraV = new Jogo(R.drawable.letra_v,R.raw.v);
        Jogo letraW = new Jogo(R.drawable.letra_w,R.raw.w);
        Jogo letraX = new Jogo(R.drawable.letra_x,R.raw.x);
        Jogo letraY = new Jogo(R.drawable.letra_y,R.raw.y);
        Jogo letraZ = new Jogo(R.drawable.letra_z,R.raw.z);
        letraAtual = letraA;

        listaAlfabeto.add(letraA);
        listaAlfabeto.add(letraB);
        listaAlfabeto.add(letraC);
        listaAlfabeto.add(letraD);
        listaAlfabeto.add(letraE);
        listaAlfabeto.add(letraF);
        listaAlfabeto.add(letraG);
        listaAlfabeto.add(letraH);
        listaAlfabeto.add(letraI);
        listaAlfabeto.add(letraJ);
        listaAlfabeto.add(letraK);
        listaAlfabeto.add(letraL);
        listaAlfabeto.add(letraM);
        listaAlfabeto.add(letraN);
        listaAlfabeto.add(letraO);
        listaAlfabeto.add(letraP);
        listaAlfabeto.add(letraQ);
        listaAlfabeto.add(letraR);
        listaAlfabeto.add(letraS);
        listaAlfabeto.add(letraT);
        listaAlfabeto.add(letraU);
        listaAlfabeto.add(letraV);
        listaAlfabeto.add(letraW);
        listaAlfabeto.add(letraX);
        listaAlfabeto.add(letraY);
        listaAlfabeto.add(letraZ);
    }

    @Override
    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE) posicaoAtual = 0;
        return listaAlfabeto.get(posicaoAtual);
    }

    @Override
    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE;
        return listaAlfabeto.get(posicaoAtual);
    }

//    @Override
//    public Jogo pegaObjetos(boolean ordenado){
//        if (ordenado){
//            if (sequencia >= listaAlfabeto.size()) sequencia = 0;
//            int i = sequencia;
//            sequencia ++;
//            letraAtual = listaAlfabeto.get(i);
//        } else {
//            while (letraAtual == listaAlfabeto.get(0)) {
//                Collections.shuffle(listaAlfabeto);
//            }
//
//            letraAtual = listaAlfabeto.get(0);
//        }
//
//        return letraAtual;
//    }
}
