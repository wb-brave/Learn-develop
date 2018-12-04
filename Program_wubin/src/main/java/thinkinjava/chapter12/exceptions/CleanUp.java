package thinkinjava.chapter12.exceptions;

import util.MyConst;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/28        wubin            0.0.1
 */
public class CleanUp {

    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile(MyConst.FileConst.FILEPATH_DESKTOP + "GreenHouseController.txt");

            /**
             * 在下一个try块中进行清理
             */
            try {
                String s;
                int i = 1;
                while (inputFile.getLine() != null) {
                    //add you code
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                inputFile.dispose();
            }
        } catch (Exception e) {
            System.out.println("inputFile construction failed");
        }
    }
}
