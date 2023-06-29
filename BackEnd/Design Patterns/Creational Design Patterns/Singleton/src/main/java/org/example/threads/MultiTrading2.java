package org.example.threads;

import org.example.LazySingletonHolder;

public class MultiTrading2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(LazySingletonHolder.getInstance().hashCode());
        }
    }
}
