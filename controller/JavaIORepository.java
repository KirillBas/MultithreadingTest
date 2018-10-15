package ru.basharin.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaIORepository implements Runnable{
    private final String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\filesPaths.txt";
    private final File file = new File(FILE_NAME);
    private Thread thread;
    private volatile List<String> result = readPathFiles();

    public JavaIORepository(Thread thread) {
        new Thread(this);
    }

    private List<String> readPathFiles() {
        List<String> stringList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            return stringList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void readFile(String string) {
        File file = new File(string);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("Расширение файла: " + file.getName());
            System.out.println("Размер файла: " + file.length());
            while ((line = br.readLine()) != null) {
                System.out.println("Содержание файла: " + line);
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: 15.10.2018 не решена задача параллельности, если передать в run метод readFile, то все потоки выполнят его
    @Override
    public void run() {
        for(String resultRead: result) {
            readFile(resultRead);
        }
    }
}
