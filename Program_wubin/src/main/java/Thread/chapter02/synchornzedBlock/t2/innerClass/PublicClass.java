package Thread.chapter02.synchornzedBlock.t2.innerClass;

public class PublicClass {
    private String username;
    private String password;

//    public class PrivateClass{ //需要外部类的实例进行实例化 publicClass.new PrivateClass();
    //静态内置类，可以直接new

    static class PrivateClass{
        private String age;
        private String address;

        public String getAddress() {
            return address;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
