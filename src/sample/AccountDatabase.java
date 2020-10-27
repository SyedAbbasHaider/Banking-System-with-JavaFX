package sample;/*
this is a account database class, This class
allow us to work in the account
@author Syed Abbas Haider, Syed Fazeel Haider
 */

import java.text.DecimalFormat;

public class AccountDatabase {
    private Account[] accounts;
    private int size;

    /*
    initializing array
     */
    public AccountDatabase() {
        accounts = new Account[5];
        size = 0;
    }

    /*
    finding the index of the required account
    @param account
    @return index of the account
     */
    private int find(Account account) {
        Account temp = account;
        for (int i = 0; i < size; i++) {
            // .equals here
            if (temp.equals(this.accounts[i])) {
                return i;
            }
        }
        return -1;
    }

    /*
    grow the array once filled completely
     */
    private void grow() {
        Account acc[] = new Account[size + 5];
        for (int i = 0; i < size; i++) {
            acc[i] = accounts[i];
        }
        accounts = acc.clone();

    }

    /*
    adding account into the array
    @param account
    @return false if account exists
     */
    public boolean add(Account account) {
        if (find(account) == -1) {
            if (size == accounts.length) {
                grow();
                accounts[size] = account;
                size++;
                return true;
            } else {
                accounts[size] = account;
                size++;
                return true;
            }
        }
        System.out.println("Account already exists!");
        return false;
    }


    /*
    remove account from the array
    @param account
    @return false if account doesn't exist
     */
    public boolean remove(Account account) {
        try {
            if (size == 0) {
                System.out.println("Database is Empty");
                return false;
            }
            int index = find(account);
            if (index != -1) {
                accounts[index] = accounts[size - 1];
                accounts[size - 1] = null;
                size--;
                return true;
            }
        } catch (

                Exception e) {
            System.out.println("Input Mismatch Exception");
        }
        return false;

    }


    /*
    deposit balance in the account
    @param acc
    @param amount
    @return true if successful
     */
    public boolean deposit(Account acc, double amount) {
        for (int i = 0; i < size; i++) {
            if (acc.equals(accounts[i])) {
                accounts[i].credit(amount);
            }
        }

        return false;

    }

    /*
    withdraw amount from the accounts balance
    @param acc
    @param amount
    @return 0: successful, 1:insufficient funds, -1: account doesn't exist
     */
    public int withdrawal(Account acc, double amount) {
        int widcounter = 0;
        for (int i = 0; i < size; i++) {
            if (acc.equals(accounts[i])) {
                if (accounts[i].getBalance() < amount) {
                    return 1;
                } else {
                    accounts[i].debit(amount);
                    widcounter++;
                    return 0;
                }
            }
            if (!acc.equals(accounts[i])) {
                return -1;
            }
        }
        return widcounter;

    }

    /*
    sort by date open
     */
    private void sortByDateOpen() {
        // Account max;
        // int index = 0;
        int n = accounts.length;
        for (int i = 0; i < n - 1; i++) {
            if (accounts[i] == null) { //checking if i hit null in array
                break;
            }
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (accounts[j] == null) { //checking if i hit null in array
                    break;
                } else if (accounts[j].getDateOpen().getYear() < accounts[i].getDateOpen().getYear()) {
                    min_idx = j;
                } else if (accounts[j].getDateOpen().getYear() == accounts[i].getDateOpen().getYear()
                        && accounts[j].getDateOpen().getMonth() < accounts[i].getDateOpen().getMonth()) {
                    // max = accounts[j];
                    min_idx = j;
                } else if (accounts[j].getDateOpen().getYear() == accounts[i].getDateOpen().getYear()
                        && accounts[j].getDateOpen().getMonth() == accounts[i].getDateOpen().getMonth()
                        && accounts[j].getDateOpen().getDay() < accounts[i].getDateOpen().getDay()) {
                    min_idx = j;
                }

            }
            Account temp = accounts[min_idx];
            accounts[min_idx] = accounts[i];
            accounts[i] = temp;
        }

    }

    /*
    sort by Last name
     */
    private void sortByLastName() {
        //use compareTO method in here
        Account min;
        int index = size - 1;
        for (int i = 0; i < size; i++) {
            min = accounts[i];
            index = -1;
            for (int j = i + 1; j < size; j++) {
                if (min.getHolder().getlName().equals(accounts[j].getHolder().getlName())) {
                    min = accounts[j];
                    index = j;
                }
            }
            if (index != -1) {
                Account temp = accounts[index];
                accounts[index] = accounts[i];
                accounts[i] = temp;
            }
        }
    }

    /*
    Print by date open order
     */
    public void printByDateOpen() {
        sortByDateOpen();
        DecimalFormat f = new DecimalFormat("#.##");
        int i = 0;
        String str;
        String str1;

        for (i = 0; i < size; i++) {

            if (accounts[i] instanceof Checking) {
                System.out.println(
                        "*Checking*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);

            }
            if (accounts[i] instanceof Savings) {
                System.out.println(
                        "*Savings*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);
            }
            if (accounts[i] instanceof MoneyMarket) {
                System.out.println(
                        "*Money Market*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);
            }
            System.out.println();
        }

    }


    public void printByLastName() {
        sortByLastName();
        DecimalFormat f = new DecimalFormat("#.##");
        int i = 0;
        String str;
        String str1;

        for (i = 0; i < size; i++) {

            if (accounts[i] instanceof Checking) {
                System.out.println(
                        "*Checking*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);

            }
            if (accounts[i] instanceof Savings) {
                System.out.println(
                        "*Savings*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);
            }
            if (accounts[i] instanceof MoneyMarket) {
                System.out.println(
                        "*Money Market*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen());
                str = f.format(accounts[i].monthlyInterest());
                str1 = f.format(accounts[i].monthlyFee());
                System.out.println("-interest: $" + str);
                System.out.println("-fee: $" + str1);
            }
            System.out.println();
        }

    }


    /*
    print all accounts
     */
    public String printAccounts() {
        int i = 0;
        //System.out.println("--Listing accounts in the database--");
        String result = null;
        for (i = 0; i < size; i++) {
            if (accounts[i] instanceof Checking) {
                result =
                        "*Checking*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen();
                    //add return statements inside all if statements
            }

            if (accounts[i] instanceof Savings) {
                result =
                        "*Savings*" + accounts[i].getHolder().getfName() + " " + accounts[i].getHolder().getlName()
                                + "*" + " $" + accounts[i].getBalance() + "*" + " " + accounts[i].getDateOpen();
            }
            if (accounts[i] instanceof MoneyMarket) {
                result = "*Money Market*" + accounts[i].getHolder().getfName() + " "
                        + accounts[i].getHolder().getlName() + "*" + " $" + accounts[i].getBalance() + "*" + " "
                        + accounts[i].getDateOpen() + "*" + "" + "*";
            }

        }
        return result;
    }


}
