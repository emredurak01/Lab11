enum Size {
    XS, S, M, L, XL
}

public class Dog extends Pet {

    private final Size size;

    public Dog(int petId, String name, String owner, int age, Size size) {
        super(petId, name, owner, age);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
