public class testingMovieCreation {
    public static void main(String[] args){

        //creating new movie
        Movie testMov = new Movie();

        //testing default values

        //should return empty string
        System.out.println(testMov.getTitle()+"\n");

        //should return 0 hours and 0 minutes
        System.out.println(testMov.getDuration());

        //should return empty string
        System.out.println(testMov.getDirector()+"\n");

        //should return 0
        System.out.println(testMov.getRating());

        //should return 0
        System.out.println(testMov.getCost());

        //should return empty string
        System.out.println(testMov.getTheater()+"\n");

        //should return empty string
        System.out.println(testMov.getShowtime()+"\n");

    }
}
