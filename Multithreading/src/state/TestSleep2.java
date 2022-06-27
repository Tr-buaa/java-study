package state;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestSleep2 {
    public static void main(String[] args) {
        Date starttime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(starttime));
                starttime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static public void tenDown() throws InterruptedException {
        int num = 10;

        while (true) {
            Thread.sleep(100);
            System.out.println(num--);
            if(num <= 0) break;
        }
    }
}
