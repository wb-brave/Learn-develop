package suanfa.sort;

public class SortAll {

    public static final int[] a = {2, 1, 5, 8, 6, 1, 2, 3, 9, 7};


    public static void quickSort(int[] a, int min, int max) {

        int index = a[min];
        if (min>=max){
            return;
        }
        int i = 0;
        int j = 0;
        j = max;
        i = min;
        while (i != j) {
            /*
                关键点就是一定要从右边开始比较，因为在while语句中有 i<j 的比较
                而且递归的时候是用根据 i 的值进行传参的，所以要保持i的一致性， j可以动态的来做一些
                操作，进行比较

                关键就是要定位 i 的位置
             */
            while (a[j] >= index && i < j) {
                --j;
            }
            while (a[i] <= index && i < j) {
                ++i;
            }
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int p = a[i];
        a[i] = a[min];
        a[min] = p;

        quickSort(a, min, i-1);
        quickSort(a, i+1, max);
    }

}

