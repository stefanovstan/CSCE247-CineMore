public class StandardAccount extends Account{
    private boolean isVIP;
    private String paymentOption;
    private double rewardPoints;
    
    public StandardAccount(boolean isVIP, String paymentOptions, double rewardPoints) {
        super();
        this.isVIP = isVIP;
        this.paymentOption = paymentOptions;
        this.rewardPoints = rewardPoints;
    }

    public boolean signUpForVIP(boolean isVIP) {
        return isVIP;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void changePaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }

    public void addStandardPoints(double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
