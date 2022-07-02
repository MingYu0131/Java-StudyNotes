package com.JavaStudy.HspMiddleJavaTest.BasicJavaTest;

/**
 * 测试final关键字，可以修饰类、属性、方法、局部变量
 * 在有以下需求时，就会使用到final：
 * 1、当不希望类被继承时，使用final修饰（String类、Double等包装类）
 * 2、当不希望父类的某个方法被子类重写时，用final修饰
 * 3、当不希望类的某个属性被修改时用final修饰（此时称该属性为常量，全部大写用下划线做间隔：TAX_RATE）
 * 4、当不希望某个局部变量被修改，使用final修饰
 *
 * 注意final有如下细节：
 * 1、final修饰的属性在定义时必须被赋初值，且以后不能再修改，赋初值可以在如下位置之一：
 *      （1）定义时直接赋初值
 *      （2）在构造器中赋初值
 *      （3）在代码块中赋初值
 *      （4）在方法的形参中定义了常量如：int cal(final int PI){...}，然后在使用方法时对该常量赋值如：cal(3.14)
 * 2、如果final修饰的属性是静态的，则初始化的位置只能是（1）定义时（2）静态代码块，注意不能在构造器中赋初值了
 * 3、一般来说，如果一个类已经是final类，就没有必要再将其方法修饰为final
 * 4、final不能修饰构造器
 * 5、final与static往往搭配使用，效率更高，这样类就不会加载（底层编译器做了优化处理）
 */
final public class TestFinal {  //final修饰，不能被继承
    private final int TEST;

    public TestFinal() {
        TEST = 5;   //在构造器中初始化
    }

    private static final int TEST2;

    static {
        System.out.println("TestFinal中的静态代码块01被调用");
        TEST2 = 3;  //静态常量属性只能在静态代码块中初始化
    }

    private static final int TEST3 = 3; //因为static和final在一起使用已经优化，如果直接调用此常量，
                                        // 那么将会跳过类加载直接读取到此常量，可以满足有时只是想使用此常量，例如：Math.PI

    static {
        System.out.println("TestFinal中的静态代码块02被调用");
    }



}


