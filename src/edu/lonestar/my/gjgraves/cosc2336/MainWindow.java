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

    final String INTRO_TEXT = "Nothing to display..... yet. Instructions are fairly simple. Copy and paste the address " +
            "or" + "location of your text/binary file. Then click Submit. Click sort for the sorted list. ";
    private JLabel header;
    private JTextField fileAddressField;
    private JFrame frame;
    private JPanel panel;
    private JPanel controlPanel;
    JScrollPane scroll;
    private JButton submitButton;
    private JButton sortButton;
    private JButton exit;
    private JTextArea namesArea;
    private ArrayList documentLines;
    private FileManager manager;
    public ActionListener sortListener;
    ArrayList<String> names;
    //String FILE_PATH = "C:\\Users\\gjvon\\Desktop\\names.txt";
    FileManager fm = new FileManager();

    public void buildWindow(String fileName) {
        header = new JLabel("Place the location of your .dat or .text file here.");
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonClicked());
        sortButton = new JButton("Sort");
        sortButton.setSize(10, 10);
        sortButton.addActionListener(new SortButtonClicked());
        fileAddressField = new JTextField(3);
        namesArea = new JTextArea();
        namesArea.setText(INTRO_TEXT);
        namesArea.setLineWrap(true);
        namesArea.setEditable(false);
        namesArea.setWrapStyleWord(true);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(Color.WHITE);
        frame = new JFrame("Name Sorter");
        frame.setLayout(new GridLayout(0, 2));
        frame.setSize(450, 375);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(controlPanel);
        frame.add(namesArea);
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(sortButton)
                                .addComponent(submitButton)
                                .addComponent(fileAddressField)

                        )
                )
        );
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(fileAddressField)
                .addComponent(submitButton)
                .addComponent(sortButton)

        );
        panel.setLayout(layout);
        controlPanel.add(panel);
        frame.setVisible(true);

    }

    public class SortButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            names = fm.listOfNames;
            namesArea.setText(String.valueOf(names));
        }
    }

    public class SubmitButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //fm.doTheThing(FILE_PATH);
            fm.doTheThing(fileAddressField.getText());
            names = fm.unSortedList;
            namesArea.setText(String.valueOf(names));
        }
    }

    public void updateView(ArrayList lines) {

    }
}
