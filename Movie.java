public class Movie {
    private String title;
    private int rating;
    private String director;
    private String tag;
    private int hours;
    private int minutes;


    public Movie() {
        title = "";
        rating = 0;
        director = "";
        tag = "";
        hours = 0;
        minutes = 0;
    }

    public Movie(String title, int rating, String director, String tag, int hours, int minutes) {
        setTitle(title);
        setRating(rating);
        setDirector(director);
        setTag(tag);
        setDuration(hours, minutes);
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public String getDuration() {
        return hours + " Hour(s) " + minutes + " Minute(s)";
    }

    public String getDirector() {
        return this.director;
    }

    public int getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDuration(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Rating is incorrect. Automatically set to 0");
            this.rating = 0;
        }
    }

}
