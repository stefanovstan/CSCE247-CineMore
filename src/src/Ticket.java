public class Ticket {
    private double price;
    private String seatLocation;
    private boolean discount;
    private Movie movie;
    private Account account;

    public Ticket() {
        price = 0.0;
        seatLocation = "";
        discount = false;
        movie = null;
        account = null;
    }

    public Ticket(double price, String seatLocation, boolean discount, Movie movie, Account account) {
        setPrice(price);
        setSeatLocation(seatLocation);
        setDiscount(discount);
        setMovie(movie);
        setAccount(account);
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;

        if (this.discount == true) {
            price *= .85;
        }
    }

    public boolean isDiscounted() {
        if (account.isDisability() || account.isStudent() || account.isSenior() || account.isMilitary()
                || account.isTeacher()) {
            return true;
        }

        return false;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
