package br.com.mitugui.screenmatch.utilities;

import br.com.mitugui.screenmatch.models.Title;
import br.com.mitugui.screenmatch.records.TitleOmdb;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryTitle {
    public Title queryTitle(String address, Gson gson) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        if (jsonResponse.get("Response").getAsString().equals("False")) {
            System.out.println("Nenhum resultado encontrado. Tente novamente com outro filme.");
            return null;
        }

        TitleOmdb titleOmdb = gson.fromJson(response.body(), TitleOmdb.class);
        Title title = new Title(titleOmdb);
        System.out.println("Resultado da pesquisa: " + title);

        return title;
    }
}