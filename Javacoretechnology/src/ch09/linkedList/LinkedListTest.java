package ch09.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add("ttr");
        a.add("lrl");
        a.add("zyc");

        var b = new LinkedList<String>();
        b.add("cm");
        b.add("byp");
        b.add("lpe");
        b.add("wlg");
        b.addFirst("lll");

        String wlg = b.set(1,"wlg");
        int cm = b.lastIndexOf("wlg");
        System.out.println(cm);

        // merge the words from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        // bulk operation: remove all words in b from a
        a.removeAll(b);
        System.out.println(a);
    }
}
