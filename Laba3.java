package com.company;
import java.util.Scanner;


public class Main {

    public static void InputArray1(int mas[]) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = in.nextInt();
        }
    }

    static void Output_Mas(int mas[]) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    static void Sort(int mas[]) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    int tmp;
                    tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
            }
        }
    }

    public static int RRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayRandom(int mat[]) {
        for (int i = 0; i < mat.length; i++) {
            mat[i] = RRandom(-100, 100);
        }
    }

    public static int Count_of_dodNum(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    static int SearchMinIdex(int mas[]) {
        int min = mas[0];
        int minIndex = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
                minIndex = i;
            }
        }
        return minIndex;

    }

    static void task1() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введіть розмірність масиву: ");
            int n = in.nextInt();
            int a[] = new int[n];
            int tmp = 0;
            InputArray1(a);
            int c=Count_of_dodNum(a);
            int b[] = new int[c];
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= 0) {
                    b[tmp] = a[i];
                    tmp++;
                }
            }
            Sort(b);
            System.out.print("Масив а: ");Output_Mas(a);
            System.out.print("Масив b: ");Output_Mas(b);
        }catch (Exception ex){
            System.out.println("Не коректно введені данні. Спробуйте ще раз");
        }

    }

    static void task2() {
        Scanner in = new Scanner(System.in);
        try {
            String choose;
            do {

                System.out.println("1 - Визначити кількість додатних елементів масиву;");
                System.out.println("2 - Добуток елементів масиву розташованих до мінімального за модулем елемента;");
                System.out.println("3 - перейти до початкового меню");
                choose = in.next();
                switch (choose) {
                    case "1":
                        System.out.println("1-Введення масиву з клавіатури");
                        System.out.println("2-Введення масиву випадковим чином від -100 до 100");
                        String choose1 = in.next();

                        System.out.print("Введіть розмірність масиву: ");
                        int n = in.nextInt();
                        int arr[] = new int[n];
                        if (choose1.equals("1")) {
                            InputArray1(arr);
                        }
                        else if (choose1.equals("2")) {
                            ArrayRandom(arr);
                            Output_Mas(arr);
                        }
                        else
                        {
                            System.out.println("\nНе коректно введені значення спробуйте ще раз");
                        }
                        System.out.println("Кількість додатніх чисел в масиві: " + Count_of_dodNum(arr) + "\n");
                        return;

                    case "2":

                        System.out.println("1-Введення масиву з клавіатури");
                        System.out.println("2-Введення масиву випадковим чином від -100 до 100");
                        choose1 = in.next();
                        System.out.print("Введіть розмірність масиву: ");
                        int j = in.nextInt();
                        int array[] = new int[j];
                        if (choose1.equals("1")) {
                            InputArray1(array); Output_Mas(array);
                        } else if (choose1.equals("2")) {
                            ArrayRandom(array);
                            Output_Mas(array);
                        } else {
                            System.out.println("\nНе коректно введені значення спробуйте ще раз");
                        }


                        // Модуль
                        int tmp = 0;
                        int arrayTMP[] = new int[array.length];

                        for (int i = 0; i < arrayTMP.length; i++) {
                            tmp = array[i];
                            tmp = Math.abs(tmp);
                            arrayTMP[i] = tmp;
                        }


                        int minIndex = SearchMinIdex(arrayTMP);
                        if (minIndex == 0) {
                            System.out.println("Мінімальним за модулем числом є перше число в масиві. Обчислення добутку неможливо ");
                        } else {
                            int dobutok = 1;
                            int i = 0;
                            do {
                                dobutok = dobutok * array[i];
                                i++;
                            } while (i < minIndex);
                            System.out.println("Результат добутку: " + dobutok);
                        }
                    case "3":
                        return;
                    default:
                        System.out.println("Не коректно введені значення спробуйте ще раз");
                }


            } while (choose != "3");
            }
        catch (Exception ex){
            System.out.println("Не коректно введені значення спробуйте ще раз");
        }
    }

    public static void main(String[] args) {

        String n ;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1-Завдання");
            System.out.println("2-Завдання");
            System.out.println("3-Завершити роботу");
            n = in.next();
            switch (n) {
                case "1":
                    System.out.println("Завдання 1");
                    task1();
                    break;
                case "2":
                    System.out.println("Завдання 2");
                    task2();
                    break;

                case "3":
                    System.out.println("Дякую що вибрали нас)");
                    return;

                default:
                    System.out.println("Не коректно введені значення спробуйте ще раз");
            }
        }while(n!="3");
    }
}
