import java.util.Scanner;

public class MovieDriver {

    public static Account currentAccount;
    public static String username;
    public static String ownerCardNumber = "9999999999999999";
    public static int ownerExpirationMonth = 1;
    public static int ownerExpirationYear = 2025;
    public static int ownerSecurityCode = 999;
    public static Account ownerAccount = new Account("BillyGates", "csce247",
                    false, false, false, false, false, true,
                            new Payment(ownerCardNumber, ownerExpirationMonth, ownerExpirationYear, ownerSecurityCode),
                            new AccountType("owner"));

    public static Account testAccount = new Account("k", "k",
            false, false, false, false, false, true,
            new Payment(ownerCardNumber, ownerExpirationMonth, ownerExpirationYear, ownerSecurityCode),
            new AccountType("standard"));

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String password, deleteChoice, createAccountChoice, cardNumber, addMovieChoice, removeMovieChoice, account,
                movie;
        int mainChoice, accountChoice, expirationMonth, expirationYear, securityCode, durationHours, durationMin,
                movieCost, ticketAmt;
        boolean notLoggedIn = true;
        boolean accountSatisfied = true;
        boolean ownerSatisfied = true;
        boolean adminSatisfied = true;
        boolean standardSatisfied = true;
        boolean createAccount = true;
        AccountDatabase ad = new AccountDatabase();
        MovieDatabase md = new MovieDatabase();
        TicketDatabase td = new TicketDatabase();
        currentAccount = null;

        ad.addAccount(ownerAccount);
        ad.addAccount(testAccount);

        while (true) {
            printHomePage();
            mainChoice = s.nextInt();
            if (mainChoice == 1) {
                notLoggedIn = true;
                while (notLoggedIn) {
                    System.out.println("Please enter your username ...");
                    username = s.next();
                    System.out.println("Please enter your password ...");
                    password = s.next();

                    if (ad.isAccount(username, password)) {
                        currentAccount = ad.findAccount(username);
                        notLoggedIn = false;
                    } else {
                        System.out.println("\nUsername or password was incorrect. \n   * Both are case sensitive *\n ");
                    }
                }

                accountSatisfied = true;
                while (accountSatisfied) {

                    if (currentAccount.getAccountType().equals("owner")) {

                        ownerSatisfied = true;
                        while (ownerSatisfied) {
                            printOwnerConsole();
                            accountChoice = s.nextInt();
                            switch (accountChoice) {
                                case 1:
                                    Movie newMovie = new Movie("", 0, "", 0, 0, 0);

                                    System.out.println("What is the title of the movie?");
                                    addMovieChoice = s.next();
                                    newMovie.setTitle(addMovieChoice);

                                    System.out.println("Who is the director of the movie?");
                                    String director = "";
                                    addMovieChoice = s.next();
                                    director = addMovieChoice;
                                    addMovieChoice = s.next();
                                    director += " " + addMovieChoice;
                                    newMovie.setDirector(director);

                                    System.out.println("How many hours is the movie?");
                                    durationHours = s.nextInt();

                                    System.out.println("How many minutes is the movie?");
                                    durationMin = s.nextInt();

                                    newMovie.setDuration(durationHours, durationMin);
                                    md.addMovie(newMovie);

                                    System.out.println("How much should one ticket for this movie cost?");
                                    movieCost = s.nextInt();
                                    newMovie.setCost(movieCost);

                                    md.addMovie(newMovie);

                                    System.out.println("\n\nThe movie " + newMovie.getTitle() + " has been added.\n\n");
                                    continue;

                                case 2:
                                    System.out.println("What movie would you like to remove?");
                                    removeMovieChoice = s.next();

                                    if(md.findMovie(removeMovieChoice) != null) {
                                        System.out.println("\n\nThe movie " + md.findMovie(removeMovieChoice).getTitle() +
                                                " has been removed.\n\n");
                                        md.removeMovie(md.findMovie(removeMovieChoice));
                                    }
                                    else {
                                        System.out.println("\n\nThis movie is not in the system.\n\n");
                                    }

                                    continue;

                                case 3:
                                    System.out.println("Please enter the account username you would like to search for.");
                                    account = s.next();

                                    if(ad.findAccount(account) != null) {
                                        ad.printAccount(account);
                                    }
                                    else {
                                        System.out.println("\n\nThis account is not in the system.\n\n");
                                    }

                                    continue;

                                case 4:
                                    System.out.println("What account would you like to remove?");
                                    account = s.next();

                                    if(ad.findAccount(account).getAccountType().equals("owner")) {
                                        System.out.println("\n\nYou cannot remove this account.\n\n");
                                    }

                                    if(ad.findAccount(account) != null) {
                                        System.out.println("Are you sure you want to REMOVE this account?");
                                        deleteChoice = s.next();

                                        if(deleteChoice.equalsIgnoreCase("yes")) {
                                            System.out.println("\n\nThe account " + ad.findAccount(account).getUsername()
                                                    + " has been removed.\n\n");
                                            ad.removeAccount(ad.findAccount(account));
                                        }
                                    }
                                    else {
                                        System.out.println("\n\nThis account is not in the system.\n\n");
                                    }

                                    continue;

                                case 5:
                                    System.out.println("Which account would you like to make an admin?");
                                    account = s.next();

                                    if (ad.findAccount(account) != null) {
                                        ad.findAccount(account).setAccountType(new AccountType("admin"));
                                    }

                                    else {
                                        System.out.println("\n\nThis account is not in the system.\n\n");
                                    }

                                    continue;

                                case 6:
                                    System.out.println("Which account would you like to make standard?");
                                    account = s.next();

                                    if (ad.findAccount(account) != null) {
                                        ad.findAccount(account).setAccountType(new AccountType("standard"));
                                    }

                                    else {
                                        System.out.println("\n\nThis account is not in the system.\n\n");
                                    }

                                    continue;

                                case 7:
                                    System.out.println("Logging out " + currentAccount.getUsername() + " ...");
                                    currentAccount = null;
                                    ownerSatisfied = false;

                                default:
                                    break;
                            }
                        }

                        break;

                    }

                    if (currentAccount.getAccountType().equals("admin")) {

                        adminSatisfied = true;
                        while(adminSatisfied) {
                            printAdminConsole();
                            accountChoice = s.nextInt();
                            switch (accountChoice) {
                                case 1:
                                    Movie newMovie = new Movie("", 0, "", 0, 0, 0);

                                    System.out.println("What is the title of the movie?");
                                    addMovieChoice = s.next();
                                    newMovie.setTitle(addMovieChoice);

                                    System.out.println("Who is the director of the movie?");
                                    String director = "";
                                    addMovieChoice = s.next();
                                    director = addMovieChoice;
                                    addMovieChoice = s.next();
                                    director += addMovieChoice;
                                    newMovie.setDirector(director);

                                    System.out.println("How many hours is the movie?");
                                    durationHours = s.nextInt();

                                    System.out.println("How many minutes is the movie?");
                                    durationMin = s.nextInt();

                                    newMovie.setDuration(durationHours, durationMin);

                                    System.out.println("How much should one ticket for this movie cost?");
                                    movieCost = s.nextInt();
                                    newMovie.setCost(movieCost);

                                    md.addMovie(newMovie);

                                    System.out.println("The movie " + newMovie.getTitle() + " has been added.");

                                    continue;

                                case 2:
                                    System.out.println("What movie would you like to remove?");
                                    removeMovieChoice = s.next();

                                    if (md.findMovie(removeMovieChoice) != null) {
                                        System.out.println("The movie " + md.findMovie(removeMovieChoice).getTitle() +
                                                " has been removed.");
                                        md.removeMovie(md.findMovie(removeMovieChoice));
                                    } else {
                                        System.out.println("This movie is not in the system.");
                                    }

                                    continue;

                                case 3:
                                    System.out.println("Logging out " + currentAccount.getUsername() + " ...");
                                    currentAccount = null;
                                    adminSatisfied = false;
                            }

                        }

                        break;

                    }

                    if (currentAccount.getAccountType().equals("standard")) {

                        standardSatisfied = true;
                        while(standardSatisfied) {

                            printAccountPage();
                            accountChoice = s.nextInt();
                            switch (accountChoice) {
                                case 1:
                                    System.out.println("Not Available");
                                    continue;
                                case 2:
                                    System.out.println("Not Available");
                                    continue;
                                case 3:
                                    printMoviePage();
                                    md.printMovieDatabase();

                                    if (md.movies.isEmpty()) {
                                        System.out.println("\nThere are currently no movies in theaters.\n");
                                    }

                                    else {
                                        movie = "";
                                        boolean satisfied = true;
                                        while(satisfied) {
                                            System.out.println("Which movie would you like to go see?");
                                            movie = s.next();

                                            if (md.findMovie(movie) != null) {
                                                satisfied = false;
                                            } else {
                                                System.out.println("This movie is not in the system.");
                                            }
                                        }

                                        System.out.println("How many tickets do you need?");
                                        ticketAmt = s.nextInt();
                                        if (td.ticketAvailable(movie, ticketAmt)) {

                                        } else {
                                            System.out.println("We are sorry to inform you that ");
                                        }

                                    }

                                    continue;
                                case 4:
                                    System.out.println("Are you sure you want to DELETE your account?");
                                    deleteChoice = s.next();
                                    if (deleteChoice.equalsIgnoreCase("yes")) {
                                        ad.removeAccount(currentAccount);
                                        standardSatisfied = false;
                                    }
                                    continue;
                                case 5:
                                    System.out.println("Logging out " + currentAccount.getUsername() + " ...");
                                    currentAccount = null;
                                    standardSatisfied = false;

                                default:
                                    break;
                            }
                        }

                        break;

                    }
                }
                continue;

            }

            if (mainChoice == 2) {
                username = null;
                createAccount = true;
                while(createAccount) {

                    System.out.println("What would you like your username to be?");
                    username = s.next();

                    if (!ad.usernameAvailable(username)) {
                        System.out.println("This username has been taken");
                    }
                    else {
                        createAccount = false;
                    }
                }
                System.out.println("What would you like your password to be?");
                password = s.next();

                Account newAccount = new Account(username, password,
                            false, false, false, false, false, false,
                            null, new AccountType("standard"));

                System.out.println("\n--------------------- Personal Information ---------------------\n");
                System.out.println("Are you or have you ever served in a military branch?");
                createAccountChoice = s.next();

                if(createAccountChoice.equalsIgnoreCase("yes")) {
                    newAccount.setMilitary(true);
                    newAccount.setDiscount(true);
                }

                System.out.println("Are you above the age of 65?");
                createAccountChoice = s.next();

                if(createAccountChoice.equalsIgnoreCase("yes")) {
                    newAccount.setSenior(true);
                    newAccount.setDiscount(true);
                }

                System.out.println("Do you teach at a school?");
                createAccountChoice = s.next();

                if(createAccountChoice.equalsIgnoreCase("yes")) {
                    newAccount.setTeacher(true);
                    newAccount.setDiscount(true);
                }

                System.out.println("Do you have a disability?");
                createAccountChoice = s.next();

                if(createAccountChoice.equalsIgnoreCase("yes")) {
                    newAccount.setDisability(true);
                    newAccount.setDiscount(true);
                }

                System.out.println("Do you attend a university?");
                createAccountChoice = s.next();

                if(createAccountChoice.equalsIgnoreCase("yes")) {
                    newAccount.setDisability(true);
                    newAccount.setDiscount(true);
                }

                System.out.println("\n---------------------- Payment Information ----------------------\n");
                Payment payment = new Payment();
                boolean isIncorrect = true;

                while(isIncorrect) {
                    System.out.println("What is your 16 digit credit or debit card number?");
                    cardNumber = s.next();
                    if(payment.setCardNumber(cardNumber)) {
                        isIncorrect = false;
                    }
                }

                isIncorrect = true;
                while(isIncorrect) {
                    System.out.println("What is your expiration month?");
                    expirationMonth = s.nextInt();
                    if(payment.setExpirationMonth(expirationMonth)) {
                        isIncorrect = false;
                    }
                }

                isIncorrect = true;
                while(isIncorrect) {
                    System.out.println("What is your expiration year?");
                    expirationYear = s.nextInt();
                    if(payment.setExpirationYear(expirationYear)) {
                        isIncorrect = false;
                    }
                }

                isIncorrect = true;
                while(isIncorrect) {
                    System.out.println("What is your security code?");
                    securityCode = s.nextInt();
                    if(payment.setSecurityCode(securityCode)) {
                        isIncorrect = false;
                    }
                }

                newAccount.setPayment(payment);
                ad.addAccount(newAccount);

                System.out.println("\nCongratulations! You are now a CineMore Patron. Please Login");
            }

            if (mainChoice == 3) {
                printHelpPage();
            }

            if (mainChoice == 4) {
                System.exit(0);
            }
        }

    }

    public static void printHomePage() {
        System.out.println("\n-------------------------------------------------\n\n" +
                            "\t\t\t Welcome to CineMore\n\n" +
                            "-------------------------------------------------\n\n" +
                            "Please enter a number ...\n" +
                            "1. Login \n" +
                            "2. Create Account \n" +
                            "3. Help \n" +
                            "4. Exit");
    }

    public static void printAccountPage() {
        System.out.println("-------------------------------------------------\n\n" +
                            "\t\t\t\t Welcome " + currentAccount.getUsername() + "\n\n" +
                            "-------------------------------------------------\n\n" +
                            "What would you like to do today?\nPlease enter a number ...\n\n" +
                            "1. Change card information \n" +
                            "2. View ticket purchases \n" +
                            "3. Go to movie page \n" +
                            "4. Delete account \n" +
                            "5. Logout");
    }

    public static void printMoviePage() {
        System.out.println("-------------------------------------------------\n\n" +
                            "███╗░░░███╗░█████╗░██╗░░░██╗██╗███████╗░██████╗\n" +
                "████╗░████║██╔══██╗██║░░░██║██║██╔════╝██╔════╝\n" +
                "██╔████╔██║██║░░██║╚██╗░██╔╝██║█████╗░░╚█████╗░\n" +
                "██║╚██╔╝██║██║░░██║░╚████╔╝░██║██╔══╝░░░╚═══██╗\n" +
                "██║░╚═╝░██║╚█████╔╝░░╚██╔╝░░██║███████╗██████╔╝\n" +
                "╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝╚══════╝╚═════╝░");

    }

    public static void printHelpPage() {

    }

    public static void printOwnerConsole() {
        System.out.println("-------------------------------------------------\n\n" +
                            "\t\tWelcome to the Owner Console" + "\n\n" +
                            "-------------------------------------------------\n\n" +
                            "What would you like to do today?\nPlesae enter a number ...\n\n" +
                            "1. Add a movie\n" +
                            "2. Remove a movie\n" +
                            "3. Search for an account\n" +
                            "4. Remove an account\n" +
                            "5. Make an account admin\n" +
                            "6. Make an account standard\n" +
                            "7. Logout");
    }

    public static void printAdminConsole() {
        System.out.println("-------------------------------------------------\n\n" +
                "\t\tWelcome to the Admin Console" + "\n\n" +
                "-------------------------------------------------\n\n" +
                "What would you like to do today?\nPlesae enter a number ...\n\n" +
                "1. Add a movie\n" +
                "2. Remove a movie\n" +
                "3. Logout");
    }

}
