package ru.basharin;

import ru.basharin.controller.JavaIORepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();
        Thread thread4 = new Thread();
        ExecutorService es = Executors.newFixedThreadPool(4);
        System.out.println("Start");
        es.execute(new JavaIORepository(thread1));
        es.execute(new JavaIORepository(thread2));
        es.execute(new JavaIORepository(thread3));
        es.execute(new JavaIORepository(thread4));
        es.shutdown();
        System.out.println("Finish");
    }
}
