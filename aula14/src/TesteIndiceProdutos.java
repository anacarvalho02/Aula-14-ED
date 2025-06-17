import java.io.IOException;
import java.util.*;

public class TesteIndiceProdutos {
    public static void main(String[] args) throws IOException {
        List<Produto> produtos = LeitorArquivo.lerProdutos("produtos_corrigido (1).txt");

        ArvoreIndice bMais = new ArvoreBMais(3);
        ArvoreIndice bEstrela = new ArvoreBEstrela(3);


        long ini1 = System.nanoTime();
        for (Produto p : produtos) bMais.inserir(p.id, p);
        long fim1 = System.nanoTime();
        System.out.println("Tempo de inserção B+: " + (fim1 - ini1) / 1_000_000 + " ms");


        long ini2 = System.nanoTime();
        for (Produto p : produtos) bEstrela.inserir(p.id, p);
        long fim2 = System.nanoTime();
        System.out.println("Tempo de inserção B*: " + (fim2 - ini2) / 1_000_000 + " ms");


        Random r = new Random();
        Set<Integer> chaves = new HashSet<>();
        while (chaves.size() < 10) chaves.add(1000 + r.nextInt(1001));

        System.out.println("\nRemoção na B+");
        long remIni1 = System.nanoTime();
        for (int chave : chaves) {
            boolean removido = bMais.remover(chave);
            System.out.println("Chave " + chave + ": " + (removido ? "Removido" : "Não encontrado"));
        }
        long remFim1 = System.nanoTime();
        System.out.println("Tempo de remoção B+: " + (remFim1 - remIni1) / 1_000_000 + " ms");

        System.out.println("\nRemoção na B*");
        long remIni2 = System.nanoTime();
        for (int chave : chaves) {
            boolean removido = bEstrela.remover(chave);
            System.out.println("Chave " + chave + ": " + (removido ? "Removido" : "Não encontrado"));
        }
        long remFim2 = System.nanoTime();
        System.out.println("Tempo de remoção B*: " + (remFim2 - remIni2) / 1_000_000 + " ms");
    }
}

