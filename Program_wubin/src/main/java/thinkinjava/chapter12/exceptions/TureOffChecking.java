package thinkinjava.chapter12.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/30
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/30        wubin            0.0.1
 */
public class TureOffChecking {

    public static void main(String[] args) {
        final WrapCheckedException wrapCheckedException = new WrapCheckedException();

        /**
         * 这里没有抛出异常，只是执行了
         * 默认的switch代码块
         */
        wrapCheckedException.throwRuntimeException(3);

        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wrapCheckedException.throwRuntimeException(i);
                } else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException fnf) {
                    System.out.println("FileNotFoundException " + fnf);
                } catch (IOException ioe) {
                    System.out.println("IOException " + ioe);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                } finally {
                }
            } finally {
            }
        }
    }
}

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException();
                default:
                    return;
            }
        } catch (Exception e) {
            /**
             * 必须要将e传入下面的异常的构造器方法中
             */
            throw new RuntimeException(e);
        } finally {
        }
    }
}

class SomeOtherException extends Exception {
}