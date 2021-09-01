package br.com.maiseduca.helper;
import java.util.ArrayList;
import java.util.List;
import br.com.maiseduca.R;
import br.com.maiseduca.game.Jogo;

public class GameEmocoes extends GamePassaVoltaHelper{
    private int QUANTIDADE_DE_EMOCOES;
    private List<Jogo> listaEmocoes;
    private int posicaoAtual = 0;

    public GameEmocoes(){
        listaEmocoes = new ArrayList<>();
        criaObjetos();
        QUANTIDADE_DE_EMOCOES = (listaEmocoes.size() -1);
    }

    void criaObjetos() {
        listaEmocoes.add(new Jogo(R.drawable.emocao_assustado,R.raw.surpreso));
        listaEmocoes.add(new Jogo(R.drawable.emocao_brabo,R.raw.brabo));
        listaEmocoes.add(new Jogo(R.drawable.emocao_contente,R.raw.contente));
        listaEmocoes.add(new Jogo(R.drawable.emocao_duvida,R.raw.duvida));
        listaEmocoes.add(new Jogo(R.drawable.emocao_feliz,R.raw.feliz));
        listaEmocoes.add(new Jogo(R.drawable.emocao_triste,R.raw.triste));
    }

    public Jogo pegaProximo() {
        posicaoAtual++;
        if (posicaoAtual > QUANTIDADE_DE_EMOCOES) posicaoAtual = 0;
        return listaEmocoes.get(posicaoAtual);
    }

    public Jogo pegaAnterior() {
        posicaoAtual--;
        if (posicaoAtual < 0) posicaoAtual = QUANTIDADE_DE_EMOCOES;
        return listaEmocoes.get(posicaoAtual);
    }
}
