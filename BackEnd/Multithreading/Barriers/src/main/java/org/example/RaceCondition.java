package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceCondition {
    static class HighestPoint extends Thread {
        private final String type;
        private static Integer score = 0;
        private final Lock lock;

        HighestPoint(String type, Lock lock) {
            this.type = type;
            this.lock = lock;
        }

        @Override
        public void run() {

            if (type.equals("+")) {
                lock.lock();
                score += 1;
                lock.unlock();
            } else if (type.equals("*")) {
                lock.lock();
                score *= 2;
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Random random = new Random();
        Set<Integer> randomMultiplayerIndexes = new HashSet<>();

        int plus = 7;
        int multiplayer = 3;
        int maxPointAnswer = plus;

        do {
            int index = random.nextInt(plus + multiplayer);
            randomMultiplayerIndexes.add(index);
        } while (randomMultiplayerIndexes.size() != multiplayer);


        for (int i = 0; i < plus + multiplayer; i++) {
            if (randomMultiplayerIndexes.contains(i)) {
                new HighestPoint("*", lock).start();
                maxPointAnswer *= 2;
            } else {
                new HighestPoint("+", lock).start();
            }

        }

        Thread.sleep(500);
        boolean maxScore = HighestPoint.score == maxPointAnswer;
        System.out.println(maxScore ?
                "Threads managed to sync them self to make the highest possible score" :
                "Threads did not make the highest score possible. They made " + HighestPoint.score + " but the highest is " + maxPointAnswer);
    }
}
