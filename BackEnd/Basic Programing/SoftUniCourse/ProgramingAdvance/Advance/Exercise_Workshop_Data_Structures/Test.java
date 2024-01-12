package JavaAdvance.Exercise_Workshop_Data_Structures;

import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        LinkedListTailPrev list = new LinkedListTailPrev();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        int [] arr = list.toArray();
        Arrays.stream(arr).forEach(e-> System.out.println(e));
    }
}
