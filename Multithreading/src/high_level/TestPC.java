package high_level;

//利用缓冲区解决：管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }
    // 生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    //消费

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + container.pop().id + "只鸡");

        }
    }
}

//产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {
    //容器
    Chicken[] chickens = new Chicken[10];
    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果容器满了，需要等待消费者消费
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //没满，丢入产品
        chickens[count] = chicken;
        count++;
        //通知消费者消费
        this.notifyAll();

    }
    //消费者消费产品
    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //可以消费
        count--;
        Chicken chicken = chickens[count];
        //通知生产者生产
        this.notifyAll();
        return chicken;
    }


}
