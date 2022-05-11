package com.company;
import java.io.*;
import java.util.*;

class storage implements Serializable{
    private int nubmer;
    private String name;
    private float mass;
    private float price;
    private int count;

    public  static List<storage> tovar = new ArrayList<>();
    public  static List<storage> sorted = new ArrayList<>();

    public storage(){}

    public storage (storage s)throws IOException{
        this.nubmer=s.nubmer;
        this.name=s.name;
        this.mass=s.mass;
        this.price=s.price;
        this.count=s.count;

        tovar.add(this);
        FileOutputStream writeData = new FileOutputStream("tovar.txt");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(tovar);
        writeStream.flush();
        writeStream.close();
    }

    public static storage AddTovar(){
        Scanner a = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        storage s = new storage();
        try{
            System.out.println("Введіть інвентарний номер");
            s.nubmer = a.nextInt();
            System.out.println("Введіть назву товару");
            s.name =f.nextLine();
            System.out.println("Введіть вагу");
            s.mass = a.nextFloat();
            System.out.println("Введіть ціну");
            s.price = a.nextFloat();
            System.out.println("Введіть кількість");
            s.count = a.nextInt();
        }
        catch (Exception ex){
            System.out.println("Введене некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            return AddTovar();
        }
        return s;
    }

    public static void DeleteTovar() throws IOException {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Введіть номер запису: ");
            int n = in.nextInt();

            if(n>tovar.size()){
                System.out.println("Номер за межами массиву!");
                DeleteTovar();
            }
            tovar.remove(n - 1);
            FileOutputStream writeData = new FileOutputStream("tovar.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(tovar);
            writeStream.flush();
            writeStream.close();
        }
        catch (Exception ex){
            System.out.println("Введене некоректні значення!!!");
            System.out.println("Повторіть спробу!!!");
            DeleteTovar();
        }
    }

    public static void FileRead() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("tovar.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tovar = (List) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void OutputTovar(){
        System.out.println("Інвентарний номер: " + nubmer);
        for(String s: Arrays.asList("\tНазва товару: " + name, "\tВага: " + mass, "\tЦіна: " + price+ "\tКількість"+ count)){
            System.out.println(s);
        }
        System.out.println();
    }

    public static void OutputAllTovar(List<storage> array){
        System.out.println("Кількість записів: " + array.size());
        for (int i=0;i<array.size();i++){
            array.get(i).OutputTovar();
        }
    }

    public static void SortTovar() {
        sorted.clear();
        sorted.addAll(tovar);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - 1; j++) {
                if (sorted.get(j).mass > sorted.get(j + 1).mass) {
                    storage tmp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, tmp);
                }
            }
        }
    }

    public static void SearchTovar(){
        String NameTovar;
        System.out.println("Введіть назву товару");
        NameTovar = new Scanner(System.in).nextLine();
        for(int i=0;i<tovar.size();i++){
            if(tovar.get(i).name.equals(NameTovar)){
                tovar.get(i).OutputTovar();
            }
        }
    }
}



public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String n;
        Scanner in = new Scanner(System.in);
        do {
        System.out.println("============================================================");
        System.out.println("\t\t---Лабораторна робота №6---");
        System.out.println("\t\t\t---Список завдань---");
        System.out.println("---1 - Ввести інформацію про товар ");
        System.out.println("---2 - Вивести інформацію про товар на складі");
        System.out.println("---3 - Вивести інформацію складу відсортовану по вазі");
        System.out.println("---4 - Пошук по назві товару-");
        System.out.println("---5 - Видалення запису ");
        System.out.println("---6 - Завершити роботу ");
        System.out.println("============================================================");
        System.out.print("Введіть номер завдання: ");
        n = in.next();
        switch (n) {
            case "1":
                storage _storage = new storage(storage.AddTovar());
                break;
            case "2":
                storage.FileRead();
                storage.OutputAllTovar(storage.tovar);
                break;
            case "3":
                storage.SortTovar();
                storage.OutputAllTovar(storage.sorted);
                break;
            case "4":
                storage.SearchTovar();
                break;
            case "5":
                 storage.DeleteTovar();
                break;
            case "6":
                //File file = new File("D:\\Java\\laba6.2\\tovar.txt");
                //file.deleteOnExit();
                return;
        }
    } while (n != "6");
        return;
    }
}

