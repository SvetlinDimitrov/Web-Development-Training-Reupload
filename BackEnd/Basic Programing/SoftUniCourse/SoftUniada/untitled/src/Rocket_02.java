import java.util.Scanner;

public class Rocket_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder build = new StringBuilder();

        for (int k = 0; k < n+n+1+1+n/2 ; k++) {
            for (int i = 0; i < n * 2 + 1; i++) {
                if(i != n-k){
                    build.append("_");
                }else{
                    
                    if(i==0){
                        build.append("^");
                    }
                }
            }
        }
    }
}
