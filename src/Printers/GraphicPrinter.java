package Printers;
import Game.*;
import Graphic.TableRenderer;
import javax.swing.*;
import java.util.Objects;

public class GraphicPrinter extends Printer {
    TableRenderer tb;
    public GraphicPrinter() {
    }
    @Override
    public void printScreen(GameField field) {
        tb.refresh();
    }

    @Override
    public void setGame(Game g) {
        this.tb = new TableRenderer(g);
    }

    @Override
    public void congratulations() {
        JOptionPane.showMessageDialog(tb, "CONGRATULATIONS!", "WIN", JOptionPane.INFORMATION_MESSAGE);
        tb.setVisible(false);
    }

    @Override
    public void nextLevel() {
        JOptionPane.showMessageDialog(tb, "Переход на следующий уровень...", "NEXT LEVEL", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String nextMove() {
        return Objects.requireNonNullElse(tb.getMoves().poll(), "WAIT");
    }

    @Override
    public void rules() {
        JOptionPane.showMessageDialog(tb, "Добро пожаловать в игру CRAZY TANKS. \nУправление: перемещение на стрелочки, выстрел на пробел", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
    }
}
