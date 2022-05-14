package com.company;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Listle{
    void Remove() throws IOException;
    void PrintObject();
    static void AddObject(){}
    static void ClosestBD(){}
    static void PrintAllObjects(){}
    static void BD_to_end_of_Year(){}
    static void FileRead() throws IOException, ClassNotFoundException {};

}
class Student implements Listle, Serializable{

    private int date;
    private int month;
    private int year;
    private String name;
    private String surname;
    public static List<Student> students = new ArrayList<>();

    public Student(int date, int month, int year, String name, String surname) throws IOException,ClassNotFoundException {
        this.date = date;
        this.month = month;
        this.year = year;
        this.name = name;
        this.surname = surname;
        students.add(this);
        Student.inputFile();
    }
    public Student(){}

    public static void AddObject(){
        try {
            System.out.println("\tДата народження:");
            System.out.print("\tДень:");
            int date = new Scanner(System.in).nextInt();
            if(date>31)
            {
                System.out.print("Число не повинно бути більше 31");
                throw new Exception();
            }
            System.out.print("\tМісяць:");
            int month = new Scanner(System.in).nextInt();
            if(month>12)
            {
                System.out.println("Місяців всього 12 :)");
                throw new Exception();
            }
            System.out.print("\tРік:");
            int year = new Scanner(System.in).nextInt();
            if(year>2022)
            {
                System.out.println("Ви з майбутнього ?");
                throw new Exception();
            }
            System.out.print("\tІм'я: ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("\tПрізвище: ");
            String surname = new Scanner(System.in).nextLine();
            Student a = new Student(date, month, year, name, surname);
        }catch (Exception ex)
        {
            System.out.println("Введено не коретні дані!!!");
            AddObject();
        }
    }

    public static void FileRead() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inputFile()throws IOException,ClassNotFoundException{
        FileOutputStream writeData = new FileOutputStream("data.txt");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(students);
        writeStream.flush();
        writeStream.close();
    }
    @Override
    public void PrintObject() {
        System.out.println("\tДата народження: " + this.date + " " +this.month+" "+this.year+" ");
        System.out.println("\tІм'я: " + this.name);
        System.out.println("\tПрізвище: " + this.surname);
    }

    public static void PrintAllObjects(){
        for(int i = 0; i < students.size(); i++){
            System.out.println("Студент №" + (i + 1));
            students.get(i).PrintObject();
        }
    }

    @Override
    public void Remove() throws IOException {
        students.remove(this);
    }

    public static void ClosestBD() {
        int dat = LocalDateTime.now().getDayOfMonth();
        int mont = LocalDateTime.now().getMonthValue();
        int yea = LocalDateTime.now().getYear();
        System.out.println("Сьогоднішня дата: "+ dat + " " + " " + mont + " " + " " + yea);
        int min =12;
        for (int i=0;i<students.size();i++){// пошук найближчого місяця
            if (students.get(i).month >=mont){
                min =students.get(i).month;
            }
        }
        int mind=31;
        for (int i=0;i<students.size();i++){// пошук найближчого дня
            if (students.get(i).month == min){
                if(students.get(i).date<mind){
                    mind = students.get(i).date;
                }
            }
        }
        for (int i=0;i<students.size();i++){
            if (students.get(i).month == min && students.get(i).date <=mind){
                System.out.println("Студент № " + (i-1));
                students.get(i).PrintObject();
                System.out.println();
            }

        }
    }

    public static void BD_to_end_of_Year() {
        int day1 = LocalDateTime.now().getDayOfMonth();
        int month1= LocalDateTime.now().getMonthValue();
        int yea1 = LocalDateTime.now().getYear();
        System.out.println("Сьогоднішня дата: "+ day1 + " " + " " + month1 + " " + " " + yea1);
        for(int i=0;i<students.size();i++){
            if(students.get(i).month==month1 && students.get(i).date>= day1){
                students.get(i).PrintObject();
            }
            if (students.get(i).month > month1){
                students.get(i).PrintObject();
            }

        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String n;
        try{
            Scanner in = new Scanner(System.in);
            do {
                Student.FileRead();
                System.out.println("=====================================================================================");
                System.out.println("\t\t\t\t---Лабораторна робота №8---");
                System.out.println("\t\t\t\t\t---Список завдань---");
                System.out.println("---\t\t1 - Ввести інформацію про студента.");
                System.out.println("---\t\t2 - Вивести інформацію про студентів.");
                System.out.println("---\t\t3 - Вивести інформацію про студента з найближчим днем народження.");
                System.out.println("---\t\t4 - Вивести дані про студентів, дні народження яких ще будуть у поточному році \n---\t\t(відлік вести від поточної дати).");
                System.out.println("---\t\t5 - Видалити запис.");
                System.out.println("---\t\t6 - Завершити роботу. ");
                System.out.println("=====================================================================================");
                System.out.print("Введіть номер завдання: ");
                n = in.next();
                switch (n) {
                    case "1":
                        Student.AddObject();
                        break;
                    case "2":
                        Student.PrintAllObjects();
                        break;
                    case "3":
                        Student.ClosestBD();
                        break;
                    case "4":
                        Student.BD_to_end_of_Year();
                        break;
                    case "5":
                        System.out.print("Введіть номер студента: ");
                        int nn = new Scanner(System.in).nextInt();
                        System.out.println("Запис видалено.");
                        if(nn < 1 || nn > Student.students.size()){
                            System.out.println("Студента з таким номером нема!");
                            break;
                        }
                        Student.students.remove(nn-1);
                        Student.inputFile();
                        break;
                    case "6":
                        return;
                }
            } while (n != "6");
        }
        catch (Exception ex){
            System.out.println("Не коректно введены значення!");
            main(args);
        }


    }
}

