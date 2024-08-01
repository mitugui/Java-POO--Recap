package br.com.mitugui.screenmatch.calculations;

import br.com.mitugui.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void include(Title title) {
        totalTime += title.getDurationInMinutes();
    }
}