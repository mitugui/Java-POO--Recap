package br.com.mitugui.screenmatch.utilities;

import br.com.mitugui.screenmatch.exceptions.MissingApiKeyException;
import br.com.mitugui.screenmatch.models.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

public class SearchTitleMenu {
    public void searchTitle(List<Title> titles, Gson gson) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String API_KEY = System.getenv("API_KEY");

        try {
            if (API_KEY == null || API_KEY.isEmpty()) {
                throw new MissingApiKeyException("A Api Key não está definida. Verifique as variáveis de ambiente.");
            }
            while (true) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Digite um filme para buscar ou \"sair\" para encerrar o programa:");
                String search = sc.nextLine();

                if (search.equalsIgnoreCase("sair"))
                    break;

                String address = "http://www.omdbapi.com/?t=" + URLEncoder.encode(search, "UTF-8")
                        + "&apikey=" + API_KEY;

                QueryTitle query = new QueryTitle();
                titles.add(query.queryTitle(address, gson));
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Erro de codificação: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída ao buscar o título: " + e.getMessage());
        } catch (MissingApiKeyException e) {
            System.err.println("Erro de API Key: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}