package state;

public class TestYield {
    public static void main(String[] args) {
        Myyield myyield = new Myyield();
        new Thread(myyield,"a").start();
        new Thread(myyield,"b").start();
    }
}


class  Myyield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}