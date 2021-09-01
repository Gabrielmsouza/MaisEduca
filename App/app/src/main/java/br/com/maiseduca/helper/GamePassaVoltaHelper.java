package br.com.maiseduca.helper;

import br.com.maiseduca.game.Jogo;

public abstract class GamePassaVoltaHelper{
    abstract void criaObjetos();
    abstract public Jogo pegaProximo();
    abstract public Jogo pegaAnterior();
}
