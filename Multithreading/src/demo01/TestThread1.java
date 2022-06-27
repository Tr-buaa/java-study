package demo01;

//
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("lrl--" + i);
        }
        //super.run();
    }
    public static void main(String[] args) {
        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //这个是普通方法调用，
        //testThread1.run();
        //start方法开启线程
        testThread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("ttr--" + i);
        }
    }
}
