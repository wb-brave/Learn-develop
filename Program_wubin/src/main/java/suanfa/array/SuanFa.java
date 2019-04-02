package suanfa.array;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增
 * 的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @project Learn-develop
 * @package suanfa.array
 * @email wubin326@qq.com
 * @date 2019/03/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/22        wubin            0.0.1
 */
public class SuanFa {

    /**
     * 从最右上方开始比较，可以确定数在哪一行
     *
     * @param array
     * @param target
     * @return
     */
    public boolean Find(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }

    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replaceAll(" ", "%20");
        return s;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    /**
     * 利用递归从后往前走
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    /**
     * 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        TreeNode root = reConstructBinaryTreeBac(pre, 0, pre.length - 1, in, 0, in.length - 1);
        System.out.print("后序遍历结果：");
        printBackTree(root);
        System.out.print("\n中序遍历结果：");
        printMinTree(root);
        System.out.print("\n前序遍历结果：");
        printPreTree(root);

        return root;
    }

    /**
     * 前序遍历一棵树
     *
     * @param root
     */
    private void printPreTree(TreeNode root) {
        System.out.print(root.val + ",");
        if (root.left != null) {
            printPreTree(root.left);
        }
        if (root.right != null) {
            printPreTree(root.right);
        }
    }

    /**
     * 中序遍历一棵树
     *
     * @param root
     */
    private void printMinTree(TreeNode root) {
        if (root.left != null) {
            printMinTree(root.left);
        }
        System.out.print(root.val + ",");
        if (root.right != null) {
            printMinTree(root.right);
        }
    }

    /**
     * 后序遍历一棵树
     *
     * @param root
     */
    private void printBackTree(TreeNode root) {
        if (root.left != null) {
            printBackTree(root.left);
        }
        if (root.right != null) {
            printBackTree(root.right);
        }
        System.out.print(root.val + ",");
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }

        return root;
    }

    //后序遍历{7,4,2,5,8,6,3,1}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTreeBac(int[] back, int startBack, int endBack, int[] in, int startIn, int endIn) {

        if (startBack > endBack || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(back[endBack]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == back[endBack]) {
                root.left = reConstructBinaryTreeBac(back, startBack, i - startIn + startBack - 1, in, startIn, i - 1);
                root.right = reConstructBinaryTreeBac(back, i - startIn + startBack, endBack - 1, in, i + 1, endIn);
                break;
            }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 用俩个栈模拟队列
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {
        int res = 0;
        if (!stack2.empty()) {
            res = stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            res = stack2.pop();
        }
        return res;
    }

    /**
     * 输入一个非减排序的数组的一个旋转
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (high + low) >> 1;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high -= 1;
            } else
                high = mid;
        }
        return array[low];
    }

    /**
     * 斐波那契数列
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        return Fibonacci(n, 0, 1);
    }

    private static int Fibonacci(int n, int acc1, int acc2) {
        if (n == 0) return 0;
        if (n == 1) return acc2;
        else return Fibonacci(n - 1, acc2, acc1 + acc2);

    }

    /**
     * 将数组的奇数前移，偶数后移
     */
    public void reOrderArray(int[] array) {
        ArrayList<Integer> js = new ArrayList<Integer>();
        ArrayList<Integer> os = new ArrayList<Integer>();
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 0) {//奇数
                js.add(array[i]);
            } else
                os.add(array[i]);
        }
        js.addAll(os);
        System.out.println(js.toString());
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = js.get(i);
        }
    }

    /**
     * 找倒数第k个数
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode p, q;
        p = q = head;
        int i = 0;
        /**为什么找到了倒数的
         * 因为先q是等了k个元素后再从头开始移动的 ==> i>=k
         */
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        System.out.println(q.val);
        return i < k ? null : q;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {

        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }

}
