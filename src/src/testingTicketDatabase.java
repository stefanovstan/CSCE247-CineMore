public class testingTicketDatabase{
    public static void main(String[] args) {
        TicketDatabase testingTickets = new TicketDatabase();

        Movie testTicketMovie = new Movie();

        Account testTicketAcc = new Account();

        Ticket testTicket = new Ticket(0.0, "", false, testTicketMovie, testTicketAcc);

        testingTickets.addTicket(testTicket);
        //testing default values
        for(Ticket t : testingTickets.tickets){
            //should return 0.0
            System.out.println(t.getPrice());
            //should return false
            System.out.println(t.isDiscounted());
            //should return true
            System.out.println(testingTickets.ticketAvailable(t.getMovie().getTitle(), 0));
        }
        //should be the same as above
        testingTickets.printTickets(testTicket.getAccount());
        //should print A1,A2...B1,B2..etc
        testingTickets.printSeatsAvailable(testTicket.getMovie().getTitle());
        //should return Your ticket(s) have been printed into the file 'Tickets.txt' the first time
        testingTickets.printOutTickets(testTicketAcc);
    }
}
