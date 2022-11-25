package Printers;

import Blocks.Block;
import Game.Game;
import Game.GameField;
import java.util.Scanner;

public class Printer {
    protected Game g;
    Scanner sc = new Scanner(System.in);

    //Распечатывает обновленную табличку
    public void printScreen(GameField field){
        for (int i = 0; i < 2*field.getSize() + 1; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < 4*field.getSize()+1; j++) {
                    System.out.print('-');
                }
                System.out.println();
            } else {
                Block[] blk = new Block[field.getSize()];
                for (int j = 0; j < field.getSize(); j++) {
                    blk[j] = field.getField()[(i-1)/2][j];
                }
                for (String str: concatenate(blk)){
                    System.out.println(str);
                }
            }
        }
    }
    private String[] concatenate(Block[] blocks) {
        String[] result = new String[3];

        for (int i = 0; i < 3; i++) {
            StringBuilder oneString = new StringBuilder("|");
            for (Block blk : blocks) {
                oneString.append(blk.draw()[i]);
                oneString.append('|');
            }
            result[i] = oneString.toString();
        }
        return result;
    }

    public void setGame(Game g) {
        this.g = g;
    }

    public void rules(){
        System.out.println("Добро пожаловать в игру CRAZY-TANKS");
        System.out.println("Доступны команды: UP, DOWN, LEFT, RIGHT, FIRE");
    }
    public void congratulations(){
        System.out.println("CONGRATULATIONS!");
    }
    public void argumentError(){
        System.out.println("Введена неверная команда!!!!!");
    }
    public void nextLevel(){
        System.out.println("ПЕРЕХОД НА СЛЕДУЮЩИЙ УРОВЕНЬ...");
    }

    public String nextMove() {
        return sc.nextLine();
    }
}
