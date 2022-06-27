package demo01;

//实现runnable接口，重写run方法
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("lrl--" + i);
        }
        //super.run();
    }
    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象
        new Thread(testThread3).start();


        for (int i = 0; i < 200; i++) {
            System.out.println("ttr--" + i);
        }
    }
}
