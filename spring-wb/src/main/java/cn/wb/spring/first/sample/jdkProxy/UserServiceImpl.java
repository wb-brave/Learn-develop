package cn.wb.spring.first.sample.jdkProxy;

public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("----------------add--------------");
    }

    public void add(String a, int b) {
        System.out.println(a + b);
    }

    public void add(int a, String b) {
        System.out.println(a + b);
    }

}
