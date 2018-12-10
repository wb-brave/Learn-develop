package util.sets;

import util.generator.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.sets
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<>(gen,quantity);
    }
}
