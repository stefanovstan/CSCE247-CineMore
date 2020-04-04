public class MovieDatabase extends Movie {
    public int DATABASE_LENGTH;
    public int count;
    public Movie[] movies;

    public MovieDatabase() {
        count = 0;
        DATABASE_LENGTH = 100;
        movies = new Movie[DATABASE_LENGTH];
    }

    public void addMovie(Movie m) {
        if (movies.length == DATABASE_LENGTH-1) {
            growArray(movies)[count] = m;

        } else {
            movies[count] = m;
        }

        count++;
    }

    public void removeMovie(Movie m) {
        for (Movie i : movies) {
            if (i == m) {
                i = null;
            }
        }
    }

    public void printMovieDatabase() {
        for (Movie m : movies) {
            System.out.println(
                    "Movie Title    : " + m.getTitle() + " \n" +
                    "Movie Rating   : " + m.getRating() + "\n" +
                    "Movie Director : " + m.getDirector() + "\n" +
                    "Movie Duration : " + m.getDuration() + "\n"
            );
        }
    }

    public Movie[] growArray(Movie[] m) {
        DATABASE_LENGTH *= 2;
        Movie[] newArray = new Movie[DATABASE_LENGTH];
        newArray = m.clone();
        return newArray;
    }
}
