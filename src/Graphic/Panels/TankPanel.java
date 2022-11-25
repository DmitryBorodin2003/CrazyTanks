package Graphic.Panels;

import Blocks.Tank;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class TankPanel extends JPanel {
    public TankPanel(Object obj) throws IOException, URISyntaxException {
        BorderLayout mgr = new BorderLayout();
        mgr.setHgap(0);
        mgr.setVgap(0);
        setLayout(mgr);
        Tank tank = (Tank) obj;
        BufferedImage Picture = null;
        if (tank.getLastMove() == Tank.Commands.UP){
            Picture = ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("/Sprites/tankUp.png")).toURI()));
        } else if (tank.getLastMove() == Tank.Commands.DOWN) {
            Picture = ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("/Sprites/tankDown.png")).toURI()));
        } else if (tank.getLastMove() == Tank.Commands.LEFT) {
            Picture = ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("/Sprites/tankLeft.png")).toURI()));
        } else if (tank.getLastMove() == Tank.Commands.RIGHT) {
            Picture = ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("/Sprites/tankRight.png")).toURI()));
        }
        JLabel picLabel = new JLabel(new ImageIcon(Picture));
        add(picLabel);
    }
}
