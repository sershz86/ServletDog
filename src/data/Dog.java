package data;

public class Dog {
    public static int counter = 1;
    private final int ID;
    private String name;
    private String type;

    public Dog() {

        this.ID = counter;
        this.name = "testName" + counter;
        this.type = "testType" + counter;
        counter++;
    }

    public Dog(String name, String type) {
        this.ID = counter;
        counter++;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + ";" + type;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}