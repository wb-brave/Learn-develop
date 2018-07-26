package cn.wb.spring.first.sample.circleDepended;

public class TestA {
    private TestB testB;

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

    public TestB getTestB() {
        return testB;
    }

    public void a(){
        testB.b();
        System.out.println("A-B-C");
    }

}
