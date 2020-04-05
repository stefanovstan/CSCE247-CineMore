public class TicketAccessories {
    private String snacks;
    private String drinks;
    private double snackPrice;
    private double drinkPrice;
    private boolean DDD;

    public TicketAccessories(String snacks, String drinks, double snackPrice, double drinkPrice) {
        this.snacks = snacks;
        this.drinks = drinks;
        this.snackPrice = snackPrice;
        this.drinkPrice = drinkPrice;
    }
    
    public String getSnacks() {
        return snacks;
    }

    public void setSnacks(String snacks) {
        this.snacks = snacks;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public double getSnackPrice() {
        return snackPrice;
    }

    public void setSnackPrice(double snackPrice) {
        this.snackPrice = snackPrice;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public boolean isDDD() {
        return DDD;
    }

    public void setDDD(boolean DDD) {
        this.DDD = DDD;
    }
    
    public void addAccessory(TicketAccessories a) {
        
    }
}
