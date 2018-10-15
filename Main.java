package ru.basharin;

import ru.basharin.controller.JavaIORepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread();
        ExecutorService es = Executors.newFixedThreadPool(4);
        System.out.println("Start");
        es.submit(new JavaIORepository(thread));
        es.shutdown();
        System.out.println("Finish");
    }
}
