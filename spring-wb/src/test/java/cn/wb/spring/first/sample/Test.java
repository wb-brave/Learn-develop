package cn.wb.spring.first.sample;

public class Test {
    private int wubin;

    public Test(int wubin) {
        this.wubin = wubin;
    }

    public void setWubin(int wubin) {
        this.wubin = wubin;
    }

    public int getWubin() {
        return wubin;
    }

    static class innerClazz{
        public static void prints(){
            System.out.println("wubin");
        }
    }
}
