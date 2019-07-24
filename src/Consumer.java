public class Consumer extends Thread  {
    public void run() {
        try {
            synchronized (Main.qlist) {

                if(Main.size >Main.Pstartlimmit-1) {
                System.out.println(Main.size);
                Main.sem.acquire();
                sleep(1000);
                System.out.println("S-a consumat : "+Main.qlist.peek());
                    Main.qlist.poll();
                    Main.size--;
            }else{
                 Consumer.interrupted();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


