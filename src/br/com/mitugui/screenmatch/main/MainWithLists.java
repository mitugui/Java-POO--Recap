package br.com.mitugui.screenmatch.main;

import br.com.mitugui.screenmatch.models.Film;
import br.com.mitugui.screenmatch.models.Series;
import br.com.mitugui.screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;

public class MainWithLists {
    public static void main(String[] args) {
        Film favoriteFilm = new Film(
                "Godzilla Minus One",
                2023
        );
        favoriteFilm.rate(10);

        Film otherFilm = new Film(
                "The Boy and the Heron",
                2023
        );
        otherFilm.rate(9);

        Film newFilm = new Film(
                "Swing Girls",
                2004
        );
        newFilm.rate(10);

        Series favoriteSeries = new Series(
                "The Office",
                2005,
                9,
                false,
                22,
                22
        );

        ArrayList<Title> watchedList = new ArrayList<>();
        watchedList.add(favoriteFilm);
        watchedList.add(otherFilm);
        watchedList.add(newFilm);
        watchedList.add(favoriteSeries);

        for(Title title: watchedList){
            System.out.println(title.getName());
            if (title instanceof Film film) {
                System.out.println("Classificação: " + film.getClassification());
            }
        }

        System.out.println(watchedList);
        Collections.sort(watchedList);
        System.out.println(watchedList);
    }
}
