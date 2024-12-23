import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<PrinterAdapter> printers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPrinter Management System");
            System.out.println("1. Add Printer");
            System.out.println("2. Print");
            System.out.println("3. List Printers");
            System.out.println("4. Send to Maintenance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPrinter();
                case 2 -> print();
                case 3 -> listPrinters();
                case 4 -> sendToMaintenance();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addPrinter() {
        System.out.print("Enter printer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial ink level (%): ");
        double inkLevel = scanner.nextDouble();
        scanner.nextLine();

        Printer printer = new Printer(name, inkLevel);
        printers.add(new GenericPrinterAdapter(printer));
        System.out.println("Printer added successfully.");
    }

    private static void print() {
        if (printers.isEmpty()) {
            System.out.println("No printers available.");
            return;
        }

        listPrinters();
        System.out.print("Select printer number to print: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > printers.size()) {
            System.out.println("Invalid printer number.");
            return;
        }

        PrinterAdapter selectedPrinter = printers.get(index - 1);

        System.out.print("Choose print type (1: Color, 2: Black-and-White): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        if (type != 1 && type != 2) {
            System.out.println("Invalid print type.");
            return;
        }

        selectedPrinter.print(type == 1);
    }

    private static void listPrinters() {
        if (printers.isEmpty()) {
            System.out.println("No printers available.");
            return;
        }

        System.out.println("\nAvailable Printers:");
        for (int i = 0; i < printers.size(); i++) {
            PrinterAdapter printer = printers.get(i);
            System.out.printf("%d. %s - State: %s, Ink: %.2f%%, Usage: %d\n",
                    i + 1, printer.getName(), printer.getState(), printer.getInkLevel(), printer.getUsage());
        }
    }

    private static void sendToMaintenance() {
        if (printers.isEmpty()) {
            System.out.println("No printers available.");
            return;
        }

        listPrinters();
        System.out.print("Select printer number to send to maintenance: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > printers.size()) {
            System.out.println("Invalid printer number.");
            return;
        }

        printers.get(index - 1).sendToMaintenance();
    }
}
