package com.JavaStudy.HspMiddleJavaTest.Thread_;

/**
 * @author mingyu
 * @version 1.0
 * 1、有2个用户分别从同一个卡上取钱，总额10000
 * 2、每次都取1000，当余额不足时就不能取款了
 * 3、不能出现超取现象 -> 线程同步问题
 */
public class ThreadExercise02 {
    public static void main(String[] args) {
        Card card = new Card("123456", 10000);
        //两个用户使用同一张卡
        CardUser mybb = new CardUser(card, "mybb");
        CardUser pi = new CardUser(card, "pi");

        Thread mybbT = new Thread(mybb);
        Thread piT = new Thread(pi);
        mybbT.setName("mybb");
        piT.setName("pi");
        mybbT.start();
        piT.start();
    }
}

class Card{
    private String id;
    private double balance;

    public Card(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CardUser implements Runnable{
    private Card card;
    private String name;
    //专门用来做线程同步的object对象，因为多个对象要使用，应该设置为静态（不静态不是同一个object）
    private static Object object = new Object();

    public CardUser(Card card, String name) {
        this.card = card;
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //取款方法，从卡里取num数目的钱
    //设置为同步方法，同一时刻只能有一个线程访问该方法
    public void withDraw(double num){
        //1、当多个线程执行到这里时就会去争夺object锁
        //2、注意这里synchronized提供的是非公平锁，可以出现连续一个线程执行成功的情况
        //3、执行完后就会释放object对象
        //4、争夺不到object对象锁，就进入blocked状态，准备继续争夺
        synchronized (object){
            if(this.card.getBalance()>0){
                this.card.setBalance(this.card.getBalance() - num);
                System.out.println(Thread.currentThread().getName()+"取款成功，取了"+num+"块钱，目前卡里还剩"+this.card.getBalance());
            }else{
                System.out.println("余额为0，不能取款了");
            }
        }
    }

    @Override
    public void run() {
        while (this.card.getBalance()>0){
            withDraw(100);
        }
    }
}