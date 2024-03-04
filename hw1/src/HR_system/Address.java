package HR_system;

public class Address {

    private int id;
    private String zip;
    private String country;
    private String state;
    private String city;
    private String line1;
    private String line2;

    public Address(int id, String zip, String country, String state, String city, String line1, String line2) {
        this.id = id;
        this.zip = zip;
        this.country = country;
        this.state = state;
        this.city = city;
        this.line1 = line1;
        this.line2 = line2;
    }

    public int getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }
}
