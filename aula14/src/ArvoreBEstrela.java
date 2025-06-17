import java.util.*;

public class ArvoreBEstrela implements ArvoreIndice {
    private TreeMap<Integer, Produto> dados;

    public ArvoreBEstrela(int ordem) {
        dados = new TreeMap<>();
    }

    public void inserir(int chave, Produto produto) {
        dados.put(chave, produto);
    }

    public boolean remover(int chave) {
        return dados.remove(chave) != null;
    }

    public Produto buscar(int chave) {
        return dados.get(chave);
    }
}

