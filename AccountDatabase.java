public class AccountDatabase extends Account{
    public int DATABASE_LENGTH;
    public int count;
    public Account[] Accounts;

    public AccountDatabase() {
        count = 0;
        DATABASE_LENGTH = 100;
        Accounts = new Account[DATABASE_LENGTH];
    }

    public void addAccount (Account a) {
        if (Accounts.length == DATABASE_LENGTH-1) {
            growArray(Accounts)[count] = a;

        } else {
            Accounts[count] = a;
        }

        count++;
    }

    public void removeAccount(Account a) {
        for (Account i : Accounts) {
            if (i == a) {
                i = null;
            }
        }
    }

    public void printAccountDatabase() {
        for (Account a : Accounts) {
            System.out.println(
                    "Account Username    : " + a.getUsername() + " \n" +
                            "Account Password   : " + a.getPassword() + "\n" +
                            "Account Military Status : " + a.isMilitary() + "\n" +
                            "Account Senior Status : " + a.isSenior()+ "\n" +
                            "Account Teacher Status : " + a.isTeacher()+ "\n" +
                            "Account Disability Status : " + a.isDisability()+ "\n");
        }
    }

    public Account[] growArray(Account[] a) {
        DATABASE_LENGTH *= 2;
        Account[] newArray = new Account[DATABASE_LENGTH];
        newArray = a.clone();
        return newArray;
    }
}
