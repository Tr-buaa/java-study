package demo01;

//多个线程同时操作同一个对象
public class TestThread4  implements  Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) break;
            //模拟延时
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4, "lrl").start();
        new Thread(testThread4, "ttr").start();
        new Thread(testThread4, "byp").start();
    }
}
