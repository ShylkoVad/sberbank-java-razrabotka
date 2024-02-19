package ru.sberbank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // считывание файла
        String fileName = "ВС_Java.csv";

        List<City> cities = readCitiesFromFile(fileName);

        // Выводим полученные объекты City в консоль
        for (City city : cities) {
            System.out.println(city);
        }
    }

    public static List<City> readCitiesFromFile(String fileName) {
        List<City> cities = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] cityData = input.split(";");

                if (cityData.length == 6) {
                    City city = new City(
                            Integer.parseInt(cityData[0]),
                            cityData[1],
                            cityData[2],
                            cityData[3],
                            Integer.parseInt(cityData[4]),
                            cityData[5]);
                    cities.add(city);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
//            e.printStackTrace();
        }
        return cities;
    }
}
