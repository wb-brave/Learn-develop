package Thread.chapter02.synchornzedBlock.t2.innerClass;

import org.junit.Test;


public class PublicClassTest {

    @Test
    public void run() {

        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("wubin");
        publicClass.setPassword("123");
        System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());

//        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        PublicClass.PrivateClass privateClass = new PublicClass.PrivateClass();
        privateClass.setAddress("jx");
        privateClass.setAge("22");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());

    }
}