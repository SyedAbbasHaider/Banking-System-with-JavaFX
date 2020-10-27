package sample;

/*
this is money market class for another account type
@author Syed Abbas Haider, Syed Fazeel Haider
 */
public class MoneyMarket extends Account {
    private int withdrawals;

    /*
    parameterized constructors
    @param holder
    @param balance
    @param dateOpen
     */
    public MoneyMarket(Profile holder, Double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        this.withdrawals = 0;
    }

    /*
    @param holder
     */
    public MoneyMarket(Profile holder) {
        super(holder);
    }

    /*
    @param holder
    @param balance
     */
    public MoneyMarket(Profile holder, double balance) {
        super(holder, balance);
    }

    /*
    calculate monthly fee
    @return updated balance
     */
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

    /*
    calculate monthly interset
    @return updated balance
     */
    public double monthlyInterest() {

        try {
            return (this.getBalance() * 0.054166) / 100;
        } catch (Exception e) {
            System.out.println("Number Format Exception");
        }
        return 0;

    }
}
