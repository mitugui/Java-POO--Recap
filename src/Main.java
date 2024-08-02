import br.com.mitugui.screenmatch.calculations.RecommendationFilter;
import br.com.mitugui.screenmatch.calculations.TimeCalculator;
import br.com.mitugui.screenmatch.models.Film;
import br.com.mitugui.screenmatch.models.Series;

public class Main {
    public static void main(String[] args) {
        Film favoriteFilm = new Film(
                "Godzilla Minus One",
                2023,
                true,
                125,
                "Takashi Hamazaki"
        );
        favoriteFilm.rate(10);

        Film otherFilm = new Film(
                "The Boy and the Heron",
                2023,
                true,
                124,
                "Hayao Miyazaki"
        );
        otherFilm.rate(9);

        Series favoriteSeries = new Series(
                "The Office",
                2005,
                true,
                9,
                false,
                22,
                22
        );
        favoriteSeries.rate(9);

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(favoriteFilm);
        calculator.include(otherFilm);
        calculator.include(favoriteSeries);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(favoriteFilm);
    }
}