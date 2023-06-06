import OfficialPart.Branch;
import OfficialPart.Route;
import People.Client;
import People.Driver;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    static Scanner scannerConsole = new Scanner(System.in);
    static Scanner scanner;

    public static LocalDate readDate() {
        int day;
        do {
            System.out.print("  ->Enter the day: ");
            day = scannerConsole.nextInt();
        } while (day > 30 || day < 1);

        int month;
        do {
            System.out.print("  ->Enter the month: ");
            month = scannerConsole.nextInt();
        } while (month > 12 || month < 1);

        System.out.print("  ->Enter the year: ");
        int year = scannerConsole.nextInt();

        return LocalDate.of(year, month, day);
    }

    public static List<Branch> readBranches() {
        List<Branch> branches = new LinkedList<>();
        try {
            scanner = new Scanner(Path.of("src\\InputFiles\\Branches.in"));
            while (scanner.hasNextLine()) {
                branches.add(new Branch(scanner.next(), scanner.next(), scanner.next(), scanner.next()));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return branches;
    }

    public static String readBranchName() {
        System.out.print("Enter branch name: ");
        return scannerConsole.next();
    }

    public static List<Client> readClients() {
        List<Client> clients = new LinkedList<>();
        try {
            scanner = new Scanner(Path.of("src\\InputFiles\\Clients.in"));
            while (scanner.hasNextLine()) {
                clients.add(new Client(scanner.next(), scanner.next(), scanner.next()));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static List<Driver> readDrivers() {
        List<Driver> drivers = new LinkedList<>();
        try {
            scanner = new Scanner(Path.of("src\\InputFiles\\Drivers.in"));
            while (scanner.hasNextLine()) {
                drivers.add(new Driver(scanner.next(), scanner.next(), scanner.nextInt(), scanner.next()));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public static String readFirstName() {
        System.out.print("Enter firstname: ");
        return scannerConsole.next();
    }

    public static String readLastName() {
        System.out.print("Enter lastname: ");
        return scannerConsole.next();
    }

    public static List<Route> readRoutes() {
        List<Route> routes = new LinkedList<>();
        try {
            scanner = new Scanner(Path.of("src\\InputFiles\\Routes.in"));
            while (scanner.hasNextLine()) {
                routes.add(new Route(scanner.next(), scanner.nextInt()));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public static String readRouteName() {
        System.out.print("Enter route name: ");
        return scannerConsole.next();
    }
}