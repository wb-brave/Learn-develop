package cn.wb.spring.first.springRmi;


import java.rmi.Remote;

public interface HelloRMIService extends Remote{

    int add(int a, int b);
}
