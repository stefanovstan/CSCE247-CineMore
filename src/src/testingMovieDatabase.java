public class testingMovieDatabase{
    public static void main(String[] args) {
        MovieDatabase testMovies = new MovieDatabase();

        Movie testMovie = new Movie();

        testMovies.addMovie(testMovie);
        //testing default parameters
        for (Movie m : testMovies.movies) {
            //should get an empty string or a blank line
            System.out.println(m.getTitle());
            //should get a cost of 0
            System.out.println(m.getCost());
            //should get an empty string or blank line
            System.out.println(m.getShowtime());
            //should get an empty string or blank line
            System.out.println(m.getDirector());
            //should get an empty string or blank line
            System.out.println(m.getTheater());
            //should get hours = 0 and minutes = 0
            System.out.println(m.getDuration());
            //should get a rating of 0
            System.out.println(m.getRating());
            //should return testMovie memory address
            System.out.println(testMovies.findMovie(m.getTitle()));
        }
        //should repeat the for each method except the find method
        testMovies.printMovieDatabase();

        // should remove testMovie then return null
        testMovies.removeMovie(testMovie);
        System.out.println(testMovies.findMovie(testMovie.getTitle()));
    }
}
