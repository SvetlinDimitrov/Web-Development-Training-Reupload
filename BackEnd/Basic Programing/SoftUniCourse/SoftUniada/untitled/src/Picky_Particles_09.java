import java.util.Arrays;
import java.util.Scanner;

public class Picky_Particles_09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] firstTeam = new int[people];
        int[] secondTeam = new int[people];
        int[] parents = new int[people];
        boolean[] used = new boolean[people];
        Arrays.fill(parents, -1);
        int[] players = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxLength = -1;
        int index = -1;

        for (int i = 0; i < players.length; i++) {
            firstTeam[i] = 1;

            for (int j = 0; j < i; j++) {
                if (players[i] > players[j] && firstTeam[i] <= firstTeam[j]) {
                    firstTeam[i] = firstTeam[j] + 1;
                    parents[i] = j;
                }

            }
            if (firstTeam[i] > maxLength) {
                maxLength = firstTeam[i];
                index = i;
            }
        }
        int count = 0;
        while (index != -1) {
            used[index] = true;
            index = parents[index];
            count++;
        }

        maxLength =-1;
        Arrays.fill(parents, -1);
        for (int i = 0; i < players.length; i++) {
            if(used[i]){continue;}
            secondTeam[i] = 1;

            for (int j = 0; j < i; j++) {
                if (players[i] < players[j] && secondTeam[i] <= secondTeam[j]) {
                    secondTeam[i] = secondTeam[j] + 1;
                    parents[i] = j;
                }
            }
            if (secondTeam[i] > maxLength) {
                maxLength = secondTeam[i];
                index = i;
            }
        }

        while (index != -1) {
            used[index] = true;
            index = parents[index];
            count++;
        }
        System.out.println(people - count);
    }
}
