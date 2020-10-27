package sample;

/*
* This is a Account Abstarct Class.
* It defines features for all Accounts types
* @author Syed Abbas Haider (NetID: sah300), Syed Fazeel Haider (NetID:sfh55)
 */
public abstract class Account {
    private Profile holder;
    private double balance;
    private Date dateOpen;

    /*
    Parameterized Constructor
    @param holder
    @param balance
    @param dateOpen
     */
    public Account(Profile holder, double balance, Date dateOpen) {
        this.holder = holder;
        this.balance = balance;
        this.dateOpen = dateOpen;
    }

    /*
    @param holder
     */
    public Account(Profile holder) {
        this.holder = holder;
    }

    /*
    @param holder
    @param balance
     */
    public Account(Profile holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    /*
    @param holder
     */
    public void setHolder(Profile holder) {
        this.holder = holder;
    }

    /*
    @param dateOpen
     */
    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    /*
    @return get first name and last name
     */
    public Profile getHolder() {
        return this.holder;
    }

    /*
    @return get date
     */
    public Date getDateOpen() {
        return this.dateOpen;
    }

    /*
    @return get balance
     */
    public double getBalance() {
        return this.balance;
    }

    /*
    @param n
     */
    public void setBalance(double n) {
        balance = n;
    }

    /*
    @param amount
     */
    public void debit(double amount) { // decrease the balance by amount
        double newbalance = this.balance - amount;
        setBalance(newbalance);
    }

    /*
    @param amount
     */
    public void credit(double amount) { // increase the balance by amount
        double newbalance = this.balance + amount;
        setBalance(newbalance);
    }

    public String toString() {
        return holder + " " + balance + " " + dateOpen;

    }

    /*
    @param temp
    @return value if equals
     */
    // @Override
    public boolean equals(Account temp) {
        // for (Account account : accounts) {
        if ((temp.getHolder().getfName()).compareTo(this.getHolder().getfName()) == 0) {
            if ((temp.getHolder().getlName()).compareTo(this.getHolder().getlName()) == 0) {
                if ((temp.getClass().getName()).compareTo(this.getClass().getName()) == 0) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public abstract double monthlyInterest();

    public abstract double monthlyFee();
}
