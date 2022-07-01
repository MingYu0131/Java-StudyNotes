package com.JavaStudy.HspMiddleJavaTest;

/**
 * 测试接口：接口是一组规范（特性），类和接口是实现关系。
 * 接口不提供任何实现，定义的变量和方法都是抽象的
 * 1.接口不能被实例化
 * 2.接口中所有的方法是 public 方法, 接口中抽象方法，可以不用 abstract 修饰
 * 3.一个普通类实现接口,就必须将该接口的所有方法都实现,可以使用 alt+enter 来解决
 * 4.抽象类去实现接口时，可以不实现接口的抽象方法
 * 5.一个类可以实现多个接口,实现接口可以看作一个类功能的拓展
 * 6.接口中的属性只能是final的，而且是public static final的（重要！！）
 * 7.接口不能继承其他的类，但是可以继承多个别的接口
 * 8.接口的修饰符只能是public和default的，这和类是一样的
 * 9.接口也有多态，和父类子类的继承体现的多态是一样的
 * 10.接口有多态传递现象
 */
public class TestInterface {

    public static void main(String[] args) {

        Angle a = new Angle();
        a.fly();
        a.help();
        System.out.println(Volant.FLY_HIGHT);   //显示常量，注意引用的是接口

        //接口体现的多态
        Volant vo = new BirdMan();
        vo.fly();

        //和类的多态一样，接口也能实现多态数组
        Volant[] vos = new Volant[2];
        vos[0] = new BirdMan();
        vos[1] = new Angle();
        for (int i = 0; i < vos.length; i++) {
            vos[i].fly();   //动态绑定机制（方法看运行时类）
            if(vos[i] instanceof Angle){    //instanceof看运行时类
                ((Angle) vos[i]).help();
            }
        }

        //演示多态的传递现象
        //因为VolantPlus继承了Volant，所以即使BirdMan类没有实现Volant接口，其也拥有Volant接口的特性，也可以被声明为Volant类型
        Volant v = new BirdMan();   //这就是多态的传递现象

        VolantPlus v2 = new BirdMan();

    }
}

//飞行接口
interface Volant{   //使用interface定义接口
    int FLY_HIGHT = 100;    //默认：public static final，是静态常量所以全大写

    void fly(); //默认：public abstract
}

//接口的继承
interface VolantPlus extends Volant{}

//善良接口
interface Honest{
    void help();
}

//具有飞行特性的鸟人
class BirdMan implements VolantPlus{    //使用implements来使用接口
    @Override
    public void fly() {
        System.out.println("鸟人正在飞！");
    }
}

//具有善良特性的好人
class GoodMan implements Honest{
    @Override
    public void help() {
        System.out.println("好人扶老奶奶过马路！");
    }
}

//同时具有飞行和善良特性的天使，接口才能多继承
class Angle implements Honest,Volant{
    @Override
    public void fly() {
        System.out.println("天使正在飞！");
    }

    @Override
    public void help() {
        System.out.println("天使在扶老奶奶过马路！");
    }
}
