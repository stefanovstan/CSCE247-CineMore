public class testingAccountDatabase {
    public static void main(String[] args){
        //object creation for testing
        AccountDatabase testAccounts = new AccountDatabase();

        Account testAccount = new Account();

        AccountType testAccountType = new AccountType("standard");

        testAccount.setAccountType(testAccountType);

        testAccounts.addAccount(testAccount);
        //testing default parameters
        for(Account a : testAccounts.Accounts){
            //return an empty string
            System.out.println(a.getUsername());
            //return an empty string
            System.out.println(a.getPassword());
            //return standard
            System.out.println(a.getAccountType());
            //return false
            System.out.println(a.isDisability());
            //return false
            System.out.println(a.isMilitary());
            //return false
            System.out.println(a.isSenior());
            //return false
            System.out.println(a.isStudent());
            //return false
            System.out.println(a.isTeacher());
            //return false
            System.out.println(a.hasDiscount());
            //return memory address of testAccount
            System.out.println(testAccounts.findAccount(a.getUsername()));
            //should return true
            System.out.println(testAccounts.usernameAvailable("Andrew"));
            //should return tur
            System.out.println(testAccounts.isAccount(a.getUsername(),a.getPassword()));
        }
        //should be the same as above except the last three 
        testAccounts.printAccount(testAccount.getUsername());

        //should delete testAccount then return null
        testAccounts.removeAccount(testAccount);
        testAccounts.findAccount(testAccount.getUsername());
    }
}
