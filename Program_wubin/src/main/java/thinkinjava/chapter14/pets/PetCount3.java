package thinkinjava.chapter14.pets;

import util.sets.MapData;

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
public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

        /**
         * 预先调用工具类mapdata来填充map
         */
        public PetCounter() {
            super(MapData.map(LiteraletCreator.allTypes, 0));
        }

        /**
         * 获取已经存在的所有键值对
         * 之后根据是否为pet的实例，加入set中
         *
         * @param pet
         */
        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                /**
                 * 使用数组预加载需要的类，简化了instantsof判断的重复代码
                 */
                if (entry.getKey().isInstance(pet)) {
                    put(entry.getKey(), entry.getValue() + 1);
                }
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair
                    : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        }
        System.out.println();
        System.out.println(petCount);
    }
}
