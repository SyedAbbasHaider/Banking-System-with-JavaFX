package sample;

import java.text.DecimalFormat;

public class Checking extends Account {
    private boolean directDeposit;

    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        // this refers to the current object in the method which is why it would be on
        // the left side
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
            if (getDirectDeposit() == true) {
                return 0.0;
            } else if (getDirectDeposit() == false) {
                if (this.getBalance() < 1500) {
                    double newBalance = this.getBalance() - 25;
                    return newBalance;
                }
                if (directDeposit) {
                    return 0;
                }

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
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        if (getDirectDeposit() == true) {
            s1 = String.valueOf(getDirectDeposit());
            s1 = "direct deposit account";
            // result = super.toString() + " " + s1;
            result = "Checking" + getHolder().getfName() + " " + getHolder().getlName() + "*" + " $"
                    + decimalFormat.format(getBalance()) + "*" + getDateOpen() + s1;
            return result;

        } else if (getDirectDeposit() == false) {
            // result = super.toString();
            result = "Checking" + getHolder().getfName() + " " + getHolder().getlName() + "*" + " $"
                    + decimalFormat.format(getBalance()) + "*" + getDateOpen();

        }
        // result = super.toString() + " " + s1;
        return result;

    }
}