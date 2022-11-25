package Graphic;

import Blocks.Block;
import Game.Game;

import javax.swing.table.AbstractTableModel;

public class TanksTableModel extends AbstractTableModel {
    private Block[][] blockList = null;
    private Game g;
    public TanksTableModel(Game g) {this.g = g;}

    @Override
    public String getColumnName(int column) {
        return null;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Block.class;
    }
    @Override
    public int getColumnCount() {return 9;}
    @Override
    public int getRowCount() {return 9;}
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return blockList[rowIndex][columnIndex];
    }

    public void refresh(){blockList = g.getGameField().getField();}
}
