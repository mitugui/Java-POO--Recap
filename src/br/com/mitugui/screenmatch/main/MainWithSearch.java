package br.com.mitugui.screenmatch.main;

import br.com.mitugui.screenmatch.models.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um filme para a busca: ");
        var search = scan.nextLine();
        String KEY = "";

        String address = "http://www.omdbapi.com/?t=" + search + "&apikey=" + KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Title searchedTitle = gson.fromJson(json, Title.class);
        System.out.println(searchedTitle);
    }
}
