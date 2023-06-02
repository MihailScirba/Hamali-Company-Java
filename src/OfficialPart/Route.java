package TransportationPart;

public class Route {
    private String name;
    private int distance;

    public Route() {
    }

    public Route(int distance) {
        this.distance = distance;
    }

    public Route(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
