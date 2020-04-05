public class TicketDatabase extends Ticket{
    public int DATABASE_LENGTH;
    public int count;
    public Ticket[] Tickets;

    public TicketDatabase() {
        count = 0;
        DATABASE_LENGTH = 100;
        Tickets = new Ticket[DATABASE_LENGTH];
    }

    public void addTicket (Ticket t) {
        if (Tickets.length == DATABASE_LENGTH-1) {
            growArray(Tickets)[count] = t;
        } else {
            Tickets[count] = t;
        } count++;
    }

    public void removeTicket (Ticket t) {
        for (Ticket i : Tickets) {
            if (i == t) {
                i = null;
            }
        }
    }

    public void printTicketDatabase() {
        for (Ticket t : Tickets) {
            System.out.println(
                    "Ticket Price" + t.getPrice() + "\n" + 
                            "Seat Location" + t.setSeatLocation() + "\n" +
                            "Discount Amount" + t.isDiscount() + "\n" +
                            "Movie" + t.getMovie() + "\n" +
                            "Account" + t.getAccount() + "\n");
        }
    }

    public Ticket[] growArray(Ticket[] t) {
        DATABASE_LENGTH *= 2;
        Ticket[] newArray = new Ticket[DATABASE_LENGTH];
        newArray = t.clone();
        return newArray;
    }
}
