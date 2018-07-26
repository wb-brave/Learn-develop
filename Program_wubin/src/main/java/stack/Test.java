package stack;

import java.util.*;

public class Test {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] wubin) {
        //控制输入的漫游车数量
        Integer n = new Integer(0);
        System.out.println("请输入需要派发的漫游者数量");
        n = scanner.nextInt();
        //行走的范围
        System.out.println("输入详细信息，参考文件底部输入案例");
        Integer X = scanner.nextInt();
        Integer Y = scanner.nextInt();
        HashMap<ArrayList<String>, ArrayList<String>> rtn = inputMethod(n);
        for (String s : calLocation(rtn)
                ) {
            System.out.println(s);
        }
    }

    public static HashMap<ArrayList<String>, ArrayList<String>> inputMethod(Integer n) {

        HashMap<ArrayList<String>, ArrayList<String>> rtn = new HashMap<>();
        ArrayList<String> keyList = new ArrayList();
        ArrayList<String> valList = new ArrayList();
        while (n > 0) {
            //输入漫游者的位置以及方向
            Integer x = scanner.nextInt();
            Integer y = scanner.nextInt();
            String l = scanner.nextLine();
            keyList.add(x + "");
            keyList.add(y + "");
            keyList.add(l);

            //输入命令
            String order = scanner.nextLine();
            valList.add(order);
            n--;
        }
        rtn.put(keyList, valList);
        return rtn;
    }

    //计算并输出漫游者位置
    public static ArrayList<String> calLocation(HashMap<ArrayList<String>, ArrayList<String>> hashMap) {

        Iterator<Map.Entry<ArrayList<String>, ArrayList<String>>> iterator = hashMap.entrySet().iterator();
        ArrayList<String> rtn = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<ArrayList<String>, ArrayList<String>> entry = iterator.next();
            //获取到漫游者的位置方向列表
            ArrayList<String> keyList = entry.getKey();
            //获取到漫游者的命令列表
            ArrayList<String> valList = entry.getValue();
            //设置4个方向
            String p = "NESW";
            for (int i = 0; i < valList.size(); i++) {
                if (p.contains(keyList.get(2 + i * 3).trim())) {
                    //漫游者的方向
                    String sp = "";
                    //漫游车的当前位置以及方位
                    int x = Integer.valueOf(keyList.get(i * 3));
                    int y = Integer.valueOf(keyList.get(1 + i * 3));
                    //设置当前方向 0-N 1-E 2-S 3-W
                    int tp = p.indexOf(keyList.get(2 + i * 3).trim());
                    //获取详细命令
                    String order = valList.get(i);
                    char[] chars = order.toCharArray();
                    //解析命令，操作漫游者
                    for (int j = 0; j < chars.length; j++) {
                        if ((chars[j] + "").equals("L")) {
                            if (tp == 0) {
                                tp = 3;
                            } else {
                                tp--;
                            }
                        } else if ((chars[j] + "").equals("R")) {
                            if (tp == 3) {
                                tp = 0;
                            } else {
                                tp++;
                            }
                        } else {
                            switch (tp) {
                                case 0:
                                    y++;
                                    sp = "N";
                                    break;
                                case 1:
                                    x++;
                                    sp = "E";
                                    break;
                                case 2:
                                    y--;
                                    sp = "S";
                                    break;
                                case 3:
                                    x--;
                                    sp = "W";
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    //设置每个漫游者的输出结果
                    String s = x + " " + y + " " + sp;
                    rtn.add(s);
                }else{
                    rtn.add("参数错误！");
                }
            }
        }
        return rtn;
    }
    /*
    输入输出例子
    输入：
    5 5
    1 2 N
    LMLMLMLMM
    3 3 E
    MMRMMRMRRM
    预期产出：
    1 3 N
    5 1 E
     */
}
