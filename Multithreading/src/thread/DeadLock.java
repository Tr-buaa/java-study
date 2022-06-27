package thread;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"lrl");
        Makeup g2 = new Makeup(1,"ttr");
        g1.start();
        g2.start();
    }
}


class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红锁");
                Thread.sleep(1000);


            }
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子锁");
            }
        }
        else {
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子锁");
                Thread.sleep(2000);


            }
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红锁");
            }
        }
    }
}