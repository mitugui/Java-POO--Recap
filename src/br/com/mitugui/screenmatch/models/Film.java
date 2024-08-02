package br.com.mitugui.screenmatch.models;

import br.com.mitugui.screenmatch.calculations.Classifiable;

public class Film extends Title implements Classifiable {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getAverage() / 2;
    }
}