package cn.wb.spring.first.sample.lookUp;

public abstract class GetBeanTest {
    public abstract User getBean();
    public void showMe(){
        this.getBean().showMe();
    }
}
