package sample;

import java.text.DecimalFormat;

public class MoneyMarket extends Account {
    private int withdrawals;

    public MoneyMarket(Profile holder, Double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        // this.withdrawals = 0;
    }

    public MoneyMarket(Profile holder) {
        super(holder);
    }

    public MoneyMarket(Profile holder, double balance) {
        super(holder, balance);
    }

    // public void getwithcount(){
    // AccountDatabase obj = new AccountDatabase();
    // obj.withdrawal(Profile holder, amount)
    // }

    public double monthlyFee() {
        try {
            if (this.getBalance() < 2500) {
                double newBalance = this.getBalance() - 12;
                return newBalance;
            }

        } catch (Exception e) {
            System.out.println("Exception error");
        }
        return 0;

    }

    public double monthlyInterest() {

        try {
            return (this.getBalance() * 0.054166) / 100;
        } catch (Exception e) {
            System.out.println("Number Format Exception");
        }
        return 0;

    }
    @Override
    public String toString() {
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String result = "";
        String s1 = "";
        s1 = "*# of withdrawls *";
        // result = super.toString() + " " + s1;
        result = "Money Market" + getHolder().getfName() + " " + getHolder().getlName() + "*" + " $"
                + decimalFormat.format(getBalance()) + "*" + getDateOpen() + s1;
        return result;

    }
}