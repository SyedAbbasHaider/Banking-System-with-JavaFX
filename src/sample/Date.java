package sample;/*
this is a date class, managing the date associated with the account
@author Syed Abbas Haider, Syed Fazeel Haider
 */
import java.text.DecimalFormat;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /*
    Parameterized constructor
    @param date
     */
    public Date(String date) {
        String newdate[] = date.split("/");
        this.year = Integer.parseInt(newdate[2]);
        this.month = Integer.parseInt(newdate[0]);
        this.day = Integer.parseInt(newdate[1]);
    }

    // create three Date constructors

    /*
    set method for year
    @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /*
    set method for month
    @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /*
    set method for day
    @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /*
    get method for day
    @return day
     */
    public int getDay() {
        return this.day;
    }

    /*
    get method for month
    @return month
     */
    public int getMonth() {
        return this.month;
    }

    /*
    get method for year
    @return year
     */
    public int getYear() {
        return this.year;
    }

    /*
    compareTo to compare date
    @param date
    @return 0, 1, -1
     */
    @Override
    public int compareTo(Date date) {
        if (!date.isValid()) {
            return -1;
        }
        if (this.day == date.day && this.year == date.year && this.month == date.month) {
            return 1;
        }

        return 0;
    }

    /*
    toString method
     */
    public String toString() {
        String date;
        DecimalFormat duos = new DecimalFormat("00");
        DecimalFormat quads = new DecimalFormat("0000");
        date = "" + duos.format(this.month) + "/" + duos.format(this.day) + "/" + quads.format(this.year);
        return date;
    }

    /*
    method to test date validity
    @return true if correct
     */
    public boolean isValid() {
        if (this.day < 1 || this.month > 12 || this.day > 31 || this.month < 1) {
            return false;
        }

        int[] sMonths = { 4, 6, 9, 11 };
        for (int sMonth : sMonths) {
            if (month == sMonth && day > 30) {
                return false;
            }
        }

        if (month == 2) {
            if (isLeapYear()) {
                if (day > 29) {
                    return false;
                } else if (day > 28) {
                    return false;
                }
            }
            return true;

        }
        return true;
    }

    /*
    check if the the year is a leap year
    @return true is leap year
     */
    public boolean isLeapYear() {
        boolean leap = false;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else {
                leap = true;
            }
        } else {
            leap = false;
        }
        return leap;

    }

    /*
    set method fot JUnit testing
    @param month
    @param day
    @param year
     */
    public void set(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
}
