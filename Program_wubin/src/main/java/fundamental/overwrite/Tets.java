package fundamental.overwrite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Tets {
    public static final int i = 0;
    String aa = "asd";
    public static void main(String[] wb){
        short s = 1;
        s += 1;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
