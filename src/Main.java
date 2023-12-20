import javax.naming.SizeLimitExceededException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Hotel object
        Hotel hotel = new Hotel("Ispartalıhjadoğlu Pansiyon");
        int id = 1;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to " + hotel.getName() + " Pet Hotel:");
            System.out.println("1) Reserve Pet");
            System.out.println("2) Take your Pet");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Reserving a pet...");
                    System.out.println("Enter pet type (1 for Dog, 2 for Cat):");
                    int petTypeChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (petTypeChoice == 1) {
                        System.out.print("Enter pet name: ");
                        String petName = scanner.nextLine();

                        System.out.print("Enter owner's name: ");
                        String ownerName = scanner.nextLine();

                        System.out.print("Enter pet age: ");
                        int petAge = scanner.nextInt();

                        System.out.print("Enter dog size (XS, S, M, L, XL): ");
                        Size dogSize = Size.valueOf(scanner.next());

                        Pet newDog = new Dog(id, petName, ownerName, petAge, dogSize);
                        try {
                            hotel.reservePet(newDog);
                            System.out.println("Your pet id is "+id);
                            id++;
                        } catch (SizeLimitExceededException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else if (petTypeChoice == 2) {
                        System.out.print("Enter pet name: ");
                        String petName = scanner.nextLine();

                        System.out.print("Enter owner's name: ");
                        String ownerName = scanner.nextLine();

                        System.out.print("Enter pet age: ");
                        int petAge = scanner.nextInt();

                        System.out.print("Enter cat breed: ");
                        String catBreed = scanner.next();

                        Pet newCat = new Cat(id, petName, ownerName, petAge, catBreed);

                        try {
                            hotel.reservePet(newCat);
                            id++;
                        } catch (SizeLimitExceededException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid choice for pet type.");
                    }
                    break;
                case 2:
                    System.out.println("Taking your pet...");
                    System.out.println("Enter pet id: ");
                    int petId = scanner.nextInt();
                    hotel.leavePet(petId);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }

    }


}
