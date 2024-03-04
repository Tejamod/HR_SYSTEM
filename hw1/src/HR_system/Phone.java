package HR_system;

public class Phone {

    private int id;
    private String areaCode;
    private String number;
    private String countryCode;

    public Phone(int id, String areaCode, String number, String countryCode) {
        this.id = id;
        this.areaCode = areaCode;
        this.number = number;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
