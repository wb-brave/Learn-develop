package thinkinjava.chapter17.containers;

import java.util.PriorityQueue;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/13
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/13        wubin            0.0.1
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                } else if (secondary == o.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "ToDoItem{" +
                    "primary=" + primary +
                    ", secondary=" + secondary +
                    ", item='" + item + '\'' +
                    '}';
        }
    }

    public void add(char primary, int secondary, String item){
        super.add(new ToDoItem(primary,secondary,item));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add('C',4,"Empty trash");
        toDoList.add('A',2,"Feed dog");
        toDoList.add('B',7,"Feed bird");
        toDoList.add('C',3,"Mow lawm");
        toDoList.add('A',1,"Water lawm");
        toDoList.add('B',1,"Feed cat");
        while (!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }
}
