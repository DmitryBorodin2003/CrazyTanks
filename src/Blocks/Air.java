package Blocks;

import javax.swing.*;
import java.awt.*;

public class Air extends Block {

    public Air(int x, int y) {
        this.x = y - 1;
        this.y = x - 1;
        this.isSolid = false;
    }

    public String[] draw() {
        String[] str = new String[3];
        for (int i = 0; i < 3; i++) {
            str[i] = "   ";
        }
        return str;
    }
}
