public class VIPAccount extends Account {
    public static final double STANDARD_POINTS_INCRE = 10;
    private boolean isVIP;
    private String paymentOption;
    private double rewardPoints;

    public VIPAccount() {
        isVIP = true;
        paymentOption = "";
        rewardPoints = 0;
    }

    public VIPAccount(Account a, boolean isVIP, String paymentOption, double rewardPoints) {
        super();
        this.isVIP = isVIP;
        this.paymentOption = paymentOption;
        this.rewardPoints = rewardPoints;

    }

    public void showVIPBenefits(boolean isVIP) {
        if(isVIP == true) {
            System.out.println("Congrats! You are a VIP member!");
        } else {
            System.out.println("You are not a VIP member");
        }
    }

    public String getPaymentOption(String paymentOption) {
        return paymentOption;
    }

    public String changePaymentOption(String paymentOption) {

    }

    public double getRewardPoints(double rewardPoints) {
        return rewardPoints;
    }

    public void addStandardPoints(double rewardPoints) {
        rewardPoints += STANDARD_POINTS_INCRE;
    }

}
