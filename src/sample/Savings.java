package sample;

import java.text.DecimalFormat;

public class Savings extends Account {

    private boolean isLoyal;

    public Savings(Profile holder, Double balance, Date dateOpened, boolean isLoyal) {
        super(holder, balance, dateOpened);
        this.isLoyal = isLoyal;

    }

    public boolean getisLoyal() {
        return isLoyal;
    }

    public Savings(Profile holder) {
        super(holder);
    }

    public Savings(Profile holder, double balance) {
        super(holder, balance);
    }

    public double monthlyInterest() {
        try {
            return (this.getBalance() * 0.02) / 100;

        } catch (Exception e) {
            System.out.println("Number Format Exception");
        }
        return 0;
    }

    public double monthlyFee() {
        try {
            if (this.getBalance() < 300) {
                return this.getBalance() - 5;
            }
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

        if (getisLoyal() == true) {
            s1 = String.valueOf(getisLoyal());
            s1 = "special Savings account";
            // result = super.toString() + " " + s1;
            result = "Savings" + getHolder().getfName() + " " + getHolder().getlName() + "*" + " $"
                    + decimalFormat.format(getBalance()) + "*" + getDateOpen() + s1;
            return result;

        } else if (getisLoyal() == false) {
            // result = super.toString();
            result = "Savings" + getHolder().getfName() + " " + getHolder().getlName() + "*" + " $"
                    + decimalFormat.format(getBalance()) + "*" + getDateOpen();

        }
        // result = super.toString() + " " + s1;
        return result;

    }
}