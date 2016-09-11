package edu.lonestar.my.gjgraves.cosc2336;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by Gjvon on 9/6/16.
 */
public class MainWindow extends JFrame {

    private JFrame frame;
    private JButton sortButton;
    private JButton exit;
    private JTextArea textView;
    private ArrayList documentLines;
    private FileManager manager;
    public ActionListener sortListener;

    public void buildWindow()
    {
        frame = new JFrame("Main Window");
        frame.setVisible(true);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateView(ArrayList lines)
    {

    }
}
