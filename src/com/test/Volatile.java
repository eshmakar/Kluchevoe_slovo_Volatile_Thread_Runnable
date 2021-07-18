package com.test;

public class Volatile {
    private static volatile int count;//изменения одного потока видны для всех потоков
    private static  int count0;
    private static  int count1;
    private static  int count2;

    public static void main(String[] args) throws InterruptedException {
        new Potok0().start();
        new Potok1().start();
        new Potok2().start();

        Thread.sleep(1200);
        System.out.println();
        System.out.println("Thread-0 - " + count0);
        System.out.println("Thread-1 - " + count1);
        System.out.println("Thread-2 - " + count2);
    }


   private static class Potok0 extends Thread {
        @Override
        public void run() {
            for (; count <= 500; count++) {
                System.out.println(Thread.currentThread().getName() + " - " + count);
                count0++;
                Thread.yield();
            }
        }
    }

    private static class Potok1 extends Thread {
        @Override
        public void run() {
            for (; count <= 500; count++) {
                System.out.println(Thread.currentThread().getName() + " - " + count);
                count1++;
                Thread.yield();
            }
        }
    }

    private static class Potok2 extends Thread {
        @Override
        public void run() {
            for (; count <= 500; count++) {
                System.out.println(Thread.currentThread().getName() + " - " + count);
                count2++;
                Thread.yield();
            }
        }
    }
}