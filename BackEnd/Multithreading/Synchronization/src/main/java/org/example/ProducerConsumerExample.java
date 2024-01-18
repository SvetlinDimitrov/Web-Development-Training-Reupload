package org.example;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

public class ProducerConsumerExample {
    static class LotteryAnnouncementThread extends Thread{
        private final BlockingQueue<Integer> buffer;
        private final Integer playersCount;

        public LotteryAnnouncementThread(BlockingQueue<Integer> que, Integer playersCount) {
            this.buffer = que;
            this.playersCount = playersCount;
        }

        public void run(){
            Random random = new Random();
            for (int i = 0; i <= 6*playersCount; i++) {
                buffer.add(random.nextInt(10));
            }
        }

    }
    static class LotteryPlayerThread extends Thread {
        private final BlockingQueue<Integer> buffer;
        private final ArrayList<Integer> lotteryTicket = new ArrayList<>();

        public LotteryPlayerThread(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            List<Integer> winningNumbers = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                lotteryTicket.add(random.nextInt(10));
            }
            while (winningNumbers.size()  < 6) {
                try {
                    Thread.sleep(100);
                    Integer winningNumber = buffer.take();
                    winningNumbers.add(winningNumber);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String result = Thread.currentThread().getName() +
                    " has " +
                    lotteryTicket.stream().map(String::valueOf).collect(Collectors.joining(",")) +
                    " with winning numbers " +
                    winningNumbers.stream().map(String::valueOf).collect(Collectors.joining(",")) +
                    " with " +
                    countMatchNumbers(winningNumbers, lotteryTicket) +
                    " matches.";

            System.out.println(result);
        }

        private int countMatchNumbers(List<Integer> winningNumbers , List<Integer> playerNumbers){
            Set<Integer> matchedIndex = new HashSet<>();
            for (int i = 0; i < winningNumbers.size(); i++) {
                for (Integer playerNumber : playerNumbers) {
                    if (winningNumbers.get(i).equals(playerNumber) && !matchedIndex.contains(i)) {
                        matchedIndex.add(i);
                        break;
                    }
                }
            }
            return matchedIndex.size();
        }
    }

    public static void main(String[] args) {
        int playerCount = 12;
        ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(playerCount * 6 + 1);
        new LotteryAnnouncementThread(buffer , playerCount).start();
        for (int i = 0; i < playerCount; i++) {
            new LotteryPlayerThread(buffer).start();
        }

    }
}
