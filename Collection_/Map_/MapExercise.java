package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mingyu
 * @version 1.0
 * 使用HashMap添加3个员工对象，要求
 * 1、键为：员工id 值为：员工对象
 * 2、遍历显示工资>18000的员工（最少两种遍历方式）
 * 3、员工类：姓名、工资、员工id
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Employee mybb = new Employee("mybb", 15000, "123456");
        Employee tdbb = new Employee("tdbb", 20000, "456789");
        Employee pybb = new Employee("pybb", 21000, "123789");
        HashMap employeeMap = new HashMap();
        employeeMap.put(mybb.getId(), mybb);
        employeeMap.put(tdbb.getId(), tdbb);
        employeeMap.put(pybb.getId(), pybb);

        //第一种遍历方式，使用keySet获取key再get，遍历
        Set keySet = employeeMap.keySet();
        for (Object key : keySet) {
            Employee e = (Employee) employeeMap.get(key);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }

        //第二种遍历方式，使用entrySet获取关系，再分别取出key和value遍历
        Set entrySet = employeeMap.entrySet();
        for (Object o : entrySet) {
            Map.Entry e = (Map.Entry) o;
            Employee emp = (Employee) e.getValue();
            if (emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }


    }
}

@SuppressWarnings({"all"})
class Employee {
    private String name;
    private double sal;
    private String id;

    public Employee(String name, double sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
