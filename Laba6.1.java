package com.company;
import java.text.SimpleDateFormat;
import java.util.*;

class metereo {
    private Date date;
    private int temp;
    private float pressure;
    protected static List<metereo> metereos = new ArrayList<>();
    public metereo() {}

    public metereo(int day, int year, int month, int _temp,float _pressure) {
         this.date=new Date(year-1900,month-1,day);
         this.temp=_temp;
         this.pressure=_pressure;
      }

    public metereo(metereo m) {
        this.date = m.date;
        this.temp = m.temp;
        this.pressure = m.pressure;
        metereos.add(this);
    }

    public static metereo Addmetereo() {
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        metereo e = new metereo();
        try {
            int d, m, y;
            System.out.print("\t\tДень: ");
            d = a.nextInt();
            if(d >31||d<1){
                System.out.println("День не має бути білше 31");
                return Addmetereo();
            }
            System.out.print("\t\tМісяць: ");
            m = a.nextInt();
            if(m>12 || m<1){
                System.out.println("Місяців поки шо всього 12");
                return Addmetereo();
            }
            System.out.print("\t\tРік: ");
            y = a.nextInt();
            if(y>2022){
                System.out.println("ТИ з майбутнього? ");
                return Addmetereo();
            }
            e.date = new Date(y - 1900, m-1 , d);
            System.out.print("\tВведіть темпетуру: ");
            e.temp = f.nextInt();
            System.out.print("\tВведіть атмосферний тиск: ");
            e.pressure = f.nextFloat();
        } catch (Exception ex) {
            System.out.println("Введене некоректені значення!!!");
            System.out.println("Повторіть спробу!!!");
            return Addmetereo();
        }
        return e;
    }

    private void OutputInfometereo() {
        SimpleDateFormat dater = new SimpleDateFormat("d-MM-yyyy");
        System.out.println(dater.format(date) + "\t|\t" + temp + "\t|\t" + pressure);
    }

    public static void PrintAllmetereo(List<metereo> m) {
        System.out.println("Кількість записів: " + m.size());
        for (int i = 0; i < m.size(); i++) {
            m.get(i).OutputInfometereo();
        }
    }

    public static void PrintAllSortedmetereo() {
        List<metereo> a = new ArrayList<>(metereos);
        for (int i = 0; i < a.size() - 1; i++) {
            for (int k = 0; k < a.size() - 1; k++) {
                if (a.get(k).temp < a.get(k + 1).temp) {
                    metereo tmp = a.get(k);
                    a.set(k, a.get(k + 1));
                    a.set(k + 1, tmp);
                }
            }
        }
        PrintAllmetereo(a);
    }

    public static void SearchBiggestDiferent(){
        List <metereo> a = new ArrayList<>(metereos);
        float raz=Math.abs(a.get(0).pressure- a.get(1).pressure);
        metereo a1 =a.get(0);
        metereo a2 =a.get(1);

         for (int i=0;i< a.size()-1;i++){
             if(Math.abs(a.get(i).pressure - a.get(i+1).pressure) >= raz){
                 raz = Math.abs(a.get(i).pressure - a.get(i+1).pressure);
                 a1=a.get(i);
                 a2=a.get(i+1);
             }
         }
         a1.OutputInfometereo();
         a2.OutputInfometereo();
    }

    public static int maxTemp (){
        List<metereo> a = new ArrayList<>(metereos);
        int max=a.get(0).temp;
        for (int i = 0; i < a.size() - 1; i++) {
            if(a.get(i).temp > a.get(i+1).temp) {
                max = a.get(i).temp;
            }
        }
        return max;
    }
}

public class Main {

    public static void main(String[] args) {
        String n;
        Scanner in = new Scanner(System.in);
        metereo a1=new metereo(2002,10,15,2,10);
        metereo a2=new metereo(2002,10,16,10,10);
        metereo a3=new metereo(2002,10,17,5,3);
        metereo a4=new metereo(2002,10,18,8,11);
        metereo a5=new metereo(2002,10,19,3,5);
        metereo a6=new metereo(2002,10,20,7,9);
        metereo a7=new metereo(2002,10,21,12,6);
        metereo a8=new metereo(2002,10,22,15,15);
        metereo a9=new metereo(2002,10,23,4,4);
        metereo a10=new metereo(2002,10,24,6,7);
        metereo.metereos.add(a1);
        metereo.metereos.add(a2);
        metereo.metereos.add(a3);
        metereo.metereos.add(a4);
        metereo.metereos.add(a5);
        metereo.metereos.add(a6);
        metereo.metereos.add(a7);
        metereo.metereos.add(a8);
        metereo.metereos.add(a9);
        metereo.metereos.add(a10);
        do {
            System.out.println("============================================================");
            System.out.println("\t\t---Лабораторна робота №6.1---");
            System.out.println("\t\t\t---Список завдань---");
            System.out.println("---1 - Ввести інформацію про метеорологічні спостереження. ");
            System.out.println("---2 - Вивести інформацію про метеорологічні спостереження.");
            System.out.println("---3 - Вивести метеорологічні спостереження відсортовані за температорою повітря у порядку спадання.");
            System.out.println("---4 - Визначити два дні з найбільшим перепадом тиску.-");
            System.out.println("---5 - Завершити роботу ");
            System.out.println("============================================================");
            System.out.print("Введіть номер завдання: ");
            n = in.next();
            switch (n) {
                case "1":
                    metereo _metereo = new metereo(metereo.Addmetereo());
                    break;
                case "2":
                    metereo.PrintAllmetereo(metereo.metereos);
                    break;
                case "3":
                    metereo.PrintAllSortedmetereo();
                    break;
                case "4":
                    metereo.SearchBiggestDiferent();
                    break;
                case "5":
                    System.out.println("Дякую що обрали нас)");
                    return;
                case"6":
                    System.out.println(metereo.maxTemp());
            }
        } while (n != "5");
    }
}



