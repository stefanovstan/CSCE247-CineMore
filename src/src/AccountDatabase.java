import java.util.ArrayList;

public class AccountDatabase extends Account {

    public ArrayList<Account> Accounts;

    public AccountDatabase() {
        Accounts = new ArrayList<>();
    }

    public void addAccount(Account a) {
        Accounts.add(a);
    }

    public void removeAccount(Account a) {
        Accounts.remove(a);
    }

    public boolean isAccount(String username, String password) {
        for (Account i : Accounts) {
            if (i == null) {
                return false;
            }
            if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean usernameAvailable(String username) {
        for (Account i : Accounts) {
            if (i == null) {
                return true;
            }

            if (i.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public Account findAccount(String username) {
        for (Account i : Accounts) {
            if (i.getUsername().equals(username)) {
                return i;
            }
        }
        return null;
    }

    public void printAccount(String username) {
        for (Account a : Accounts) {
            if (a.getUsername().equals(username)) {
                System.out.println("-------------------------------------------------\n" +
                        "Account Username          : " + a.getUsername() + " \n" +
                        "Account Password          : " + a.getPassword() + "\n" +
                        "Account Military Status   : " + a.isMilitary() + "\n" +
                        "Account Senior Status     : " + a.isSenior() + "\n" +
                        "Account Teacher Status    : " + a.isTeacher() + "\n" +
                        "Account Disability Status : " + a.isDisability() + "\n" +
                        "Account Student Status    : " + a.isStudent() + "\n" +
                        "Account Type              : " + a.getAccountType() + "\n" +
                        "-------------------------------------------------\n\n");
            }
        }
    }
}