package thinkinjava.chapter14.pets;

import thinkinjava.chapter14.factory.Factory;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.pets
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class PetCreatorFactories {

    public static List<Factory<? extends PetCreator>> petFactories = new ArrayList<>();
    private static Random rand = new Random(47);
    static {
        petFactories.add(new ForNameCreator.Factory());
        petFactories.add(new LiteraletCreator.Factory());
    }
}
