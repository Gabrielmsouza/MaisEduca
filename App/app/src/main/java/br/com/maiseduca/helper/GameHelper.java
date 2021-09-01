package br.com.maiseduca.helper;

import br.com.maiseduca.game.Jogo;

public abstract class GameHelper {
    abstract void criaObjetos();
    abstract public Jogo pegaObjetos(boolean ordenado);
}
