package cn.wb.spring.first.springRmi;

public class HelloRMIServiceImpl implements HelloRMIService {

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
