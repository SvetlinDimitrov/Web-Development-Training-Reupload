package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Class<BlackBoxInt> blackBox = BlackBoxInt.class;
        Constructor<BlackBoxInt> con = blackBox.getDeclaredConstructor(int.class);
        con.setAccessible(true);
        BlackBoxInt black = con.newInstance(0);
        Method[] methods = blackBox.getDeclaredMethods();

        Field field  = blackBox.getDeclaredField("innerValue");
        field.setAccessible(true);

        while(!input.equals("END")){
            String command = input.split("_")[0];
            int num = Integer.parseInt(input.split("_")[1]);
            Method method = Arrays.stream(methods)
                    .filter(e->e.getName().toString().equals(command))
                    .findFirst()
                    .orElse(null);

            if(method != null) {
                method.setAccessible(true);
                method.invoke(black, num);
                System.out.println(field.get(black));
            }
            input=scanner.nextLine();
        }
    }
}
