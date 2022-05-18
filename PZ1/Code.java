package com.company;
import java.util.Scanner;
public class Main {
    public static int Nepar(int arr[]){
        int count =0;
        for (int i=0;i< arr.length;i++)
        {
            if (arr[i]%2!=0){
                count ++;
            }
        }
        return count;
    }
    public static int SearchMinInArr(int arr[]){
        int min = arr[0];
        for(int i=0;i< arr.length;i++){
            if(arr[i] < min){
                min=arr[i];
            }
        }
        return min;
    }
    public static void Input(int arr[]){
        Scanner in= new Scanner(System.in);
        int n;
        for(int i=0;i< arr.length;i++){
          n=in.nextInt();
          arr[i]=n;
        }
    }
    public static void Output(int arr[]){
        for(int i=0;i< arr.length;i++){
            System.out.print( arr[i] + " ");
        }
    }
    public static int zav2(int arr[]){
        int i=0;
        int sum=0;
        try {
            while(arr[i++]>=0);
            while(arr[i]>=0) {sum+=arr[i++];}
            return sum;
        }
        catch (Exception ex){
            System.out.println("В масиві нема двох від'ємних чисел");
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try {
            System.out.println("=================================");
            System.out.println("\t---Практична робота №1---");
            System.out.print("Введіть розмірність масиву - ");
            int n = in.nextInt();

            int arr[]= new int[n];
            System.out.println("Введіть масив цілих чисел");
            Input(arr);

            System.out.println("=================================");

            System.out.println("Введений масив: ");
            Output(arr);
            System.out.println();
            System.out.println("Завдання 1:");
            System.out.println("\tа) Мінімальнйи елемент масиву = " + SearchMinInArr(arr));

            System.out.println("\tб) Сума елементів між першим там другим від'ємними числами =  "+ zav2(arr));
            System.out.println("Завдання 2:");
            System.out.println("Кількість непарних чисел = " + Nepar(arr));
        }
        catch (Exception ex){
            System.out.println("Введено некоректні данні!");
            System.out.println("Спробуйте ще раз)");
            main(args);
        }

    }
}
