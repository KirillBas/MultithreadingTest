package ru.basharin.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesReader implements Runnable {
    private String fileName;

    public FilesReader(String fileName) {
        this.fileName = fileName;
    }

    public FilesReader() {
        this.fileName = fileName;
    }

    public List<String> readPathFiles() {
        String FILE_NAME = "src\\main\\java\\ru\\basharin\\resources\\filesPaths.txt";
        List<String> stringList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(FILE_NAME))) {
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            return stringList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // TODO: 15.10.2018 не решена задача параллельности, если передать в run метод readFile, то все потоки выполнят его
    @Override
    public void run() {
        System.out.println("start thread: " + Thread.currentThread().getName());
        File file = new File(fileName);
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
        System.out.println("finish thread: " + Thread.currentThread().getName());
        System.out.println("");
    }
}
