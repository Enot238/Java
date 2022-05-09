package com.company;
import java.io. *;
import java.util.Arrays;
import java.util.Random;

import java.util.Scanner;
public class Main {
    static void SearchNouns(String str) {
        try {
            String [] s = str.split(" ");
            String  words = new String();

            if (str.isEmpty()){
                System.out.println("Рядок не повинен бути порожнім");
                return;
            }
            else {
                int c=0;
                for (int i = 0; i<s.length; i++) {
                    if (s[i].toLowerCase().startsWith("а") || s[i].toLowerCase().startsWith("о") || s[i].toLowerCase().startsWith("у")
                            || s[i].toLowerCase().startsWith("е") || s[i].toLowerCase().startsWith("и") || s[i].toLowerCase().startsWith("і")
                            || s[i].toLowerCase().startsWith("ї") || s[i].toLowerCase().startsWith("я")) {
                    }
                    else {
                        words = words + s[i] + " ";
                    }
                }
                System.out.println("Рядок з виладенними словами які починаються на голосну");
                System.out.println(words);
            }

        }
        catch (Exception ex){
            System.out.println("Не коректно введені значння");
        }
    }
    static int CountWords(String str){
        int count=0;
        String [] s = str.split(" ");
        if (str.isEmpty()){
            System.out.println("Рядок не повинен бути порожнім");
            return 0;
        }
        else {
            for (int i = 0; i<s.length; i++) {count++;}
            return count;
        }

    }
    static int countNeParnih(int arr[]){
        int count =0;

        for (int i=0;i<arr.length;i++){
            if (arr[i] %2 != 0){
                count++;
            }
        }
        return count;
    }

    static void task2(int arr[]){
        for (int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                arr[i] = arr[i]*2;
            }
            else if(arr[i] <0){
                arr[i]=Math.abs(arr[i]);
            }
            else{
                arr[i] = arr[i]+1;
            }
        }

      Output(arr);

    }

    static void Output(int arr[]){
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            String n ;
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("////////////////////////////////////////////");
                System.out.println("\t\t---Лабораторна робота №5---");
                System.out.println("\t\t\t---Список завдань---");
                System.out.println("---Завдання №1, для перегляду натисніть 1---");
                System.out.println("---Завдання №2, для перегляду натисніть 2---");
                System.out.println("---Завдання №2, для перегляду натисніть 3---");
                System.out.println("---Для завершення роботи натисніть 4--");
                System.out.println("////////////////////////////////////////////");
                System.out.print("Введіть номер завдання:");
                n = in.next();
                switch (n) {
                    case "1":
                        Scanner sttr = new Scanner(System.in);
                        System.out.println("\t\t    ---Завдання №1---");
                        System.out.println("---Варіант завдання 1 -  видаляє всі слова, що починаються з голосних літер ---");
                        System.out.println("---Варіант завдання 2 - підраховує кількість слів у тексті ---");
                        System.out.println("---Виберіть варіант завдання (1/2)---");
                        System.out.println("---Для переходу в меню введіть 3---");


                        int choose = in.nextInt();
                        if (choose ==1) {
                            System.out.println("Будь ласка, введіть слова ряду Українською мовою");
                            System.out.print("Введення рядка:");
                            String str = sttr.nextLine();
                            SearchNouns(str);
                            System.out.println();
                        }
                        else if (choose ==2) {
                            System.out.println("Будь ласка, введіть слова ряду Українською мовою");
                            System.out.print("Введення рядка:");
                            String str = sttr.nextLine();
                            System.out.println("Кількість слів в реченні: "+ CountWords(str));
                            System.out.println();
                        }
                        else if (choose ==3){main(args);}
                        else System.out.println("Не вірно введене значення"); main(args);
                        break;
                    case "2":
                        System.out.println("\t    ---Завдання №2---");
                        File readers = new File("num.txt");
                        FileInputStream inputs = new FileInputStream(readers);
                        int lengthhs = inputs.available();
                        byte [] infos = new byte[lengthhs];
                        inputs.read(infos);
                        String Vivods = new String(infos);
                        if(Vivods.isEmpty()){
                            System.out.println("Файл порожній");
                        }
                        else
                        System.out.println("Інформація яка записана в файлі: " + Vivods);
                        String [] s = Vivods.split(" ");
                        int[] array = new int [s.length];
                        for (int i=0;i<s.length;i++){ array[i] = Integer.parseInt(s[i]);}
                        System.out.println("Результат: ");
                        task2(array);
                        System.out.println();
                        String Vvod="";
                        String [] vv = Vivods.split(" ");
                        for (int i=0;i<array.length;i++){
                            Vvod = Vvod + array[i] + " ";
                        }
                        System.out.println("Запис результату в файл...");
                        PrintWriter writer = new PrintWriter("Res2.txt");
                        writer.write(Vvod);
                        writer.close();
                        System.out.print("Результат: " + Vvod);
                        System.out.println("\n////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();
                        break;

                    case "3":
                        System.out.println("\t---Завдання №3---");
                        File reader = new File("ZAV3.txt");
                        FileInputStream input = new FileInputStream(reader);
                        int lengthh = input.available();
                        byte [] info = new byte[lengthh];
                        input.read(info);
                        String Vivod = new String(info);
                        if(Vivod.isEmpty()){
                            System.out.println("Файл порожній");
                        }
                        else
                            System.out.println("Інформація яка записана в файлі: " + Vivod);
                        String [] ss = Vivod.split(" ");
                        int[] arrays = new int [ss.length];
                        for (int i=0;i<ss.length;i++){ arrays[i] = Integer.parseInt(ss[i]);}
                        int Counts = countNeParnih(arrays);
                        String Vvods="";
                        String [] vvs = Vivod.split(" ");
                        System.out.println("Кількість непарних чисел = " + Counts);
                        Vvod ="Кількість непарних чисел = " + Counts;
                        System.out.println("Запис результату в файл...");
                        PrintWriter writers = new PrintWriter("OutPut.txt");
                        writers.write(Vvod);
                        writers.close();
                        System.out.print("Результат: " + Vvod);
                        System.out.println("\n////////////////////////////////////////////");
                        System.out.println();
                        System.out.println();

                        break;


                    case "4":
                        System.out.println("Дякую що вибрали нас)");
                        return;
                    default:
                        System.out.println("Не коректно введені значення спробуйте ще раз");
                }
            }while(n!="4");
        }
        catch (Exception ex){
            System.out.println("ПОМИЛКА " + ex.getMessage());
            main(args);
        }
    }
}


