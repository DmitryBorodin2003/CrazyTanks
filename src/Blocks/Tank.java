package Blocks;

import Game.Game;

public class Tank extends Block {
    private Commands lastMove = Commands.UP;

    public enum Commands {
        FIRE(0, 0),
        UP(0, -1),
        RIGHT(1, 0),
        DOWN(0, 1),
        LEFT(-1, 0),
        WAIT(0, 0);
        private final int dx;
        private final int dy;

        Commands(int dx, int dy) {
            this.dx = dy;
            this.dy = dx;
        }
    }

    public Tank() {
    }

    private void command(String s, Game g){
        Commands d = Commands.valueOf(s);
        if (d.dx != 0 || d.dy != 0){
            move(s, g);
        } else {
            if (d != Commands.WAIT){
                shoot(g);
            }
        }
    }
    private void move(String s, Game g){
        Commands d = Commands.valueOf(s);
        int x1 = x + d.dx;
        int y1 = y + d.dy;
        int size = g.getGameField().getSize();
        if (x1 >=0 && y1 >= 0 && x1<size && y1<size &&!g.getGameField().getBlock(x1, y1).isSolid){
            x += d.dx;
            y += d.dy;
        }
        lastMove = d;
    }

    private void shoot(Game g){
        int x1 = x;
        int y1 = y;
        int size = g.getGameField().getSize();
        for (int i = 0; i < size; i++) {
            x1 += lastMove.dx;
            y1 += lastMove.dy;
            if (x1*y1 >= 0 && x1<size && y1<size && g.getGameField().getBlock(x1, y1).isSolid){
                g.placeBlock(new Air(y1 + 1, x1 + 1));
                break;
            }
        }
    }
    public void nextMove(String s, Game g){
        try {
            command(s, g);
        } catch (IllegalArgumentException e){
            g.getPrt().argumentError();
        }
        g.printScreen();
    }
    public String[] draw() {
        String[] str = new String[3];
        switch (lastMove.name()) {
            case ("UP") -> {
                str[0] = " | ";
                str[1] = " ■ ";
                str[2] = "   ";
            }
            case ("RIGHT") -> {
                str[0] = "   ";
                str[1] = " ■-";
                str[2] = "   ";
            }
            case ("DOWN") -> {
                str[0] = "   ";
                str[1] = " ■ ";
                str[2] = " | ";
            }
            case ("LEFT") -> {
                str[0] = "   ";
                str[1] = "-■ ";
                str[2] = "   ";
            }
        }
        return str;
    }

    public void moveTo(int x, int y){
        this.x = y - 1;
        this.y = x - 1;
    }

    public Commands getLastMove() {
        return lastMove;
    }
}
