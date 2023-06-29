package org.example;

public class LazySingletonHolder {
    private LazySingletonHolder(){};

    private static class LazySingletonBuilder{
        private static final LazySingletonHolder LAZY_SINGLETON_HOLDER = new LazySingletonHolder();
    }
    public static LazySingletonHolder getInstance(){
        return LazySingletonBuilder.LAZY_SINGLETON_HOLDER;
    }


}
