package sample;

public class Checking extends Account {
    private boolean directDeposit;

    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        //directDeposit = this.directDeposit;
        this.directDeposit = directDeposit;
    }

    public Checking(Profile holder) {
        super(holder);
    }

    // this is for DC
    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }

    public boolean getDirectDeposit() {
        return directDeposit;
    }

    public double monthlyFee() {
        try {
            if (this.getBalance() < 1500) {
                double newBalance = this.getBalance() - 25;
                return newBalance;
            }

        } catch (Exception e) {
            System.out.println("Exception error");
        }
        return 0;

    }

    public double monthlyInterest() {

        try {
            double newBalance = (this.getBalance() * 0.00416) / 100;
            return newBalance;
        } catch (Exception e) {
            System.out.println("Number Format Exception");
        }
        return 0;

    }

    @Override
    public String toString() {

        String result = "";
        String s1 = "";

        if (getDirectDeposit() == true) {
            s1 = String.valueOf(getDirectDeposit());
            s1 = "*direct deposit account*";
            result = super.toString() + " " + s1;

        } else if (getDirectDeposit() == false) {
            result = super.toString();
        }
        // result = super.toString() + " " + s1;
        return result;
    }

}
