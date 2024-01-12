package ProgramingFundamentalsJava.Programming_Fundamentals_Final_Exam_07_August_2022;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mapLikes = new LinkedHashMap<>();
        Map<String, Integer> mapComments = new LinkedHashMap<>();
        String input = scanner.nextLine();
        String username = "";

        while (!input.equals("Log out")) {
            String[] command = input.split(": ");
            switch (command[0]) {
                case "New follower":
                    username = command[1];
                    if (!mapLikes.containsKey(username)) {
                        mapLikes.put(username, 0);
                        mapComments.put(username, 0);
                    }
                    break;
                case "Like":
                    username = command[1];
                    int count = Integer.parseInt(command[2]);
                    if (!mapLikes.containsKey(username)) {
                        mapLikes.put(username, count);
                        mapComments.put(username , 0);
                    } else {
                        int currentLikes = mapLikes.get(username);
                        mapLikes.put(username, currentLikes + count);
                    }
                    break;
                case "Comment" :
                    username = command[1];
                    if(!mapComments.containsKey(username)){
                        mapComments.put(username , 1);
                        mapLikes.put(username ,0);
                    }else{
                        int currentComments = mapComments.get(username);
                        mapComments.put(username , currentComments + 1);
                    }
                    break;
                case "Blocked":
                    username = command[1];
                    if(mapComments.containsKey(username)){
                        mapComments.remove(username);
                        mapLikes.remove(username);
                    }else{
                        System.out.printf("%s doesn't exist.%n",username);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.printf("%d followers%n",mapComments.size());
        for(Map.Entry<String , Integer> entryComm :mapComments.entrySet()){
            for(Map.Entry<String , Integer> entryLikes : mapLikes.entrySet()){
                if(entryComm.getKey().equals(entryLikes.getKey())){
                    System.out.printf("%s: %d%n",entryComm.getKey(),entryComm.getValue()+entryLikes.getValue());
                    break;
                }
            }
        }
    }
}
