package org.example.tests;

import org.example.runables.UserThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        File file = new File("src/main/resources/new_users.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String userInputData = bufferedReader.readLine();
        List<String> inputs = new ArrayList<>();

        while (userInputData != null) {
           inputs.add(userInputData);
            userInputData = bufferedReader.readLine();
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (String input : inputs) {
            Future<Integer> result = executor.submit(new UserThread(input));
            System.out.println(result.get());
        }

        executor.shutdown();
        System.out.println("Done");
    }
}
