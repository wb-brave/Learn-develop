package thinkinjava.chapter18.nio;

import stack.Test;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description 测试nio与旧io的性能区别
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class OldIOMappedIO {

    private static int numOfInts = 4000000;
    private static int numOfBufferInts = 200000;
    private static String filename = "/Users/wufan/Desktop/test.tmp";

    public static abstract class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println("name: " + name);

            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.printf("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        protected abstract void test() throws IOException;
    }

    private static Tester[] tests =

            {
                    /**
                     * 通过stream进行写文件
                    */
                    new Tester("stream write") {
                        @Override
                        protected void test() throws IOException {
                            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
                            for (int i = 0; i < numOfInts; i++) {
                                dataOutputStream.writeInt(i);
                            }
                            dataOutputStream.close();
                        }
                    },

                    /**
                     * 使用nio进行写文件
                    */
                    new Tester("mapped write") {
                        @Override
                        protected void test() throws IOException {
                            FileChannel fc = new RandomAccessFile(filename, "rw").getChannel();
                            IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                            for (int i = 0; i < numOfInts; i++) {
                                intBuffer.put(i);
                            }
                            fc.close();
                        }
                    },
                    /**
                     * 通过stream进行读文件
                    */
                    new Tester("stream reader") {
                        @Override
                        protected void test() throws IOException {
                            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
                            // while (dataInputStream.available() != 0) {
                            //     dataInputStream.readInt();
                            // }
                            for (int i = 0; i < numOfInts; i++) {
                                dataInputStream.readInt();
                            }
                            dataInputStream.close();
                        }
                    },

                    /**
                     * 通过nio进行读文件
                    */
                    new Tester("mapped read") {
                        @Override
                        protected void test() throws IOException {
                            FileChannel fc = new FileInputStream(filename).getChannel();
                            /**
                             * 使用int视图进行读取数据
                             */
                            IntBuffer intBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                            while (intBuffer.hasRemaining()) {
                                intBuffer.get();
                            }
                            fc.close();
                        }
                    },

                    /**
                     * stream read and write
                    */
                    new Tester("stream read and write") {
                        @Override
                        protected void test() throws IOException {
                            RandomAccessFile accessFile = new RandomAccessFile(filename, "rw");
                            accessFile.writeInt(1);
                            for (int i = 0; i < numOfBufferInts; i++) {
                                accessFile.seek(accessFile.length() - 4);
                                accessFile.writeInt(accessFile.readInt());
                            }
                            accessFile.close();
                        }
                    },

                    /**
                     * nio read and write
                    */
                    new Tester("nio read and write") {
                        @Override
                        protected void test() throws IOException {
                            FileChannel fileChannel = new RandomAccessFile(filename, "rw").getChannel();
                            IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size()).asIntBuffer();
                            intBuffer.put(0);
                            for (int i = 1; i < numOfBufferInts; i++) {
                                intBuffer.put(intBuffer.get(i - 1));
                            }
                            fileChannel.close();
                        }
                    }
            };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.runTest();
        }
    }
}
