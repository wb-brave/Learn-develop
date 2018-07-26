import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] wu){

//        User user = new User("w","b");
//        User user1 = new User("w","b");
//        User user2 = new User("w","b");
//        List<User> list = new ArrayList<>();
//
//        System.out.println(user.equals(user1));
        String n1 = new String("123");
        String n2 = new String("123");
        System.out.println(n1.equals(n2));

    }

}

class User{
    private String name;
    private String pass;

    public User(String name,String pass){

        this.name = name;
        this.pass = pass;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}