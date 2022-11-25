package Graphic;

import Blocks.Barrier;
import Blocks.Tank;
import Blocks.WinCondition;
import Graphic.Panels.AirPanel;
import Graphic.Panels.BarrierPanel;
import Graphic.Panels.TankPanel;
import Graphic.Panels.WinBlockPanel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class BlockRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            if(value.getClass() == Tank.class) {
                return new TankPanel(value);
            } else if (value.getClass() == Barrier.class){
                return new BarrierPanel();
            } else if (value.getClass() == WinCondition.class){
                return new WinBlockPanel();
            } else {
                return new AirPanel();
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
