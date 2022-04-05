package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        System.out.println("Введіть число від 20 до 69");
        try{
        int age = in.nextInt();
        if(age < 20 || age >= 70){
            System.out.print("Число повинно бути в діапазоні від 20 до 69");
        }
        else {
            System.out.print(age);
            switch (age) {
                case 20:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 65:
                case 67:
                case 68:
                case 69:
                    System.out.print(" років");
                    break;
                case 22:
                case 23:
                case 24:
                case 32:
                case 33:
                case 34:
                case 42:
                case 43:
                case 44:
                case 52:
                case 53:
                case 54:
                case 62:
                case 63:
                case 64:
                    System.out.print(" роки");
                    break;
                case 21:
                case 31:
                case 41:
                case 51:
                case 61:
                    System.out.print(" рік");
            }
        }
        }
        catch (Exception ex){
            System.out.print("Не вірно введені значення");
        }
        /*
        if (age >= 11 && age <= 19)
        {
            System.out.print(age + " рокiв");
        }
        else if (age == 1 || age % 10 == 1)
        {
            System.out.print(age + " рik");
        }
        else if ((age > 1 && age < 5) || (age % 10 > 1 && age % 10 < 5))
        {
            System.out.print(age + " роки");
        }
        else
        {
            System.out.print(age + " рокiв");
        }
        */
    }
}
