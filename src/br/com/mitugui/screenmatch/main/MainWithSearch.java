package br.com.mitugui.screenmatch.main;

import br.com.mitugui.screenmatch.models.Title;
import br.com.mitugui.screenmatch.records.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TitleOmdb searchedTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        // System.out.println(searchedTitleOmdb);
        Title searchedTitle = new Title(searchedTitleOmdb);
        System.out.println("Resultado da pesquisa: " + searchedTitle);
    }
}
