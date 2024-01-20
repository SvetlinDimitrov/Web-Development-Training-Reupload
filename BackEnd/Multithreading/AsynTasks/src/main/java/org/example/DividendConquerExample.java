package org.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DividendConquerExample {
    static class RecursivePool extends RecursiveTask<Long>{
        private final int lowerIndex;
        private final int higherIndex;
        private final int [] array;

        RecursivePool(int lowerBound, int higherBound, int[] array) {
            this.lowerIndex = lowerBound;
            this.higherIndex = higherBound;
            this.array = array;
        }

        @Override
        protected Long compute() {
            if (higherIndex < lowerIndex) {
                return 0L;
            } else if (higherIndex - lowerIndex <= 10_000) {
                long sum = 0;
                for (int i = lowerIndex; i < higherIndex; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int midIndex = (lowerIndex + higherIndex) / 2;
                RecursivePool leftPart = new RecursivePool(lowerIndex, midIndex, array);
                RecursivePool rightPart = new RecursivePool(midIndex, higherIndex, array);

                leftPart.fork();
                rightPart.fork();

                Long leftPartSum = leftPart.join();
                Long rightPartSum = rightPart.join();

                return leftPartSum + rightPartSum;
            }
        }
    }

    public static void main(String[] args) {
        int START_INDEX = 0;
        int [] TEST_ARRAY = initArray(1_000_000_000);
        int END_INDEX = TEST_ARRAY.length;
        int NUMBER_OF_TESTS = 10;

        System.out.println("Evaluating Sequential Impl.");
        long warpUpSeq = runSequentialTask(START_INDEX, END_INDEX , TEST_ARRAY); // warmUp
        double sequentialTime = 0;
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            long start = System.currentTimeMillis();
            runSequentialTask(START_INDEX, END_INDEX , TEST_ARRAY);
            sequentialTime += System.currentTimeMillis() - start;
        }
        sequentialTime /= NUMBER_OF_TESTS;

        System.out.println("Evaluating Parralel Impl.");
        ForkJoinPool warmUp = ForkJoinPool.commonPool();
        warmUp.invoke(new RecursivePool(START_INDEX , END_INDEX, TEST_ARRAY));
        warmUp.shutdown(); //warUp

        double parallelTime = 0;
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            long start = System.currentTimeMillis();
            ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
            forkJoinPool.invoke(new RecursivePool(START_INDEX , END_INDEX, TEST_ARRAY));
            forkJoinPool.shutdown();
            parallelTime += System.currentTimeMillis() - start;
        }
        parallelTime /= NUMBER_OF_TESTS;

        System.out.format("Average Sequential Time: %.1f ms\n" , sequentialTime);
        System.out.format("Average Parallel Time: %.1f ms\n" , parallelTime);
        System.out.format("Speedup: %.2f\n", sequentialTime/parallelTime);
        System.out.format("Efficiency: %.2f%%\n", 100* (sequentialTime/parallelTime)/Runtime.getRuntime().availableProcessors());

    }
    private static long runSequentialTask(int beginIndex , int lastIndex , int [] array) {
        long result = 0;
        for (int i = beginIndex; i < lastIndex; i++) {
            result += array[i];
        }
        return result;
    }
    private static int[] initArray (int end){
        int [] arrayToFill = new int[end];
        for (int i = 1; i <= end; i++) {
            arrayToFill[i-1] = i;
        }
        return arrayToFill;
    }

}
