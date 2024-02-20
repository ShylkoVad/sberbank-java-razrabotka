package ru.sberbank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // считывание файла
        String fileName = "ВС_Java.csv";

//        List<City> cities = readCitiesFromFile(fileName); // вывод списка
//        List<City> cities = sortingName(fileName); // сортировка по имени
//        List<City> cities = sortingDistrictName(fileName); // сортировка по федеральному округу и имени
        citizenMax(fileName);
        citizenMax_II(fileName);

//         Выводим полученные объекты City в консоль
//        for (City city : cities) {
//            System.out.println(city);
//        }
    }

    public static List<City> readCitiesFromFile(String fileName) {
        List<City> cities = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] cityData = input.split(";");

//                cities.add(cityData);

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

    // сортировка по имени
    public static List<City> sortingName(String fileName) {
        List<City> cities = readCitiesFromFile(fileName);
        Collections.sort(cities, Comparator.comparing(City::getName));
        return cities;
    }

    // сортировка по федеральному округу и имени
    public static List<City> sortingDistrictName(String fileName) {
        List<City> cities = readCitiesFromFile(fileName);
        Collections.sort(cities, Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        return cities;
    }

    /**
     * Вариант первый решения
     */
    public static void citizenMax(String fileName) {

        int maxPopulation = 0;
        int maxNumber = 0;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] cityData = input.split(";");
                int number = Integer.parseInt(cityData[0]);
                int population = Integer.parseInt(cityData[4]);

                if (population > maxPopulation) {
                    maxPopulation = population;
                    maxNumber = number;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        System.out.println("[" + maxNumber + "]" + " " + maxPopulation);
    }

    /**
     * Вариант второй решения
     */
    public static void citizenMax_II(String fileName) {
        List<City> cities = readCitiesFromFile(fileName);
        City cityWithMaxPopulation = Collections.max(cities, Comparator.comparing(City::getPopulation));
        System.out.println("[" + cityWithMaxPopulation.getNumber() + "]" + " " + cityWithMaxPopulation.getPopulation());
    }
    public static void numberCitiesRegion (String fileName) {

    }

}
