package br.com.mitugui.screenmatch.main;

import br.com.mitugui.screenmatch.models.Title;
import br.com.mitugui.screenmatch.utilities.SearchTitleMenu;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainWithSearch {
    public static void main(String[] args) {
        List<Title> searchedFilms = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        SearchTitleMenu searchMenu = new SearchTitleMenu();
        searchMenu.searchTitle(gson, searchedFilms);

        System.out.println("Lista dos pesquisados: \n" + searchedFilms);

        System.out.print("-- O programa finalizou corretamente. --");
    }
}