package Graphic;

import Blocks.Air;
import Blocks.Block;
import Game.Game;
import Game.GameField;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.PriorityQueue;
import java.util.Queue;

public class TableRenderer extends JFrame implements KeyListener {
    Queue<String> moves = new PriorityQueue<>();
    TanksTableModel ttm;
    public TableRenderer(Game g){
        ttm = new TanksTableModel(g);

        JTable table = new JTable(ttm);
        table.setDefaultRenderer(Block.class, new BlockRenderer());
        table.setTableHeader(null);
        table.setRowHeight(100);
        table.addKeyListener(this);
        table.setShowGrid(false);

        this.add(new JScrollPane(table));
        this.setTitle("CRAZY TANKS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setSize(900, 942);
        this.setVisible(true);
        repaint();
    }

    public void refresh(){
        ttm.refresh();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_UP) {moves.offer("UP");}
        if (e.getKeyCode()==KeyEvent.VK_DOWN) {moves.offer("DOWN");}
        if (e.getKeyCode()==KeyEvent.VK_LEFT) {moves.offer("LEFT");}
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {moves.offer("RIGHT");}
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {moves.offer("FIRE");}
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public Queue<String> getMoves() {return moves;}
}
