package com.company;
import java.io.*;
import java.time.temporal.Temporal;
import java.util.*;

import static com.company.Trip.*;

abstract class Mus_band implements Serializable{
    protected String Name_band;
    protected String surname;
    public Mus_band(){};
}

class Trip extends Mus_band implements Serializable{
    private String city;
    private int year;
    private int consert_count;

    public static List<Trip> trips = new ArrayList<>();
    public Trip(){};

    public Trip(Trip t)throws IOException{
        this.Name_band = t.Name_band;
        this.surname=t.surname;
        this.city=t.city;
        this.year=t.year;
        this.consert_count=t.consert_count;
        trips.add(this);
        FileOutputStream writeData = new FileOutputStream("data.txt" );
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(trips);
        writeStream.flush();
        writeStream.close();
    }

    public Trip(String _Name_band, String _surname, String _city, int _year,int _consert_count){
        Name_band=_Name_band;
        surname=_surname;
        city=_city;
        year=_year;
        consert_count=_consert_count;
    }

    public static com.company.Trip AddTrip(){
        Scanner a = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        com.company.Trip b = new com.company.Trip();
        try{
            System.out.print("Введіть назву музичного гурту: ");
            b.Name_band=a.nextLine();
            System.out.print("Введіть прізвище керівника: ");
            b.surname=a.nextLine();
            System.out.print("Введіть місто: ");
            b.city=a.nextLine();
            System.out.print("Введіть рік: ");
            b.year=c.nextInt();
            System.out.print("Введіть кількість концертів: ");
            b.consert_count=c.nextInt();


        }
        catch (Exception ex){
            System.out.println("Введене некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            return AddTrip();
        }
        return b;
    }

    public void OutputTrip(){
        System.out.println("\tНазву музичного гурту:  " + Name_band);
        for (String s : Arrays.asList("\tПрізвище керівника: " + surname, "\tМісто: " + city,
                "\tРік: " + year, "\tКількість концертів: " + consert_count)) {
            System.out.println(s);
        }
        System.out.println();
    }

    public  static void OutputTrip(List<Trip> array){
        System.out.println("Кількість записів: " + array.size());
        for (int i = 0; i < array.size(); i++) {
            array.get(i).OutputTrip();
        }
    }

    public static void FileRead() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            trips = (List) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SearchMaxConsert(){
        int max = trips.get(0).consert_count;
        int n=0;
        for(int i=0;i<trips.size();i++){
            if(max < trips.get(i).consert_count){
                max = trips.get(i).consert_count;
                n=n+1;
            }
        }
        if (n>1){
            System.out.println("Кількість гастролів з однаковою кількістю концертів: " + n);
        }

        for(int i=0;i<trips.size();i++){
            if(trips.get(i).consert_count == max){
                trips.get(i).OutputTrip();
            }
        }
    }

    public static void delTrip(){
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Введіть номер запису: ");
            int n = in.nextInt();

            if(n>trips.size()){
                System.out.println("Номер за межами массиву!");
                delTrip();
            }
            trips.remove(n - 1);
            FileOutputStream writeData = new FileOutputStream("data.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(trips);
            writeStream.flush();
            writeStream.close();
        }
        catch (Exception ex){
            System.out.println("Введене некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            delTrip();
        }
    }

    public static void SearchSameCity(){
        Scanner in = new Scanner(System.in);
        String citi = new String();
        System.out.println("Введіть місто");
        citi = in.nextLine();
        for (int i=0;i<trips.size();i++){
            if(citi.equals(trips.get(i).city)){
                trips.get(i).OutputTrip();
            }
        }
    }

    public static void laststmbol(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть назву гурту");
        String nname = new String(in.nextLine());
        String ssurname =new String();
        for (int i=0;i<trips.size();i++){
            if(nname.equals(trips.get(i).Name_band)){

                System.out.println(trips.get(i).surname);
                ssurname = trips.get(i).surname;
            }
        }
        System.out.println("Керівник гурту" + nname + " - " + ssurname);
        String [] s = ssurname.split("");
        if(s[s.length] == " "){
            System.out.println("Остання літера прізвища - " + s[s.length -2]);
        }
        else{
            System.out.println("Остання літера прізвища - " + s[s.length -1]);
        }

    }
}


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String n;
        Scanner in = new Scanner(System.in);
        Trip.FileRead();
        do {
            System.out.println("============================================================");
            System.out.println("\t\t---Лабораторна робота №7---");
            System.out.println("\t\t\t---Список завдань---");
            System.out.println("---1 - Ввести новий музичний гурт ");
            System.out.println("---2 - Вивести інформацію про всі музичні гурти");
            System.out.println("---3 - Вивести інформацію про гурт з найбільшою кількістю концертів");
            System.out.println("---4 - Вивести всі гурти які були в певному місті");
            System.out.println("---5 - Вивести останню літеру в прізвищі керівника");
            System.out.println("---6 - Видалення запису ");
            System.out.println("---7 - Завершення роботи ");
            System.out.println("============================================================");
            System.out.print("Введіть номер завдання: ");
            n = in.next();
            switch (n) {
                case "1":
                    Trip trip = new Trip(Trip.AddTrip());
                    break;
                case "2":
                    Trip.OutputTrip(trips);
                    break;
                case "3":
                    Trip.SearchMaxConsert();
                    break;
                case "4":
                    Trip.SearchSameCity();
                    break;
                case "5":
                    laststmbol();
                    break;
                case "6":
                    Trip.delTrip();
                    break;
                case "7":
                    return;
            }
        } while (n != "7");
        return;
    }
}
