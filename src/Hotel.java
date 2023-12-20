import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private List<Pet> pets;

    public Hotel(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public void reservePet(Pet pet) throws SizeLimitExceededException {
        if (pets.size() >= 5) {
            throw new SizeLimitExceededException("Hotel is full");
        } else if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            Size size = dog.getSize();
            if (size.equals(Size.L) || size.equals(Size.XL)) {
                throw new SizeLimitExceededException("Dog size exceeds limit");
            } else {
                pets.add(pet);
                System.out.println(pet.getName() + " has been reserved.");
            }
        } else {
            pets.add(pet);
            System.out.println(pet.getName() + " has been reserved.");
        }
    }


    public void leavePet(int petId) {
        for (Pet pet : pets) {
            if (pet.getPetId() == petId) {
                pets.remove(pet);
                System.out.println(pet.getName() + " has left the hotel.");
                return;
            }
        }
    }

    public void printHotelInfo() {
        System.out.println("Hotel: " + name);
        System.out.println("Current Residents:");
        for (Pet pet : pets) {
            System.out.println("Pet ID: " + pet.getPetId() +
                    ", Name: " + pet.getName() +
                    ", Owner: " + pet.getOwner() +
                    ", Age: " + pet.getAge());
        }
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
