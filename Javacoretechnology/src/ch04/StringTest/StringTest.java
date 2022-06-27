package ch04.StringTest;

import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

public class StringTest {
    public static void main(String[] args) {
        String greeting = "Hello";
        var a = "Hello".equals(greeting);
        System.out.println(a);
        System.out.println(greeting.repeat(2));
        System.out.println(greeting.substring(0,3));
        StringBuilder builder = new StringBuilder();
        builder.append('a');
        builder.append(greeting);
        System.out.println(builder);
        Scanner in = new Scanner(System.in);
//        String name = in.nextLine();
//        System.out.println(name);
//        int age = in.nextInt();
//        System.out.println(age);
//        System.out.printf("hello %s , %4d",name, age);
        int[] arr = {1,2,3,4,5,65,7};
        Arrays.sort(arr);
        for(var element : arr)
            System.out.println(element);
        System.out.println(Arrays.toString(arr));
        System.out.println(new Date());
    }
}
