package OfficialPart;

import People.Driver;

import java.util.Calendar;

public class Contract {
    private Route route;
    private Calendar departureDate;
    private Calendar arrivalDate;
    private Driver driver;
    private double kmPrice;

    public Contract() {
    }

    public Contract(Route route, Driver driver, double kmPrice) {
        this.route = route;
        this.driver = driver;
        this.kmPrice = kmPrice;
    }

    public Contract(Route route, Calendar departureDate, Calendar arrivalDate, Driver driver, double kmPrice) {
        this.route = route;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.driver = driver;
        this.kmPrice = kmPrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Calendar departureDate) {
        this.departureDate = departureDate;
    }

    public Calendar getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Calendar arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(double kmPrice) {
        this.kmPrice = kmPrice;
    }

    public double getDriverSalary() {
        if (driver.getWorkExperience() > 3 && driver.getWorkExperience() < 8) {
            return route.getDistance() * kmPrice * 1.5D;
        } else if (driver.getWorkExperience() >= 6) {
            return route.getDistance() * kmPrice * 2D;
        }
        return route.getDistance() * kmPrice;
    }

    @Override
    public String toString() {
        return "Contract{\n\t" +
                route +
                "\n\tdeparture date=" + departureDate.get(Calendar.DAY_OF_MONTH) + "." +
                departureDate.get(Calendar.MONTH) + "." +
                departureDate.get(Calendar.YEAR) +
                ", arrival date=" + arrivalDate.get(Calendar.DAY_OF_MONTH) + "." +
                arrivalDate.get(Calendar.MONTH) + "." +
                arrivalDate.get(Calendar.YEAR) +
                "\n\t" + driver +
                "\n\tkmPrice=" + kmPrice +
                "\nDriver salary: " + getDriverSalary() +
                "\n}";
    }
}
