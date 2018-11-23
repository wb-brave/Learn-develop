package thinkinjava.chapter14.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static ArrayList<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "Cymric"
            ,"Dog"
            ,"EgyptianMau"
            ,"Hamster"
            ,"Manx"
            ,"Mouse"
            ,"Mutt"
            ,"Pug"
            ,"Rat"
    };
    private static void loader(){
        for (String typeName : typeNames) {
            try {
                types.add((Class<? extends Pet>)Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    static {
        loader();
    }

    static class Factory implements thinkinjava.chapter14.factory.Factory<ForNameCreator> {
        @Override
        public ForNameCreator create() {
            return new ForNameCreator();
        }
    }
}
