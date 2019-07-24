import java.util.Scanner;

public class Scaner implements Runnable {
   //String q ,tasta care opreste procesul;
    @Override
    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String quit = scanner.next();
            if (quit.equals("q")) {
                System.exit(1);
            }
        }
    }
}
