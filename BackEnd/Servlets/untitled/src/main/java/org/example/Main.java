package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(testArray(s , t));
    }

    private static boolean testArray(String s, String t){
        int index = 0;

        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(index) == t.charAt(i)){
                index++;
                if(index == s.length()){return true;}
            }
        }
        return false;
    }
}

