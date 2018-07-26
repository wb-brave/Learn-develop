package cn.wb.spring.first.sample.circleDepended;

public class TestB {
    private TestC testC;

    public void setTestC(TestC TestC) {
        this.testC = TestC;
    }

    public TestC getTestC() {
        return testC;
    }

    public void b(){
        testC.c();
    }

}
