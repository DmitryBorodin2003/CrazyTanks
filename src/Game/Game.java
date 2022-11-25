package Game;

import Blocks.Barrier;
import Blocks.Block;
import Blocks.Tank;
import Blocks.WinCondition;
import Printers.Printer;

public class Game {
    private boolean isOver = false;
    private final Printer prt;
    private final GameField field;
    private final Tank player = new Tank();
    private final WinCondition win = new WinCondition();


    public Game(Printer prt) {
        this.prt = prt;
        this.field = new GameField(9, prt);
        prt.setGame(this);
        loadLevel();
        prt.rules();
    }

    public void loadLevel(){
        //ОПЦИОНАЛЬНО Уровни из текстовика
        switch (field.getCurrLevel()) {
            case (1) -> {
                for (int i = 1; i <= field.getSize(); i++) {
                    for (int j = 1; j < field.getSize(); j++) {
                        if ((i % 2 == 1) && (j > 2) && (j < 8)){
                            placeBlock(new Barrier(j, i));
                        }
                    }
                    if (i == 1 || i == field.getSize()){
                        for (int j = 1; j <= field.getSize(); j++) {
                            placeBlock(new Barrier(j, i));
                        }
                    }
                    placeBlock(new Barrier(1, i));
                    placeBlock(new Barrier(field.getSize(), i));
                }
                placeBlock(new Barrier(2, 3));
                placeBlock(new Barrier(2, 7));
                placeBlock(new Barrier(8, 5));
                player.moveTo(2, 2);
                placeBlock(player);
                win.moveTo(2, field.getSize()-1);
                placeBlock(win);
            }
            case (2) -> {
                for (int i = 1; i <= field.getSize(); i++) {
                    for (int j = 1; j <= field.getSize(); j++) {
                        placeBlock(new Barrier(j, i));
                    }
                }
                player.moveTo(2, 2);
                placeBlock(player);
                win.moveTo(field.getSize()-1, field.getSize()-1);
                placeBlock(win);
            }
            default -> isOver = true;
        }
        field.refreshField();
        prt.printScreen(field);
    }

    public boolean isOver(){
        return isOver;
    }

    public GameField placeBlock(Block block){
        if ((block.getX() <= field.getSize()) && (block.getY() <= field.getSize())){
            field.getField()[block.getX()][block.getY()] = block;
        }
        return field;
    }
    private void checkNextLevelCondition() {
        if (player.getX() == win.getX() && player.getY() == win.getY()) {
            field.setCurrLevel(field.getCurrLevel() + 1);
            loadLevel();
            if (!isOver){
                prt.nextLevel();
            }
        }
    }
    public void printScreen(){
        field.refreshField();
        prt.printScreen(field);
        checkNextLevelCondition();
    }

    public GameField getGameField() {
        return field;
    }

    public Tank getPlayer() {
        return player;
    }

    public Printer getPrt() {
        return prt;
    }
}
