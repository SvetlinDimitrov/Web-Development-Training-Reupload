package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PointMaker extends Thread {

    private final Lock lock1, lock2;
    private final Match match;
    private Integer pointsScore;

    public PointMaker(Lock lock1, Lock lock2, Match match) {
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
            if (match.getTotalPoints() < match.getLimitPoints()) {
                match.setTotalPoints(match.getTotalPoints() + 1);
                pointsScore++;
            }
            lock1.unlock();
            lock2.unlock();
        }
    }
}

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        Match match = new Match(200);

        PointMaker player1 = new PointMaker(lock1, lock2, match);
        PointMaker player2 = new PointMaker(lock2, lock3, match);
        PointMaker player3 = new PointMaker(lock3, lock1, match);

//        to fix the deadLock use this order of locks
//        PointMaker player1 = new PointMaker(lock1, lock2, match);
//        PointMaker player2 = new PointMaker(lock2, lock3, match);
//        PointMaker player3 = new PointMaker(lock1, lock3, match);

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