package com.company;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {


    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
            try {
                double a;
                System.out.println("Введіть значення b та c");
                System.out.print("b = ");
                double b = in.nextDouble();
                System.out.print("c = ");
                double c = in.nextDouble();
                if (c == 5) {
                    b = Math.sqrt(b);
                    c = Math.sqrt(c);
                    a = b + 2 * c;
                    System.out.println("Значення функції a=" + a);
                }
                else if (c == 0) {
                    a= b / (c + 6);
                    System.out.println("Значення функції a=" + a);
                }
                else if (c == -5) {
                    a=b + 12 * (c * c * c);
                    System.out.println("Значення функції a=" + a);
                }
                else {
                    System.out.println("Не можливо обчислити значення виразу");
                }

                /*
                if (c == 5) {
                    b = Math.sqrt(b);
                    c = Math.sqrt(c);
                    a = b + 2 * c;
                    System.out.println("Значення функції a=" + a);
                }
                if (c == 0) {
                    a= b / (c + 6);
                    System.out.println("Значення функції a=" + a);
                }
                if (c == -5) {
                    a=b + 12 * (c * c * c);
                    System.out.println("Значення функції a=" + a);
                }
                */

            }
            catch (Exception ex){
                System.out.println("Не коректно введені значення. Повинні бути лише числа");
                main(args);
            }
    }
}



