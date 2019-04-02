package suanfa.array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static suanfa.array.SuanFa.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package suanfa.array
 * @email wubin326@qq.com
 * @date 2019/03/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/22        wubin            0.0.1
 */
public class SuanFaTest {
    SuanFa suanFa = new SuanFa();

    @Test
    public void test() {
        StringBuffer s = new StringBuffer("wubin jw");
        System.out.println(suanFa.replaceSpace(s));
    }

    @Test
    public void testTree() {
        // int[] pre = {1,2,4,7,3,5,6,8};
        // int[] min = {4,7,2,1,5,3,8,6};
        int[] pre = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] min = {2, 4, 3, 1, 5, 8, 7, 9, 6};
        SuanFa.TreeNode treeNode = suanFa.reConstructBinaryTree(pre, min);
        System.out.println();
    }

    @Test
    public void testBackTree() {
        int[] back = {4, 3, 2, 8, 9, 7, 6, 5, 1};
        int[] min = {2, 4, 3, 1, 5, 8, 7, 9, 6};
        SuanFa.TreeNode treeNode = suanFa.reConstructBinaryTree(back, min);
        System.out.println();
    }

    @Test
    public void reOrderArray() {
        int[] array = {1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 9};
        suanFa.reOrderArray(array);
    }

    @Test
    public void FindKthToTail() {
        ListNode listNode = new ListNode(1);
        suanFa.FindKthToTail(pushNode(listNode, 15), 5);

    }

    private ListNode pushNode(ListNode listNode, int i) {
        if (i > 0) {
            listNode.next = new ListNode(i);
            pushNode(listNode.next, --i);
        }
        return listNode;
    }

    @Test
    public void ReverseList() {
        ListNode listNode = new ListNode(16);
        suanFa.ReverseList(pushNode(listNode, 15));
    }

    @Test
    public void getWeiYi() {

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            next.getValue();
        }
        System.out.println(7 ^ 4);
        System.out.println(7 | 4);
    }

    @Test
    public void testJava8() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        IntSummaryStatistics summaryStatistics = G7.stream().mapToInt(String::length).summaryStatistics();
        String collect = G7.stream().filter(x -> x.startsWith("U")).map(x -> x.replaceAll("U", "W")).collect(Collectors.joining(";"));
        System.out.println(collect);

    }
}