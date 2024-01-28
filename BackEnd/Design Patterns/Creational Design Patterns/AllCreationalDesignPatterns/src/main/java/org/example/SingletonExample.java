package org.example;

public class SingletonExample {
    static class SingleInstance{
        private static SingleInstance singleInstance;

        private SingleInstance(){};

        public static synchronized SingleInstance getInstance(){
            if(singleInstance == null){
                singleInstance = new SingleInstance();
            }
            return singleInstance;
        }
    }
    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.getInstance();
    }
}