package lambda;

import org.apache.commons.io.function.IOConsumer;

public class TestLambda2 {


    public static void main(String[] args) {


        Ilove ilove = a ->
                System.out.println("I love you" + a);


        ilove.love(2);
    }
}


interface Ilove {
    void love(int a);
}
