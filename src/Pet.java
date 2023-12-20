public abstract class Pet {
    private final int petId;
    private final String name;
    private final String owner;
    private final int age;

    public Pet(int petId, String name, String owner, int age) {
        this.petId = petId;
        this.name = name;
        this.owner = owner;
        this.age = age;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }
}
