package Blocks;

import java.awt.*;

public abstract class Block {

    protected boolean isSolid;
    protected int x;
    protected int y;

    public abstract String[] draw();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
