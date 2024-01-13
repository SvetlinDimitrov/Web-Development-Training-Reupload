package org.example.runables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SecondThread implements Runnable{
    @Override
    public void run() {
        File file = new File("D:\\Workstation\\Web-Development-Training-Reupload\\BackEnd\\Multithreading\\res\\text.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String reader = bufferedReader.readLine();
            while(reader != null){
                System.out.println(Thread.currentThread().getName() + " "+ reader);
                reader = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
