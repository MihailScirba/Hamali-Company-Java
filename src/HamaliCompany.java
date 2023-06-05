import OfficialPart.*;
import People.Client;
import People.Driver;
import OfficialPart.Route;

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
                5 - show driver's salaries in a certain period
                6 - add new driver
                7 - remove a driver
                8 - show routes
                9 - add new route
                10 - remove a route
                11 - show only clients
                12 - show the amount paid by each client
                13 - show only contracts
                14 - show clients and their contract
                15 - sign new contract for a client
                16 - show info about company
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
            case 3 -> removeBranch(Reader.readBranchName());
            case 4 -> showDrivers();
            case 5 -> showDriversSalaries();
            case 6 -> addDriver();
            case 7 -> removeDriver(Reader.readFirstName(), Reader.readLastName());
            case 8 -> showRoutes();
            case 9 -> addRoute();
            case 10 -> removeRoute(Reader.readRouteName());
            case 11 -> showClients();
            case 12 -> showClientsAmountPaid();
            case 13 -> showContracts();
            case 14 -> showClientsContracts();
            case 15 -> signContract();
            case 16 -> System.out.println(this);
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
        String name = Reader.readBranchName();

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

    private void showDrivers() {
        System.out.println("Drivers: ");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println();
    }

    private void showDriversSalaries() {
        System.out.println("Start date:");
        Calendar startDate = Reader.readDate();
        System.out.println("End date:");
        Calendar endDate = Reader.readDate();

        int sum;
        for (Driver driver : drivers) {
            sum = 0;
            for (Map.Entry<Client, Contract> clientContract : clientsContracts.entrySet()) {
                if (driver.equals(clientContract.getValue().getDriver()) && clientContract.getValue().getDepartureDate().after(startDate) &&
                        clientContract.getValue().getArrivalDate().before(endDate)) {
                    sum += clientContract.getValue().getDriverSalary();
                }
            }
            System.out.println(driver.getFirstName() + " " + driver.getLastName() + " - " + sum + " lei");
        }
    }

    private void addDriver() {
        String firstName = Reader.readFirstName();
        String lastName = Reader.readLastName();

        System.out.print("Enter driver's work experience(years): ");
        int workExperience = scanner.nextInt();

        System.out.print("Enter driver's category: ");
        String category = scanner.next();

        drivers.add(new Driver(firstName, lastName, workExperience, category));
    }

    private void removeDriver(String firstName, String lastName) {
        drivers.removeIf(driver -> driver.getFirstName().equals(firstName) && driver.getLastName().equals(lastName));
    }

    private void showRoutes() {
        System.out.println("Routes: ");
        for (Route route : routes) {
            System.out.println(route);
        }
        System.out.println();
    }

    private void addRoute() {
        String name = Reader.readRouteName();
        System.out.print("Enter distance: ");
        int distance = scanner.nextInt();

        routes.add(new Route(name, distance));
    }

    private void removeRoute(String name) {
        routes.removeIf(route -> route.getName().equals(name));
    }

    private void showClients() {
        System.out.println("Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
        System.out.println();
    }

    private void showClientsAmountPaid() {
        System.out.println("Start date:");
        Calendar startDate = Reader.readDate();
        System.out.println("End date:");
        Calendar endDate = Reader.readDate();

        int sum;
        for (Client client : clients) {
            sum = 0;
            for (Map.Entry<Client, Contract> clientContract : clientsContracts.entrySet()) {
                if (client.equals(clientContract.getKey()) && clientContract.getValue().getDepartureDate().after(startDate) &&
                        clientContract.getValue().getArrivalDate().before(endDate)) {
                    sum += clientContract.getValue().getDriverSalary();
                }
                System.out.println(client.getFirstName() + " " + client.getLastName() + " - " + sum + " lei");
            }
        }
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
        Client client = findClient(Reader.readFirstName(), Reader.readLastName());

        System.out.println("\nChoose the route");
        showRoutes();
        Route route = findRoute(Reader.readRouteName());

        System.out.println("\nChoose driver: ");
        showDrivers();
        Driver driver = findDriver(Reader.readFirstName(), Reader.readLastName());

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

    @Override
    public String toString() {
        return "Name: " + getClass().getSimpleName() +
                "\nNumber of branches: " + branches.size() +
                "\nNumber of clients: " + clients.size() +
                "\nNumber of drivers: " + drivers.size() +
                "\nNumber of routes: " + routes.size() +
                "\nNumber of contracts: " + clientsContracts.size() + "\n";

    }
}