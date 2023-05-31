import OfficialPart.*;
import TransportationPart.Driver;
import TransportationPart.Route;

import java.util.*;

public class HamaliCompany implements Menu {
    public static final String RESET = "\033[0m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    Scanner scanner = new Scanner(System.in);
    private List<Branch> branches;
    private List<Driver> drivers;
    private List<Client> clients;
    private List<Route> routes;
    private Map<Client, Contract> clientsContracts = new HashMap<>();

    public HamaliCompany() {
        this.branches = new LinkedList<>();
        this.clients = new LinkedList<>();
        this.drivers = new LinkedList<>();
        this.routes = new LinkedList<>();
    }

    public HamaliCompany(List<Branch> branches, List<Driver> drivers, List<Client> clients, List<Route> routes) {
        this.branches = branches;
        this.drivers = drivers;
        this.clients = clients;
        this.routes = routes;
    }

    public HamaliCompany(List<Branch> branches, List<Driver> drivers, List<Client> clients, List<Route> routes,
                         Map<Client, Contract> clientsContracts) {
        this.branches = branches;
        this.drivers = drivers;
        this.clients = clients;
        this.routes = routes;
        this.clientsContracts = clientsContracts;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Map<Client, Contract> getClientsContracts() {
        return clientsContracts;
    }

    public void setClientsContracts(Map<Client, Contract> clientsContracts) {
        this.clientsContracts = clientsContracts;
    }

    @Override
    public void realizeMenu() {
        while (true) {
            showOfferList();
            if (!realizeChoice(readChoice())) {
                break;
            }
            System.out.println("\n\n");
        }
    }

    @Override
    public void showOfferList() {
        System.out.println(GREEN_BOLD_BRIGHT + """
                0 - exit
                1 - show info about branches
                2 - add new branch
                3 - remove branch
                4 - show info about drivers
                5 - add new driver
                6 - remove a driver
                7 - show routes
                8 - add new route
                9 - remove a route
                10 - show only clients
                11 - show only contracts
                12 - show clients and their contract
                13 - sign new contract for a client
                """ + RESET);
    }

    @Override
    public int readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    @Override
    public boolean realizeChoice(int choice) {
        switch (choice) {
            case 0 -> {
                System.out.println("You've finished with success");
                return false;
            }
            case 1 -> showBranches();
            case 2 -> addBranch();
            case 3 -> removeBranch(readBranchName());
            case 4 -> showDrivers();
            case 5 -> addDriver();
            case 6 -> removeDriver(readFirstName(), readLastName());
            case 7 -> showRoutes();
            case 8 -> addRoute();
            case 9 -> removeRoute(readRouteName());
            case 10 -> showClients();
            case 11 -> showContracts();
            case 12 -> showClientsContracts();
            case 13 -> signContract();
        }
        return true;
    }

    private void showBranches() {
        System.out.println("Branches: ");
        for (Branch branch : branches) {
            System.out.println(branch);
        }
        System.out.println();
    }

    private void addBranch() {
        String name = readBranchName();

        System.out.print("Enter location(city): ");
        String city = scanner.next();

        System.out.print("Enter street: ");
        String street = scanner.next();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();

        branches.add(new Branch(name, city, street, phoneNumber));
    }

    private void removeBranch(String name) {
        branches.removeIf(branch -> branch.getName().equals(name));
    }

    private String readBranchName() {
        System.out.print("Enter branch name: ");
        return scanner.next();
    }

    private void showDrivers() {
        System.out.println("Drivers: ");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println();
    }

    private void addDriver() {
        String firstName = readFirstName();
        String lastName = readLastName();

        System.out.print("Enter driver's work experience(years): ");
        int workExperience = scanner.nextInt();

        System.out.print("Enter driver's category: ");
        String category = scanner.next();

        drivers.add(new Driver(firstName, lastName, workExperience, category));
    }

    private void removeDriver(String firstName, String lastName) {
        drivers.removeIf(driver -> driver.getFirstName().equals(firstName) && driver.getLastName().equals(lastName));
    }

    private String readFirstName() {
        System.out.print("Enter firstname: ");
        return scanner.next();
    }

    private String readLastName() {
        System.out.print("Enter lastname: ");
        return scanner.next();
    }

    private void showRoutes() {
        System.out.println("Routes: ");
        for (Route route : routes) {
            System.out.println(route);
        }
        System.out.println();
    }

    private void addRoute() {
        String name = readRouteName();
        System.out.print("Enter distance: ");
        int distance = scanner.nextInt();

        routes.add(new Route(name, distance));
    }

    private void removeRoute(String name) {
        routes.removeIf(route -> route.getName().equals(name));
    }

    private String readRouteName() {
        System.out.print("Enter route name: ");
        return scanner.next();
    }

    private void showClients() {
        System.out.println("Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        System.out.println();
    }

    private void showContracts() {
        System.out.print("Contracts:");
        for (Contract contract : clientsContracts.values()) {
            System.out.println(contract);
        }
        System.out.println();
    }

    private void showClientsContracts() {
        System.out.println("Clients and their contracts:");
        for (Map.Entry<Client, Contract> clientContract : clientsContracts.entrySet()) {
            System.out.println(clientContract.getKey());
            System.out.println(clientContract.getValue());
        }
    }

    private void signContract() {
        System.out.println("Which client will sign new contract?");
        showClients();
        Client client = findClient(readFirstName(), readLastName());

        System.out.println("\nChoose the route");
        showRoutes();
        Route route = findRoute(readRouteName());

        System.out.println("\nChoose driver: ");
        showDrivers();
        Driver driver = findDriver(readFirstName(), readLastName());

        System.out.println("\nEnter departure date: ");
        Calendar departureDate = Reader.readDate();


        System.out.println("\nEnter arrival date: ");
        Calendar arrivalDate = Reader.readDate();

        System.out.print("\nEnter price per km: ");
        double kmPrice = scanner.nextDouble();

        clientsContracts.put(client, new Contract(route, departureDate, arrivalDate, driver, kmPrice));
    }

    private Client findClient(String firstName, String lastName) {
        for (Client client : clients) {
            if (client.getFirstName().equals(firstName) && client.getLastName().equals(lastName)) {
                return client;
            }
        }
        return clients.get(0);
    }

    private Route findRoute(String name) {
        for (Route route : routes) {
            if (route.getName().equals(name)) {
                return route;
            }
        }
        return routes.get(0);
    }

    private Driver findDriver(String firstName, String lastName) {
        for (Driver driver : drivers) {
            if (driver.getFirstName().equals(firstName) && driver.getLastName().equals(lastName)) {
                return driver;
            }
        }
        return drivers.get(0);
    }
}
