package org.example;

public class Main {
    public static void main(String[] args) {
        VirtualWord virtualWord = new VirtualWord();
        virtualWord.save();
        virtualWord.flex();
        virtualWord.eatJunk();
        virtualWord.flex();
        virtualWord.goBack();
        virtualWord.flex();
        virtualWord.goBack();
    }
}