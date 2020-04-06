public class AccountType {

    private boolean owner;
    private boolean admin;
    private boolean standard;
    private String accountType;

    public AccountType() {
        owner = false;
        admin = false;
        standard = false;
    }

    public AccountType(String accountType) {
        if (accountType.equals("owner")) setOwner();
        if (accountType.equals("admin")) setAdmin();
        if (accountType.equals("standard")) setStandard();
    }

    public void setOwner() {
        this.owner = true;
        accountType = "owner";
    }

    public void setAdmin() {
        this.admin = true;
        accountType = "admin";
    }

    public void setStandard() {
        this.standard = true;
        accountType = "standard";
    }

    public String getAccountType() {
        return accountType;
    }

}
