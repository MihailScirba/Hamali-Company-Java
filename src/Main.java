public class Main {
    public static void main(String[] args) {
        HamaliCompany hamaliCompany = new HamaliCompany(
                Reader.readBranches(),
                Reader.readDrivers(),
                Reader.readClients(),
                Reader.readRoutes());
        hamaliCompany.realizeMenu();
    }
}