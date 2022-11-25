package Game;

import Blocks.Air;
import Blocks.Block;
import Printers.Printer;

public class GameField {
    Printer prt;
    private final int size;
    private int currLevel = 1;
    private final Block[][] field;

    public GameField(int size, Printer prt) {
        this.size = size;
        this.prt = prt;
        field = new Block[size][size];
        clear();
    }

    public GameField clear(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new Air(j+1, i+1);
            }
        }
        return this;
    }


    public GameField refreshField(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (((field[i][j].getX())!= i) || ((field[i][j].getY()) != j)){
                    field[field[i][j].getX()][field[i][j].getY()] = field[i][j];
                    field[i][j] = new Air(j+1, i+1);
                }
            }
        }
        return this;
    }
    public Block getBlock(int x, int y){
        return field[x][y];
    }

    public int getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(int currLevel) {
        this.currLevel = currLevel;
        clear();
    }
    public int getSize() {return size;}

    public Block[][] getField() {
        return field;
    }
}
