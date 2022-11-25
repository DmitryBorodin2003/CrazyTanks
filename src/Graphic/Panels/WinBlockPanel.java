package Graphic.Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class WinBlockPanel extends JPanel {
    public WinBlockPanel() throws IOException, URISyntaxException {
        BorderLayout mgr = new BorderLayout();
        mgr.setHgap(0);
        mgr.setVgap(0);
        setLayout(mgr);
        BufferedImage Picture = ImageIO.read(new File(Objects.requireNonNull(getClass().getResource("/Sprites/wincondition.png")).toURI()));
        JLabel picLabel = new JLabel(new ImageIcon(Picture));
        add(picLabel);
    }
}
