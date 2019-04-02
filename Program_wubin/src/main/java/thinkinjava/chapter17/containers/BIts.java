package thinkinjava.chapter17.containers;

import java.util.BitSet;
import java.util.Random;

/**
 * @author wubin
 * @Description 对bitset的演示
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class BIts {
    public static void printBitSet(BitSet b) {
        System.out.println("bits: " + b);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < b.size(); i++) {
            stringBuilder.append(b.get(i) ? 1 : 0);
        }
        System.out.println("bit pattern: " + stringBuilder);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        byte bt = (byte) rand.nextInt();
        BitSet bitSet = new BitSet();
        /**
         * 为什么是7
         * 因为byte是8位，一个字节
         */
        for (int i = 7; i >= 0; i--) {
            if ((i << 1 & bt) != 0){
                bitSet.set(i);
            }else {
                bitSet.clear(i);
            }
        }
        System.out.println("byte value: " + bt);
        printBitSet(bitSet);

        short st = (short)rand.nextInt();
        BitSet bs = new BitSet();
        /**
         * 为什么是15
         * 因为byte是16位，俩个字节
         */
        for(int i = 15; i >= 0; i--)
            if(((1 << i) &  st) != 0)
                bs.set(i);
            else
                bs.clear(i);
        System.out.println("short value: " + st);
        printBitSet(bs);

        int it = rand.nextInt();
        BitSet bi = new BitSet();
        /**
         * 为什么是31
         * 因为byte是32位，四个字节
         */
        for(int i = 31; i >= 0; i--)
            if(((1 << i) &  it) != 0)
                bi.set(i);
            else
                bi.clear(i);
        System.out.println("int value: " + it);
        printBitSet(bi);

        // Test bitsets >= 64 bits:
        BitSet b127 = new BitSet();
        b127.set(127);
        System.out.println("set bit 127: " + b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        System.out.println("set bit 255: " + b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        b1023.set(1024);
        System.out.println("set bit 1023: " + b1023);

        int i= 8;
        i |= 3;
        System.out.println("i " + i);

    }
}
