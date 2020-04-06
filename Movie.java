public class Movie {
    private String title;
    private int rating;
    private String director;
    private int hours;
    private int minutes;
    private int cost;
    private String theater;
    private String showtime;


    public Movie() {
        title = "";
        rating = 0;
        director = "";
        hours = 0;
        minutes = 0;
        cost = 0;
        theater = "";
        showtime = "";
    }

    public Movie(String title, int rating, String director, int hours, int minutes, int cost, String theater, String showtime) {
        setTitle(title);
        setRating(rating);
        setDirector(director);
        setDuration(hours, minutes);
        setCost(cost);
        setTheater(theater);
        setShowtime(showtime);
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return hours + " Hour(s) " + minutes + " Minute(s)";
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public int getCost() {
        return cost;
    }

    public String getTheater() {
        return theater;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean setRating(int rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
            return true;
        } else {
            System.out.println("Rating must be between 0 - 5.");
            this.rating = 0;
        }
        return false;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

}
