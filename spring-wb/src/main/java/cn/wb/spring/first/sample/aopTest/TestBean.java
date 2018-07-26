package cn.wb.spring.first.sample.aopTest;

public class TestBean {
    private String temp;

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }

    public void test(){
        System.out.println("wubin");
    }
}
