import java.util.Scanner;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter specifications for the first computer:");
        System.out.print("CPU: ");
        String cpu1 = scanner.nextLine();
        System.out.print("RAM: ");
        String ram1 = scanner.nextLine();
        System.out.print("Storage: ");
        String storage1 = scanner.nextLine();

        Computer computer1 = new Computer.Builder()
                .setCPU(cpu1)
                .setRAM(ram1)
                .setStorage(storage1)
                .build();

        // Adding Second Specification
        System.out.println("Enter specifications for the second computer:");
        System.out.print("CPU: ");
        String cpu2 = scanner.nextLine();
        System.out.print("RAM: ");
        String ram2 = scanner.nextLine();
        System.out.print("Storage: ");
        String storage2 = scanner.nextLine();

        Computer computer2 = new Computer.Builder()
                .setCPU(cpu2)
                .setRAM(ram2)
                .setStorage(storage2)
                .build();

        // Displaying the computer specifications Showing attributes of Both The computers
        System.out.println("First Computer: " + computer1);
        System.out.println("Second Computer: " + computer2);

        scanner.close();
    }
}