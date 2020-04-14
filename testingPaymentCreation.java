public class testingPaymentCreation {
    public static void main(String[] args){

        //creating new payment method
        Payment testCard = new Payment();

        //test to add a new card with valid number (should continue to next line)
        testCard.setCardNumber("9999999999999999");
        System.out.println("card number is valid");

        //test to add invalid card number (should prompt the user that a card number must be 16 digits)
        testCard.setCardNumber("9");

        //test to add valid expiration month (should continue to next line)
        testCard.setExpirationMonth(10);
        System.out.println("expiration month is valid");

        //test to add invalid expiration month (should prompt user that the month should be between 1 and 12)
        testCard.setExpirationMonth(15);

        //reset test to have valid year
        testCard.setExpirationMonth(5);

        //test to add valid expiration year (should continue to next line)
        testCard.setExpirationYear(2024);
        System.out.println("expiration year is valid");

        //test to add invalid expiration year (should prompt the user that the card is expired)
        testCard.setExpirationYear(2010);

        //test to add invalid security code (should prompt the user that a security code should be 3 digits)
        testCard.setSecurityCode(12);

        //test to add valid security code (should continue)
        testCard.setSecurityCode(777);
        System.out.println("security code is valid");

    }
}
