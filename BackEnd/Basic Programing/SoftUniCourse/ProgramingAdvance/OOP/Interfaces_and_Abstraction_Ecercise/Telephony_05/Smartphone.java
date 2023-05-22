import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        boolean isDigit;
        StringBuilder print = new StringBuilder();
        for (String url : urls) {
            isDigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    isDigit = true;
                }
            }
            if (isDigit) {
                print.append("Invalid URL!").append(System.lineSeparator());
            } else {
                print.append(String.format("Calling... %s", url)).append(System.lineSeparator());
            }
        }
        return print.toString();
    }

    @Override
    public String call() {
        StringBuilder print = new StringBuilder();
        boolean isDigit;
        for (String url : numbers) {
            isDigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isLetter(url.charAt(i))) {
                    isDigit = true;
                }
            }
            if (isDigit) {
                print.append("Invalid number!").append(System.lineSeparator());
            } else {
                print.append(String.format("Calling... %s", url)).append(System.lineSeparator());
            }
        }
        return print.toString();
    }
}
