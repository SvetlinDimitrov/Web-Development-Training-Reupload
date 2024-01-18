package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConditionExample {
    static class BuilderThread extends Thread {
        private final Integer id;
        private final Integer allWorkers;
        private static final Lock lock = new ReentrantLock();
        private static Integer blocksToPut = 10;
        public static Integer passingTurn = 0;

        public BuilderThread(Integer id, Integer allWorkers) {
            this.id = id;
            this.allWorkers = allWorkers;

        }

        @Override
        public void run() {
            while (blocksToPut > 0) {
                try {
                    lock.lock();
                    if (blocksToPut % allWorkers == id && blocksToPut > 0) {
                        System.out.println("Builder " + id + " put the " + blocksToPut + " block");
                        blocksToPut--;
                    } else {
                        passingTurn++;
                        System.out.println("Builder " + id + " is passing the turn");
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class BuilderThreadConditionImp extends Thread {
        private final Integer id;
        private final Integer allWorkers;
        private static final Lock lock = new ReentrantLock();
        private static final Condition conditionLock = lock.newCondition();
        private static Integer blocksToPut = 10;
        public static Integer passingTurn = 0;

        public BuilderThreadConditionImp(Integer id, Integer allWorkers) {
            this.id = id;
            this.allWorkers = allWorkers;
        }

        @Override
        public void run() {
            while (blocksToPut > 0) {
                try {
                    lock.lock();
                    if (blocksToPut % allWorkers == id && blocksToPut > 0) {
                        System.out.println("Builder " + id + " put the " + blocksToPut + " block");
                        blocksToPut--;
                        conditionLock.signalAll();
                    } else {
                        passingTurn++;
                        conditionLock.await();
                        System.out.println("Smart Builder " + id + " is passing the turn");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

//      Not optimized using condition
        int workersSize = 2;
        BuilderThread builder1 = new BuilderThread(0, workersSize);
        BuilderThread builder2 = new BuilderThread(1, workersSize);
        builder1.start();
        builder2.start();
        builder1.join();
        builder2.join();

////    Optimized using condition
        int workerSize = 2;
        BuilderThreadConditionImp smartBuilder1 = new BuilderThreadConditionImp(0, workerSize);
        BuilderThreadConditionImp smartBuilder2 = new BuilderThreadConditionImp(1, workerSize);
        smartBuilder1.start();
        smartBuilder2.start();
        smartBuilder1.join();
        smartBuilder2.join();

        System.out.println("Not optimized version made " + BuilderThread.passingTurn + " passing before finishing the job");
        System.out.println("Optimized version with conditions made " + BuilderThreadConditionImp.passingTurn + " passing before finishing the job");
    }
}
