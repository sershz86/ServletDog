package data;

import java.util.ArrayList;
import java.util.List;

public class DogManage {
    private static DogManage instance;
    private List<Dog> dogs;

    private DogManage() {
        dogs = new ArrayList<>();
        dogs.add(new Dog());
    }

    public static DogManage getInstance() {
        if (instance == null) {
            instance = new DogManage();
        }
        return instance;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public Dog getDogById(int id) {
        return dogs.stream()
                .filter(dog -> dog.getID() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(String name, String type) {
        dogs.add(new Dog(name, type));
    }

    public void update(int id, String name, String type) {
        dogs.forEach(dog -> updateDog(dog, id, name, type));
    }

    private void updateDog(Dog dog, int id, String name, String type) {
        if (id == dog.getID()) {
            dog.setName(name);
            dog.setType(type);
        }
    }
}