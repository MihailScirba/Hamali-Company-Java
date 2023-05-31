package TransportationPart;

public class Driver {
    private String firstName;
    private String lastName;
    private int workExperience;
    private String category;

    public Driver() {
    }

    public Driver(String firstName, String lastName, int workExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
    }

    public Driver(String firstName, String lastName, int workExperience, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workExperience = workExperience;
        this.category = category;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workExperience=" + workExperience +
                ", category='" + category + '\'' +
                '}';
    }
}
