package com.company;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try{

        System.out.print("Введіть число: ");
        int x= in.nextInt();
        System.out.print(x+ "  це - ");
        if (x==0){
            System.out.print("Число нуль");
        }
        else if (x%2==0){
            System.out.print("парне, ");
        }
        else if (x%2!=0){
            System.out.print("не парне, ");
        }
        if (x>0){
            System.out.print("додатнє ");
        }
        else if (x<0){
            System.out.print("від'ємне ");
        }
        System.out.print("число");
        }

        catch(Exception ex){
            System.out.print("Не коректно введене значення. Число повинно бути цілим");
        }
    }
}
