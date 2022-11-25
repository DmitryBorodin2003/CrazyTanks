import Printers.*;
import Game.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger time = new AtomicInteger();
    static javax.swing.Timer timer = new Timer(100, e -> time.getAndIncrement());

    public static void main(String[] args) {
        timer.start();

        Printer prt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите режим отображения (Console/Graphic)");

        if (sc.nextLine().equals("Console")) {
            prt = new Printer();
        } else {
            prt = new GraphicPrinter();
        }

        Game g = new Game(prt);

        while (!g.isOver()) {
            if (time.get() >= 1) {
                g.getPlayer().nextMove(prt.nextMove(), g);
                time.set(0);
            }
        }
        prt.congratulations();
    }
}