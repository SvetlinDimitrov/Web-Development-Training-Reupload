package JavaAdvance.Workshop_Custom_Data_Structures;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Steck steck = new Steck();
        steck.push(13);
        steck.push(42);
        steck.push(1324);


        steck.forEach(e->System.out.println(e));

    }
}
