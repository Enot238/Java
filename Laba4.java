package com.company;
import java.util.Scanner;
public class Main {
    static void InputArray(int array[][], int n, int m){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
    }

    static void OutputArray(int array[][], int n, int m){
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.printf("%5d", array[i][j]);
            }
            System.out.println();
        }
    }

    static void OutputArray(int mas[]) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }

    public static int RRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayRandom(int mas[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<m; j++){
                mas[i][j] = RRandom(-100, 100);
            }
        }
    }

    static void task1() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть розмірність двохвимірного масиву");
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[][] = new int[n][m];
            int brr[] = new int [m];

            System.out.println("Виберіть спосіб введення масиву \n \t 1 - Введення з клавіатури  \n \t 2 - Введення рандомних значень від -100 до 100");
            int a = in.nextInt();
            if(a==1){
                System.out.println("Введіть значення масиву");
                InputArray(arr, n, m);
                OutputArray(arr, n, m);
            }

            if(a==2){
                ArrayRandom(arr,n,m);
                OutputArray(arr, n, m);
            }
            else{
                System.out.println("Не правильно введене значення, спробуйте ще раз");
                System.out.println();
                task1();

            }

            System.out.println();
            int minel = arr[0][0];
            int j=0;

            for (int i = 0; i < m; i++) {
                for (j=0;j<n;j++) {
                    if (minel > arr[j][i]){
                        minel = arr [j][i];
                    }
                }
                System.out.println("stovp  #" + (i+1) + "  minimalnie - " + minel);
                brr [i] = minel;
                minel = 1000;
            }

            System.out.print("Массив b - ");
            OutputArray(brr);


        }catch (Exception ex){
            System.out.println("Не коректно введені данні. Спробуйте ще раз");
            task1();
        }

    }


    static int SearchMinInArr(int arr[][],int n, int m ){
        int minel = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++) {
                if (minel > arr[i][j]){
                    minel = arr [i][j];
                }
            }
        }
        return minel;
    }
    static int SearchMaxInArr(int arr[][],int n, int m ){
        int maxel = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++) {
                if (maxel < arr[i][j]){
                    maxel = arr [i][j];
                }
            }
        }
        return maxel;
    }

    static void task2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність двохвимірного масиву");
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[][] = new int[n][m];

        System.out.println("Виберіть спосіб введення масиву \n \t 1 - Введення з клавіатури  \n \t 2 - Введення рандомних значень від -100 до 100");
        int a = in.nextInt();
        if(a==1){
            System.out.println("Введіть значення масиву");
            InputArray(arr, n, m);
            OutputArray(arr, n, m);
        }
        if(a==2){
            ArrayRandom(arr,n,m);
            OutputArray(arr, n, m);
        }
        else{
            System.out.println("Не правильно введене значення, спробуйте ще раз");
            System.out.println();
            task2();
        }

        int min = arr[0][0];
        int max = arr[0][0];
        int minx=0;
        int miny=0;
        int maxx=0;
        int maxy=0;
        int ss=0;

        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++) {
                if (min > arr[i][j]){
                    min = arr [i][j];
                    minx =i;
                    miny=j;
                }
                else if (max < arr[i][j]){
                    max = arr [i][j];
                    maxx=i;
                    maxy=j;
                }
            }
        }
        arr[minx][miny]= max;
        arr[maxx][maxy]= min;
        System.out.println("Мінімільний елемент" + min + "\n Максимальний елемент" + max);
        OutputArray(arr,n,m);
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

