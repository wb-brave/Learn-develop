package thinkinjava.chapter14.pets;

import java.util.*;

public abstract class PetCreator {

    private Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int i = rand.nextInt(types().size());
        try {
            return types().get(i).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> pets = new ArrayList<>();
        Collections.addAll(pets, createArray(size));
        return pets;
    }
}