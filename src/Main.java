import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Main {

    static int producernumber =3;//var pentru numarul de pruducatori ;

    static int consumernumber = 2;//var pentru numarul de consumatori ;

    static int Pstartlimmit = 80;//var pentru limita de pornire a producatorilor

    static int Cstartlimit = 0;//var pentru numarul de consumatori

    static int size = 200;//var penutr marimea listei initiale;

    static int prodmaxlimit = 100;//var pentru limita maxima de functionare a producatorilor

    static Queue <Integer> qlist = new LinkedList<>();//crearea listei de tip queue;

    static Semaphore sem=new Semaphore(200);//crearea semaforului

    public static void main(String[]args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);//crearea scanerului care acepta valori pentru fiecare variabila ;

        System.out.println("Introduceti numarul initial de elemente : ");
        size = scanner.nextInt();

        System.out.println("Introduceti numarul de producători :");
        producernumber = scanner.nextInt();

        System.out.println("Introduceti numarul de consumatori : ");
        consumernumber = scanner.nextInt();

        System.out.println("Introduceti limita de pornire a producătorilor :");
        Pstartlimmit = scanner.nextInt();

        System.out.println("Introduceti limita de oprire a producatorilor :");
        prodmaxlimit = scanner.nextInt();
        System.out.println("Introduceti limita de pornire a oonsumatorilor");
        Cstartlimit = scanner.nextInt();

        System.out.println("Pentru a opri procesul ,tastati tasta : q ");

        //Afisarea listei de tip queue;
        for(int i = 1 ;i <= size ; i++) {
            Random random = new Random();
            int j = random.nextInt(20);
            Main.qlist.add(j);
        }

        Thread quit1 = new Thread(new Scaner());
        quit1.start();

        while (!(Main.sem.availablePermits() <= 0)) {
            if (size < Pstartlimmit){

                //Generarea numarului de produceri;
                for(int i=1;i <= producernumber;i++) {
                    Producer producer1 = new Producer();
                    producer1.start();
                }

            }
            if(size > Cstartlimit ) {

                //Generarea numarului de consumeri ;
                for (int i = 0; i < consumernumber; i++) {
                    Consumer consumer1 = new Consumer();
                    consumer1.start();
                    consumer1.join();
                }
            }

        }
    }
}
