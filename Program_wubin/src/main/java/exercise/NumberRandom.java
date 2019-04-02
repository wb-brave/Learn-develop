package exercise;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2019/03/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/28        wubin            0.0.1
 */
public class NumberRandom {
    String[] stra = {"1", "2", "2", "3", "4", "5"};
    int n = stra.length;
    boolean[] visited = new boolean[n];
    String result = "";
    TreeSet<String> ts = new TreeSet<String>();
    int[][] a = new int[n][n];

    private void searchMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
//3和5不能相连
        a[3][5] = 0;
        a[5][3] = 0;
//开始遍历
        for (int i = 0; i < n; i++) {
            search(i);
        }
        Iterator<String> it = ts.iterator();


        while (it.hasNext()) {
            String str = it.next(); //4 不能在第三位
            if (str.indexOf("4") != 2) {
                System.out.println(str);
            }
        }
    }


    private void search(int startIndex) {
        visited[startIndex] = true;
        result = result + stra[startIndex];
        if (result.length() == n) {
            ts.add(result);
        }
        for (int j = 0; j < n; j++) {
            if (a[startIndex][j] == 1 && visited[j] == false) {
                search(j);
            } else {
                continue;
            }
        }
//一个 result 结束后踢掉最后一个,寻找别的可能性,若没有的话,则继续向前踢掉当前最后一个
        result = result.substring(0, result.length() - 1);
        visited[startIndex] = false;
    }

    public static void main(String[] args) {
        new NumberRandom().searchMap();
    }
}

