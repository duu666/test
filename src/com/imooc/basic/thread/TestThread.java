package com.imooc.basic.thread;

public class TestThread {

    public static void main(String[] args) {
        test2();
        //daemonThread();
    }

    public static void test1(){
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t1= new Thread(){
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();
                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }

    public static void daemonThread(){
        Thread t1= new Thread(){
            public void run(){
                int seconds =0;

                while(true){
                    try {
                        System.out.println("you see the log");
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
    }

    public static void test2(){
        final Hero hero = new Hero();
        hero.name = "盖伦";
        hero.hp = 616;
        hero.fullHp = 616;
        for (int i=0; i < 5;i++ ) {
            Thread t1 = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        hero.hurt();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
        }
        for (int i=0;i < 2;i++) {
            Thread t2 = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        hero.recover();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };
            t2.start();
        }

    }
}
