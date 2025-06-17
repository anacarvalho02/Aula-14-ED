interface ArvoreIndice {
    void inserir(int chave, Produto produto);
    boolean remover(int chave);
    Produto buscar(int chave);
}

