package br.com.maiseduca.game;

public class Jogo {
    private int imagem;
    private int som;

    public Jogo(int imagem, int som){
        this.imagem = imagem;
        this.som = som;
    }

    public int getImagem() {
        return imagem;
    }

    public int getSom() {
        return som;
    }
}
