package br.com.mitugui.screenmatch.utilities;

import br.com.mitugui.screenmatch.models.Title;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileGenerator {
    public void recordJson(List<Title> titles, Gson gson) throws IOException {
        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titles));
        writer.close();
    }
}