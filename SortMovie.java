public class SortMovies extends Movie {
    private Movie[] movies;

    public Movie[] sortByRating (Movie[] movies) {
        for(int i = 0; i < movies.length; i++) {
            if(movies[i].getRating() >= movies[i+1].getRating()) {
                Movie temp = movies[i];
                movies[i] = movies[i+1];
                movies[i+1] = temp;
            }
        }
        return movies;
    }

    public Movie[] sortAlphabetical (Movie[] movies) {
        for(int i = 0; i < movies.length; i++) {
            if(movies[i].getTitle() != movies[i+1].getTitle()) {
                char x = movies[i].getTitle().charAt(0);
                char y = movies[i+1].getTitle().charAt(0);

                Movie temp = movies[i];
                movies[i] = movies[i+1];
                movies[i+1] = temp;
            }
        }
        return movies;
    }

    public Movie[] sortbyTag(Movie[] movies) {

    }

    public Movie[] sortbyDirector(Movie[] movies) {

    }

    public Movie[] sortbyLength(Movie[] movies) {

    }
}
