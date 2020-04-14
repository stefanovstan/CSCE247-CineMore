public class testingTicketCreation {
    public static void main(String[] args){
        //creating account and movie to test the ticket methods
        Movie testTixMovie = new Movie();
        Account testTixAcc = new Account();
        AccountType testTixAccType = new AccountType("admin");
        testTixAcc.setAccountType(testTixAccType);

        //creating new ticket
        Ticket testTix = new Ticket(0.0, "", false, testTixMovie, testTixAcc);

        //test to return default values of ticket (should be 0.0, empty string, false, movie, account)
        System.out.println(testTix.getPrice());
        System.out.println(testTix.getSeatLocation());
        System.out.println(testTix.isDiscounted());
        System.out.println(testTix.getMovie());
        System.out.println(testTix.getAccount());

        //test to set a 15% discount (should return 85.0)
        testTix.setPrice(100.0);
        testTix.setDiscount(true);
        System.out.println(testTix.getPrice());

    }
}
