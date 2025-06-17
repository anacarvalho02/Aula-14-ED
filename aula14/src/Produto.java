public class Produto {
    int id;
    String nome;
    String categoria;

    public Produto(int id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + categoria;
    }
}

