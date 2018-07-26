package cn.wb.spring.first.sample.circleDepended;

public class TestC {
    private TestA testA;

    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    public TestA getTestA() {
        return testA;
    }

    public void c(){
        testA.a();
    }

}
