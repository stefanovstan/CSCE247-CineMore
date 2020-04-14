public class testingAccountCreation {
    public static void main(String[] args){
        //creating a new account

        Account testAcc = new Account();

        //testing default values (should return null for usr & pass and false for all boolean values)

        System.out.println(testAcc.getUsername());

        System.out.println(testAcc.getPassword());

        System.out.println(testAcc.isMilitary());

        System.out.println(testAcc.isSenior());

        System.out.println(testAcc.isTeacher());

        System.out.println(testAcc.isDisability());

        System.out.println(testAcc.isStudent());

        System.out.println(testAcc.hasDiscount());

        //account type needs value
        //set type to standard to test

        AccountType testAccType = new AccountType("standard");

        testAcc.setAccountType(testAccType);

        //should return standard

        System.out.println(testAcc.getAccountType());
    }
}
