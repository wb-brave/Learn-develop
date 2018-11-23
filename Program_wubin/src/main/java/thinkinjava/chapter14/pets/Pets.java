package thinkinjava.chapter14.pets;

import java.util.ArrayList;

public class Pets {

    public static final PetCreator CREATOR = PetCreatorFactories.petFactories.get(2).create();

    public static Pet randomPet() {
        return CREATOR.randomPet();
    }

    /**
     * 调用的是其父类的方法
     * @param size
     * @return
     */
    public static Pet[] createArray(int size) {
        return CREATOR.createArray(size);
    }

    /**
     * 调用的是其父类的方法
     * @param size
     * @return
     */
    public static ArrayList<Pet> arrayList(int size) {
        return CREATOR.arrayList(size);
    }
}