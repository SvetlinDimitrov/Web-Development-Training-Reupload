package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PointMaker2 extends Thread {

    private final Lock lock1, lock2;
    private final Match match;
    private Integer pointsScore;

    public PointMaker2(Lock lock1, Lock lock2, Match match) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.match = match;
        pointsScore = 0;

    }

    public Integer getPointsScore() {
        return pointsScore;
    }

    @Override
    public void run() {
        while (match.getTotalPoints() < match.getLimitPoints()) {
            lock1.lock();
            lock2.lock();
//            fixing the abandonedLock
//            try {
                if (match.getTotalPoints() < match.getLimitPoints()) {
                    match.setTotalPoints(match.getTotalPoints() + 1);
                    pointsScore++;
                }
                if (match.getTotalPoints()  == 10) {
                    System.out.println(1 / 0);
                }
//            }finally {
                lock1.unlock();
                lock2.unlock();
//            }
        }
    }
}

public class AbandonedLock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        Match match = new Match(2000);

        PointMaker2 player1 = new PointMaker2(lock1, lock2, match);
        PointMaker2 player2 = new PointMaker2(lock2, lock3, match);
        PointMaker2 player3 = new PointMaker2(lock1, lock3, match);

        player1.start();
        player2.start();
        player3.start();

        player1.join();
        player2.join();
        player3.join();

        System.out.println("Final totalPoints: " + match.getTotalPoints());
        System.out.println("Player1 points: " + player1.getPointsScore());
        System.out.println("Player2 points: " + player2.getPointsScore());
        System.out.println("Player3 points: " + player3.getPointsScore());
    }
}
