package sample;

/*
 * This is a profile class  holding info of users
 * @author Syed Abbas Haider (NetID: sah300), Syed Fazeel Haider (NetID:sfh55)
 */
public class Profile {
    private String fname;
    private String lname;

    /*
    this is a parameterized constructor
    @param fname
    @param lname
     */
    public Profile(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    /*
    @return first and last name
     */
    public String toString() {
        return fname + " " + lname;
    }

    /*
    @return returns last name
     */
    public String getfName() {
        return this.fname;
    }

    /*
    @param fname
     */
    public void setfName(String fname) {
        this.fname = fname;
    }

    /*
    @return last name
     */
    public String getlName() {
        return this.lname;
    }

    /*
    @param lname
     */
    public void setlName(String lname) {
        this.lname = lname;
    }

}