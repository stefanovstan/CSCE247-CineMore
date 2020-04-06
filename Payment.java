public class Payment {

    private String cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private int securityCode;

    public Payment() {
        this.cardNumber = "";
        this.expirationMonth = 0;
        this.expirationYear = 0;
        this.securityCode = 0;
    }

    public Payment(String cardNumber, int expirationMonth, int expirationYear, int securityCode) {
        setCardNumber(cardNumber);
        setExpirationMonth(expirationMonth);
        setExpirationYear(expirationYear);
        setSecurityCode(securityCode);
    }

    public boolean setCardNumber(String cardNumber) {
        if (cardNumber.length() == 16) {
            this.cardNumber = cardNumber;
            return true;
        }

        System.out.println("Card number must be 16 digits");
        return false;
    }

    public boolean setExpirationMonth(int expirationMonth) {
        if (expirationMonth <= 12 && expirationMonth > 0) {
            this.expirationMonth = expirationMonth;
            return true;
        }

        System.out.println("Invalid expiration month. Ex. January = 1, December = 12");
        return false;
    }

    public boolean setExpirationYear(int expirationYear) {
        if(expirationMonth >= 4 && expirationYear >= 2020 || expirationMonth > 0 && expirationYear > 2020) {
            this.expirationYear = expirationYear;
            return true;
        }

        System.out.println("Card is expired. Please use a valid debit or credit card.");
        return false;
    }

    public boolean setSecurityCode(int securityCode) {
        if(securityCode > 99 && securityCode < 1000) {
            this.securityCode = securityCode;
            return true;
        }

        System.out.println("Security code must be 3 digits. Check the back of your card.");
        return false;
    }
}
