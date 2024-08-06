package br.com.mitugui.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    private double ratingSum;
    private int totalRatings;
    private int durationInMinutes;

    public Title(
            String name,
            int releaseYear,
            boolean includedInPlan,
            int durationInMinutes
    ) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedInPlan = includedInPlan;
        this.durationInMinutes = durationInMinutes;
    }
    public Title(
            String name,
            int releaseYear
    ) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public void displayTechnicalSheet () {
        System.out.println("Nome do filme: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    public void rate(double rating) {
        ratingSum += rating;
        totalRatings++;
    }

    public double getAverage() {
        return ratingSum / totalRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.name);
    }

    @Override
    public String toString() {
        return "Título: " + this.name + " ("+ this.releaseYear +")";
    }
}