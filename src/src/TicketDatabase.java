import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TicketDatabase extends Ticket {

    public ArrayList<Ticket> tickets;
    public String[] seatsClone;
    public String[] seats;

    public TicketDatabase() {
        tickets = new ArrayList<>();
        seats = new String[]{
                "A1, ", "A2, ", "A3, ", "A4, ", "A5, ",
                "B1, ", "B2, ", "B3, ", "B4, ", "B5, ",
                "C1, ", "C2, ", "C3, ", "C4, ", "C5, ",
                "D1, ", "D2, ", "D3, ", "D4, ", "D5, ",
                "E1, ", "E2, ", "E3, ", "E4, ", "E5"
        };
        seatsClone = seats.clone();
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    public void removeTicket(Ticket t) {
        tickets.remove(t);
    }

    public void printTickets(Account a) {
        for (Ticket t : tickets) {
            if (t.getAccount().equals(a)) {
                System.out.println("-------------------------------------------------\n" +
                        "Ticket Price   : $" + t.getPrice() + "\n" +
                        "Seat Location  : " + t.getSeatLocation() + "\n" +
                        "Discount       : " + t.isDiscounted() + "\n" +
                        "Movie Name     : " + t.getMovie().getTitle() + "\n" +
                        "Movie Theater  : " + t.getMovie().getTheater() + "\n" +
                        "Movie Showtime : " + t.getMovie().getShowtime() + "\n" +
                        "Account Name   : " + t.getAccount().getUsername() + "\n" +
                        "-------------------------------------------------\n");
            }
        }
    }

    public void printOutTickets(Account a) {
        try {
            File tickets = new File("Tickets.txt");
            if (tickets.createNewFile()) {
                System.out.println("File created: Tickets.txt");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("Tickets.txt");
            for (Ticket t : tickets) {
                if (t.getAccount().equals(a)) {
                    fw.write("----------------CineMore Ticket----------------\n" +
                            "| Ticket Price   : $" + t.getPrice() + "\n" +
                            "| Seat Location  : " + t.getSeatLocation() + "\n" +
                            "| Discount       : " + t.isDiscounted() + "\n" +
                            "| Movie Name     : " + t.getMovie().getTitle() + "\n" +
                            "| Movie Theater  : " + t.getMovie().getTheater() + "\n" +
                            "| Movie Showtime : " + t.getMovie().getShowtime() + "\n" +
                            "| Account Name   : " + t.getAccount().getUsername() + "\n" +
                            "-----------------------------------------------\n");
                }
            }
            fw.close();
            System.out.print("Your ticket(s) have been printed into the file 'Tickets.txt'\n");

        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public boolean ticketAvailable(String movie, int numOfTicketsRequested) {
        int ticketsPurchased = 0;
        for (Ticket t : tickets) {
            if (t.getMovie().getTitle().equalsIgnoreCase(movie)) {
                ticketsPurchased++;
            }
        }

        ticketsPurchased += numOfTicketsRequested;

        if (ticketsPurchased < 25) {
            return true;
        }

        return false;
    }

    public void printSeatsAvailable(String movie) {
        for (Ticket t : tickets) {
            if (t.getMovie().getTitle().equalsIgnoreCase(movie)) {
                if (contains(t.getSeatLocation())) {
                    setNull(t.getSeatLocation());
                }
            }
        }

        for (String s : seatsClone) {
            System.out.print(s);
        }
    }

    public boolean contains(String s) {
        for (String i : seatsClone) {
            if (i.substring(0, 2).equalsIgnoreCase(s)) {
                return true;
            }
        }

        return false;
    }

    public void setNull(String s) {
        for (int i = 0; i < seatsClone.length; i++) {
            if (seatsClone[i].substring(0, 2).equalsIgnoreCase(s)) {
                seatsClone[i] = "";
            }
        }
    }
}
