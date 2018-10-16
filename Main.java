package ru.basharin;

import ru.basharin.controller.FilesReader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        FilesReader fr = new FilesReader();
        List<String> res = fr.readPathFiles();
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i =0; i < res.size(); i++) {
            es.submit(new FilesReader(res.get(i)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
    }
}
