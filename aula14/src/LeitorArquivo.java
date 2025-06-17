import java.io.*;
import java.util.*;

public class LeitorArquivo {
    public static List<Produto> lerProdutos(String caminhoArquivo) throws IOException {
        List<Produto> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(",");
            int id = Integer.parseInt(partes[0].trim());
            String nome = partes[1].trim();
            String categoria = partes[2].trim();
            lista.add(new Produto(id, nome, categoria));
        }
        br.close();
        return lista;
    }
}

