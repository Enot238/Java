package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Listle{
    static float Avg(List<work_day> work_days)
    {
        return 0;
    }
    static int Min(List<work_day> work_days)
    {
        return 0;
    }
    static int Count_way(List<work_day> work_days)
    {
        return 0;
    }
    void Remove();
    void PrintObject();
    static void AddObject(){}
    static void PrintAllObjects(){}
}
abstract class water_pull implements  Listle,Serializable
{
    protected String name;
    protected String adress;
    public water_pull(){}
}
class work_day extends water_pull implements Listle,Serializable {
    private String day;
    private int count_people;
    private int count_way;
    public static List<work_day> work_days = new ArrayList<>();

    public work_day() {
    }

    public work_day(String name, String adress, String day, int count_people, int count_way)throws IOException,ClassNotFoundException {
        this.name = name;
        this.adress = adress;
        this.day = day;
        this.count_people = count_people;
        this.count_way = count_way;
        work_days.add(this);
        work_day.inputFile();
    }

    @Override
    public void Remove() {
        work_days.remove(this);
    }

    @Override
    public void PrintObject() {
        System.out.println("\tНазва: " + this.name);
        System.out.println("\tАдреса: " + this.adress);
        System.out.println("\tДата: " + this.day);
        System.out.println("\tКількість відвідувачів: " + this.count_people);
        System.out.println("\tКількість доріжок: " + this.count_way);
    }

    public static void PrintAllObjets() {
        for (int i = 0; i < work_days.size(); i++) {
            System.out.println("Басейн №" + (i + 1));
            work_days.get(i).PrintObject();
        }
    }

    public static void AddObject() {
        try {
            System.out.println("\tВведіть назву басейну: ");
            String name = new Scanner(System.in).nextLine();
            System.out.println("\tВведіть aдресу: ");
            String adress = new Scanner(System.in).nextLine();
            System.out.println("\tВведіть дату: ");



            String day = new Scanner(System.in).nextLine();
            System.out.print("\tВведіть кількість людей: ");
            int count_people = new Scanner(System.in).nextInt();
            System.out.print("\tВведіть кількість доріжок: ");
            int count_way = new Scanner(System.in).nextInt();
            work_day a = new work_day(name, adress, day, count_people, count_way);
        } catch (Exception ex) {
            System.out.println("Введено некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            AddObject();
        }
    }

    public static float Avg(List<work_day> work_days) {
        float cou = 0;
        for (int i = 0; i < work_days.size(); i++) {
            cou += work_days.get(i).count_people;
        }
        System.out.println("Середня кількість відвідувачів: " + cou / work_days.size());
        return cou / work_days.size();
    }

    public static int Min(List<work_day> work_days) {
        int min = work_days.get(0).count_way;
        for (int i = 0; i < work_days.size(); i++) {
            if (work_days.get(i).count_way < min) {
                min = work_days.get(i).count_way;
            }
        }
        for (int k = 0; k < work_days.size(); k++) {
            System.out.println("Басейн №" + (k + 1));
            if (work_days.get(k).count_way == min) {
                work_days.get(k).PrintObject();
            }
        }
        return min;
    }

    public static int Count_way(List<work_day> work_days,int cou) {
        int cou1=0;
        for(int i = 0; i < work_days.size(); i++){
            if(work_days.get(i).count_way>=cou)
            {
                cou1++;
            }
        }
        return cou1;
    }

    public static void inputFile()throws IOException,ClassNotFoundException{
        FileOutputStream writeData = new FileOutputStream("data.txt");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(work_days);
        writeStream.flush();
        writeStream.close();
    }

    public static void FileRead() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            work_days = (List) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String n;
        Scanner in = new Scanner(System.in);
        do {
            work_day.FileRead();
            System.out.println("=====================================================================================");
            System.out.println("\t\t---Лабораторна робота №8.2---");
            System.out.println("\t\t\t---Список завдань---");
            System.out.println("---1 - Ввести інформацію про басейн.");
            System.out.println("---2 - Вивести інформацію про басейн.");
            System.out.println("---3 - Вивести середню кількість відвідувачів.");
            System.out.println("---4 - Вивести дні з мінімальною кількістю доступних доріжок");
            System.out.println("---5 - Кількість днів, коли було доступно не менше зазначеної кількості доріжок.");
            System.out.println("---6 - Видалити запис.");
            System.out.println("---7 - Завершити роботу. ");
            System.out.println("=====================================================================================");
            System.out.print("Введіть номер завдання: ");

            n = in.next();
            switch (n) {
                case "1":
                    work_day.AddObject();
                    break;
                case "2":
                    work_day.FileRead();
                    work_day.PrintAllObjets();
                    break;
                case "3":
                    work_day.Avg(work_day.work_days);
                    break;
                case "4":
                    work_day.Min(work_day.work_days);
                    break;
                case "5":
                    System.out.print("Введіть кількість доріжок: ");
                    int cou = new Scanner(System.in).nextInt();
                    System.out.println("Кількітсть доріжок більша за введене значення: " + work_day.Count_way(work_day.work_days,cou));
                    break;
                case "6":
                    System.out.print("Введіть номер басейна: ");
                    int nn = new Scanner(System.in).nextInt();
                    System.out.print("Басейн видално.");
                    if(nn < 1 || nn > work_day.work_days.size()){
                        System.out.println("Басейна з таким номером нема!");
                        break;
                    }
                    work_day.inputFile();
                    work_day.work_days.remove(nn-1);
                    break;
                case "7":
                    return;
            }
        } while (n != "7");
    }
}
