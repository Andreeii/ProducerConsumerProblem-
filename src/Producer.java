import java.util.Random;

public class Producer extends Thread {

    public void run() {

        try {
            synchronized (Main.qlist) {

                if(Main.size < Main.prodmaxlimit) {
                    System.out.println(Main.size);
                    Main.sem.release();
                    Random random = new Random();
                    int j = random.nextInt(30);
                    this.sleep(1000);
                    Main.qlist.add(j);
                    Main.size++;
                    System.out.println("S-a produs : " + j);
                }else{
                    Producer.interrupted();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
