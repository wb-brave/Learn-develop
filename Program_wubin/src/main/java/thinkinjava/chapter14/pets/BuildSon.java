package thinkinjava.chapter14.pets;

import thinkinjava.chapter18.util.TextFile;

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
public class BuildSon {
    public static void main(String[] args) throws Exception {
        String[] strings = {"Cat","Cymric","Dog","EgyptianMau","ForNameCreator","Hamster","LiteraletCreator","Manx","Mouse","Mutt","Pet","PetCreator","Pets","Pug","Rat","Rodent"};
        String dir = "/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/java/thinkinjava/chapter5/pets";
        String ext = ".java";
        TextFile.buildFile(dir,ext,strings);
    }
}
