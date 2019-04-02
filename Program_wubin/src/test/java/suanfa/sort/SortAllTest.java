package suanfa.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortAllTest {

    @Test
    public void quickSort() {
        SortAll.quickSort(SortAll.a,0,SortAll.a.length-1);
        System.out.println(Arrays.toString(SortAll.a));
    }

    @Test
    public void testArth(){
        int i=0,j=0;
        // assertEquals(++i,j++);
        System.out.println(++i);
        System.out.println(i);
        System.out.println(j++);
        System.out.println(j);
    }
}