package br.com.mitugui.screenmatch.services;

import br.com.mitugui.screenmatch.models.Title;
import br.com.mitugui.screenmatch.records.TitleOmdb;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class QueryTitle {
    public Title queryTitle(String address, Gson gson) throws IOException, InterruptedException {
        var apiConsumption = new ApiConsumption();
        String responseBody = apiConsumption.getData(address);

        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        if (jsonResponse.get("Response").getAsString().equals("False")) {
            System.out.println("Nenhum resultado encontrado. Tente novamente com outro filme.");
            return null;
        }

        var titleOmdb = gson.fromJson(responseBody, TitleOmdb.class);
        var title = new Title(titleOmdb);
        System.out.println("Resultado da pesquisa: " + title);

        return title;
    }
}