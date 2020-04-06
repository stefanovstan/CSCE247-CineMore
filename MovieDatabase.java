import java.util.ArrayList;

public class MovieDatabase extends Movie {

    public ArrayList<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    public void removeMovie(Movie m) {
        movies.remove(m);
    }

    public Movie findMovie(String title) {
        for (Movie m : movies) {
            if(m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void printMovieDatabase() {
        for (Movie m : movies) {
            System.out.println("\n\n-------------------------------------------------\n" +
                                "Movie Title    : " + m.getTitle() + " \n" +
                                "Movie Rating   : " + m.getRating() + "\n" +
                                "Movie Director : " + m.getDirector() + "\n" +
                                "Movie Duration : " + m.getDuration() + "\n" +
                                "Movie Cost     : " + m.getCost() + "\n" +
                                "Movie Theater  : " + m.getTheater() + "\n" +
                                "Movie Showtime : " + m.getShowtime() + "\n" +
                                "-------------------------------------------------\n\n");
        }
    }
}
