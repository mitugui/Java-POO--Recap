import br.com.mitugui.screenmatch.models.Film;

public class Main {
    public static void main(String[] args) {
        Film myFilm = new Film();
        myFilm.setName("Godzilla Minus One");

        System.out.println(myFilm.getName());
    }
}