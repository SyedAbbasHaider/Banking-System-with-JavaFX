package sample;

/*
this is account type of savings
@author Syed Abbas Haider, Syed Fazeel Haider
 */
public class Savings extends Account {

    /*
    flag
     */
    private boolean isLoyal;

    /*
    parameterized constructor
    @param holder
    @param balance
    @param dateOpened
    @param isLoyal
     */
    public Savings(Profile holder, Double balance, Date dateOpened, boolean isLoyal) {
        super(holder, balance, dateOpened);

    }

    /*
    @param holder
     */
    public Savings(Profile holder) {
        super(holder);
    }

    /*
    @param holder
    @param balance
     */
    public Savings(Profile holder, double balance) {
        super(holder, balance);
    }

    /*
    calculate monthly interest
    @return updated balance
     */
    public double monthlyInterest() {
        try {
            return (this.getBalance() * 0.02) / 100;

        } catch (Exception e) {
            System.out.println("Number Format Exception");
        }
        return 0;
    }

    /*
    calculate monthly fee
    @return updated balance
     */
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
}
