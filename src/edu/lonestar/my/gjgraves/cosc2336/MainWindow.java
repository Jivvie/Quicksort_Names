package edu.lonestar.my.gjgraves.cosc2336;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Created by Gjvon on 9/6/16.
 */
public class MainWindow extends JFrame {

    private JFrame frame;
    private JPanel panel;
    JScrollPane scroll;
    private JButton sortButton;
    private JButton exit;
    private JTextArea namesArea;
    private ArrayList documentLines;
    private FileManager manager;
    public ActionListener sortListener;
    ArrayList<String> names;
    String FILE_PATH = "C:\\Users\\gjvon\\Desktop\\names.txt";
    FileManager fm = new FileManager();
    public void buildWindow(String fileName)
    {
        FileManager fm = new FileManager();
        fm.doTheThing(FILE_PATH);
        names = fm.listOfNames;
        sortButton = new JButton("Sort");
        sortButton.setSize(10,10);
        sortButton.addActionListener(new ButtonClicked());
        namesArea = new JTextArea();
        namesArea.setText(String.valueOf(fm.unSortedList));
        namesArea.setLineWrap(true);
        namesArea.setEditable(false);
        namesArea.setWrapStyleWord(true);
        panel = new JPanel();
        //panel.setSize(70,400);
        panel.setLayout(new BorderLayout());
        frame = new JFrame("Main Window");
        frame.setVisible(true);
        frame.setSize(200, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.add(namesArea, BorderLayout.CENTER);
        panel.add(sortButton, BorderLayout.SOUTH);
    }
    public class ButtonClicked implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            namesArea.setText(String.valueOf(names));
        }
    }
    public void updateView(ArrayList lines)
    {

    }
}
