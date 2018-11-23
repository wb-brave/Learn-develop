package thinkinjava.chapter14.pets;

import java.util.*;

public class LiteraletCreator extends PetCreator{
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(
                    Cymric.class
                    ,Dog.class
                    ,EgyptianMau.class
                    ,Hamster.class
                    ,Manx.class
                    ,Mouse.class
                    ,Mutt.class
                    ,Pug.class
                    ,Rat.class
            )
    );
    /**
     * 截取指定长度的list返回
     * allTypes.subList(allTypes.indexOf(Mutt.class),allTypes.size());
     */
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(0,allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }

    static class Factory implements thinkinjava.chapter14.factory.Factory<LiteraletCreator> {
        @Override
        public LiteraletCreator create() {
            return new LiteraletCreator();
        }
    }
}