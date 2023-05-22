import java.util.Scanner;

public class Recursive_Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(RecursiveDraw(num));
    }

    private static String RecursiveDraw(int num) {
        StringBuilder print = new StringBuilder();
        String row = BuildRow(num , '*');
        print.append(row);

        if(num <= 0){
            return print.toString();
        }

        String toAppend = RecursiveDraw(num -1 );

        if(toAppend.toString().length() != 0) {
            print.append(System.lineSeparator()).append(toAppend);


            String row2 = BuildRow(num, '#');
            print.append(System.lineSeparator()).append(row2);
        }
        return print.toString().trim();
    }

    private static String BuildRow(int num , char symbol) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(symbol).repeat(Math.max(0, num)));
        return builder.toString();
    }
}
