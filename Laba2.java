package com.company;
import java.util.Scanner;

public class Main {

    static void task1() {
        Scanner in = new Scanner(System.in);
        boolean error = true;
        do {
            try{
                double x , y , a = 0;
                System.out.print("Введіть а: ");
                a = in.nextDouble();
                System.out.print("Введіть y: ");
                y = in.nextDouble();
                double temp = Math.pow(y, 2) - 2 * a;
                if (temp == 0) {
                    throw new ArithmeticException("Для заданих значень у a обчислюваному виразі виконується ділення на 0");
                }
                else if(temp <0){
                    throw new ArithmeticException("Для заданих значень у a обчислюваному виразі виконується ділення на число менше 0");
                }
                else {
                    x = a * (Math.sqrt(Math.pow(y, 2) - 2 * a));
                    System.out.printf("x=%.3f", x);
                    error = false;
                }
            }
            catch (ArithmeticException ex) {System.out.println(ex.getMessage());}
        }while (error) ;
    }


    static void task2(){
        int zav=0;
        int temp=0;
        int i = 0;
        System.out.println("Цикл з параметром");
        for ( i=1; i <=150; i++ ){
            temp = i%7;
            if(temp==0) {
                zav = zav + i;
            }
        }
        System.out.println("Результат: " + zav + "\n");
        System.out.println("Цикл з передумовою");
        temp = 0;
        zav=0;
        i=0;
        while(i<=150){
            temp = i%7;
            if (temp == 0){
                zav = zav +i;
            }
            i++;
        }
        System.out.println("Результат: " + zav+ "\n");
        System.out.println("Цикл з післяумовою");
        temp = 0;
        i=0;
        zav=0;
        do {
            temp = i%7;
            if (temp == 0){
                zav = zav +i;
            }
            i++;
        }
        while (i<=150);
        System.out.println("Результат: " + zav+ "\n");
    }


    static int task3(){
        int sum=0;
        for (int i=10;i<=30;i++){
            for(int j=i;j<=30;j++){
                sum = sum + (1+i+j);
            }
        }
        return sum;
    }


    static void task4(){
        float pi=(float)Math.PI;
        float a = -pi/2;
        float b = pi/2;
        float dx = pi/20;
        System.out.println("x\t\t|\ty");
        System.out.println("----------------------------");
        for(float x=a+dx;x<=b;x+=dx){
            System.out.printf("%.3f \t|\t",x);
            float y = (float) (Math.tan(x) - (float)(2*Math.sin(x)));
            System.out.printf("%.3f \n",y);
        }


    }
    public static void main(String[] args) {
        String n ;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1-Обчислення функції");
            System.out.println("2-Обчислити суму всіх чисел, кратних 7, у діапазоні (1;150).");
            System.out.println("3-Обчислення суми за формулою");
            System.out.println("4-Вивести значення функції у табличному вигляді");
            System.out.println("5-Завершити роботу");
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
                    System.out.println("Завдання 3");
                    System.out.println("Результат обчислення: "+task3());;
                    break;
                case "4":
                    System.out.println("Завдання 4");
                    task4();
                    break;
                case "5":
                    System.out.println("Дякую що вибрали нас)");
                    return;
                default:
                    System.out.println("Не коректно введені значення спробуйте ще раз");
            }
        }while(n!="5");
    }
}
