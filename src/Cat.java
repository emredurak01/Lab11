public class Cat extends Pet {

    private final String breed;


    public Cat(int petId, String name, String owner, int age, String breed) {
        super(petId, name, owner, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void printHotelInfo() {

    }
}
