package thinkinjava.chapter5.pets;

import org.junit.Test;
import thinkinjava.chapter14.pets.PetCount;
import thinkinjava.chapter14.pets.Pets;

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
public class LiteraletCreatorTest {

    @Test
    public void test(){
        PetCount.countPets(Pets.CREATOR);
    }
}