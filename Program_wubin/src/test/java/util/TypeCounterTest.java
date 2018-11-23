package util;

import org.junit.Test;
import thinkinjava.chapter14.pets.Pet;
import thinkinjava.chapter14.pets.Pets;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class TypeCounterTest {

    @Test
    public void test(){
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            typeCounter.count(pet);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}