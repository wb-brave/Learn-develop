package thinkinjava.chapter17.exercise;

import Thread.chapter04.condition123.F;
import sun.jvm.hotspot.debugger.SymbolLookup;
import util.sets.Countries;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.exercise
 * @email wubin326@qq.com
 * @date 2018/12/11
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/11        wubin            0.0.1
 */
public class SingleLinkedLlist<E> {

    transient Node<E> first;
    transient int size;

    public SingleLinkedLlist() {
    }

    public SingleLinkedLlist(
            Collection<E> temp)

    {
        Object[] objects = temp.toArray();
        Node<E> pred = first;
        for (Object object : objects) {
            E e = (E) object;
            Node<E> newNode = new Node<>(e, null);
            /**
             * 借鉴了linkedlist的实现，
             * 这个为什么会追加到first的节点下，，很疑惑
             */
            if (pred == null) {
                first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }
        /**
         * 单向链表的总长度
         */
        size += objects.length;
    }

    public ListItr listIterator() {
        return listIterator(0);
    }

    public ListItr listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public ListItr(int index) {
            // next = node(index);
            next = first;
            nextIndex = index;
        }

        private Node<E> node(int index) {
            if (index < size) {
                // for (int i=index;)
            }
            return null;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public E add(E item) {
            Node<E> eNode = new Node<>(item, null);
            if (next == null) {
                lastReturned.next = eNode;
            } else {
                next.next = eNode;
            }
            nextIndex++;
            size++;
            return item;
        }

        /**
         * 移除操作,需要在遍历了元素后执行
         */
        public E remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            Node<E> lastnext = lastReturned.next;
            if (lastnext == next) {
                next = lastnext;
            }
            nextIndex--;
            size--;
            final E item = lastReturned.item;
            lastReturned = null;
            return item;
        }

    }

    private class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    public static void main(String[] args) {
        SingleLinkedLlist<String> llist = new SingleLinkedLlist<>(Countries.names(4));
        ListIterator<String> itr = llist.listIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        itr.add("wubin");
        ListIterator<String> itr1 = llist.listIterator();
        while (itr1.hasNext()) {
            System.out.print(itr1.next() + ", ");
        }
        // LinkedList<String> linkedList = new LinkedList<>(Countries.names(6));
        // java.util.ListIterator<String> listIterator = linkedList.listIterator();
        // /**
        //  * 不能先执行删除操作
        //  */
        // listIterator.remove();
    }
}

interface ListIterator<E> {
    E remove();

    boolean hasNext();

    E next();

    E add(E item);
}