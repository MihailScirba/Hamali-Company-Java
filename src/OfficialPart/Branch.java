package OfficialPart;

public class Branch {
    private String name;
    private String city;
    private String street;
    private String phoneNumber;

    public Branch() {
    }

    public Branch(String name, String street) {
        this.name = name;
        this.street = street;
    }

    public Branch(String name, String city, String street, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
