package com.JavaStudy.HspMiddleJavaTest.BasicJavaTest;

/**
 * 测试内部类的使用
 * 内部类包括：
 * 定义在外部类局部位置上（比如方法内、代码块）
 * （1）局部内部类（有类名）
 * （2）匿名内部类（没有类名，重点！！！！！！！！！！！！）
 * 定义在外部类的成员位置上（这两种类的本质之一是外部类的一个成员）
 * （3）成员内部类（没有static修饰）
 * （4）静态内部类（使用static修饰）
 * 内部类的作用：  内部类提供了更好的封装。只能让外部类直接访问，不允许同一个包中的其他类直接访问。
 *  内部类可以直接访问外部类的私有属性，内部类被当成其外部类的成员。但外部类不能访问内部类的内部属性。
 */
public class TestInnerClass {

    public static void main(String[] args) {
        //成员内部类的创建，先创建外部类实例，然后使用该外部类实例创建内部类实例
        TestInnerClass ts = new TestInnerClass();
        TestInnerClass.Inner Inner = ts.new Inner();
        Inner.show();
        //也可以直接使用下面用到了匿名对象的方法去使用成员内部类
        TestInnerClass.Inner Inner_ = new TestInnerClass().new Inner();
        Inner_.show();
        System.out.println();

        //静态内部类的创建，通过 new 外部类名.内部类名() 来创建内部类对象
        TestInnerClass.Inner2 Inner2 = new TestInnerClass.Inner2();
        Inner2.test();

        //匿名内部类，创建一个只使用一次的类
        //这里的用法是直接将匿名内部类作为一个函数参数传给test2方法
        TestInnerClass Inner3 = new TestInnerClass();
        Inner3.test2(new A() {  //注意要使用test2，需要类型为A的参数
            @Override
            public void run() { //重写run方法
                System.out.println("这是第一次生成的匿名内部类！");
            }
        });

        Inner3.test2(new A() {
            @Override
            public void run() {
                System.out.println("这是第二次生成的匿名内部类！");
            }
        });

        //测试局部内部类
        TestInnerClass Inner4 = new TestInnerClass();
        Inner4.test3(); //此时局部内部类中的TestInnerClass.this，指的就是Inner4这个对象
        System.out.println("对象Inner4的信息是："+Inner4); //验证，可以看出是同一个对象

    }

    private int age = 10;
    public void ShowAge(){
        System.out.println(this.age);//10
        System.out.println(TestInnerClass.this.age);
    }

    /* 定义非静态内部类 */

    /**
     * 成员内部类（外部类里使用非静态内部类和平时使用其他类没什么不同）
     * 1. 非静态内部类对象必须寄存在一个外部类对象里。因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。
     * 非静态内部类对象单独属于外部类的某个对象。
     * 2. 非静态内部类可以直接访问外部类的成员，但是外部类不能直接访问非静态内部类成员。
     * 3. 非静态内部类不能有静态方法、静态属性和静态初始化块。
     * 4. 成员变量访问要点： 1. 内部类里方法的局部变量：变量名。 2. 内部类属性：this.变量名。 3. 外部类属性：外部类名.this.变量名。
     */
    public class Inner{
        //内部类中可以定义和外部类一样的方法和属性
        private  int age = 20;
        public void show(){
            System.out.println(this.age);//20
            //内部类也可以通过引用的方式访问外部类的普通属性,外部类属性：外部类名.this.变量名。
            System.out.println(TestInnerClass.this.age);//10
        }

    }

    private int a = 10; //定义一个普通属性
    static int b = 5;   // 定义一个静态属性
    /**
     * 静态内部类使用要点： 1. 静态内部类可以访问外部类的静态成员，不能访问外部类的普通成员。
     * 2. 静态内部类看做外部类的一个静态成员。
     */
    //定义静态内部类，意义相当于外部类的一个静态成员
    static public class Inner2{
//        int b = 11;
        public void test(){
            System.out.println(b);  // 5,静态内部类可以很方便的访问外部类的静态成员，因为他们都处于同一个内存区域-方法区
//            System.out.println(this.b); //11

//            System.out.println(a);  //  不能直接访问外部类的非静态成员
//            System.out.println(TestInnerClass.this.b);
        }
    }

    /**
     * 匿名内部类：适合那种只需要使用一次的类。比如：键盘监听操作等等。在安卓开发、awt、swing 开发中常见。
     */
    public void test2(A a){ //测试方法，参数为A接口类型的一个对象
        a.run();
    }

    interface A{
        void run();
    }

    /**
     * 局部内部类：定义在外部类的局部位置（方法内部、代码块）
     * 1、可以直接访问外部类的所有成员（包含私有的）
     * 2、不能添加访问修饰符，因为它的地位就是一个局部变量。局部变量不能使用访问修饰符，但是可以使用final，因为局部变量是可以用final修饰的
     * 3、作用域：仅仅只在定义他的方法或代码块中
     * 4、局部内部类访问外部类成员直接访问即可
     * 5、外部类访问局部内部类的成员，需要先创建对象再访问（注意在作用域内）
     * 6、外部其他类不能直接访问局部内部类（因为局部内部类本质上就是个局部变量）
     * 7、如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员
     *    使用 外部类名.this.成员去访问
     *    TestInnerClass.this 本质上就是外部类对象，即哪个对象调用了test3，就指哪个对象
     */
    private int n1 = 10;    //这是外部类的属性n1
    public void test3(){
        int n1 = 10;    //局部内部类的属性n1
        //位于方法中的局部内部类，作用域仅限于此方法test3
        class MethodInnerClass{
            int n1 = 99;    //故意重名的局部内部类属性
            public void show(){
                System.out.println("局部内部类n1 = "+n1+"外部类的n1 = "+TestInnerClass.this.n1);
                System.out.println("当前调用的对象是："+TestInnerClass.this);    //打印
            }
        }
        new MethodInnerClass().show();  //使用局部内部类中的方法

    }

}
