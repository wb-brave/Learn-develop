package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void main() {
        String s = "S";
        String str="N1E2S3M";
        String[] strings = str.split(" ");
        for (String s1:strings
             ) {
            System.out.print(s1+" ");
        }
        if (str.contains(s)){
            System.out.println(11111);
            System.out.println(str.substring(3,5));
        }
        System.out.println(str.indexOf(s));

        System.out.println(7^2);
        System.out.println(7&2);
        System.out.println(7|2);
    }
}