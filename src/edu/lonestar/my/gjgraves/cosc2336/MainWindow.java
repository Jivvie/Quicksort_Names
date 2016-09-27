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

    final int WIDTH = 650;
    final int HEIGHT = 350;
    final String INTRO_TEXT = "Nothing to display..... yet. Instructions are fairly simple. Copy and paste the address " +
            "or" + "location of your text/binary file. Then click Submit. Click sort for the sorted list. ";
    private JTextField fileAddressField;
    private JFrame frame;
    private JPanel panel;
    private JPanel controlPanel;
    private JButton submitButton;
    private JButton sortButton;
    private JButton searchButton;
    private JTextArea namesArea;
    private ArrayList<String> names;
    private FileManager fm = new FileManager();

    /*This method builds the Java Window and applies the corresponding Java elements.
    * The code is pretty straightforwards. Take notice of the GroupLayout block of code.
    * We make a group layout for the buttons and the text field. */
    public void buildWindow() {
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchNameButtonClicked());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonClicked());
        sortButton = new JButton("Sort");
        sortButton.setSize(10, 10);
        sortButton.addActionListener(new SortButtonClicked());
        fileAddressField = new JTextField(3);
        this.namesArea = new JTextArea();
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
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(controlPanel);
        frame.add(namesArea);
        //Configure layout and add Buttons and text field. Takes the panel object as an argument.
        //We want the panel to
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //Set the layout group to vertical
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(sortButton)
                                .addComponent(submitButton)
                                .addComponent(fileAddressField)
                                .addComponent(searchButton)

                        )
                )
        );
        //Although the layout is vertical, the components should be horizontal upon the layout.
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(fileAddressField)
                .addComponent(submitButton)
                .addComponent(sortButton)
                .addComponent(searchButton)

        );
        //set the panel layout to the group layout we built
        panel.setLayout(layout);
        controlPanel.add(panel);
        frame.setVisible(true);

    }

    //Listener for the sort button
    public class SortButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (names != null) {
                names = fm.listOfNames;
                namesArea.setText(String.valueOf(names));
            }
        }
    }

    //Listener for the Submit Button
    public class SubmitButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /*In case the file name the user entered is a valid file name, we should attempt getting the data.
            * In cases where the file does not exist, although we have created a FileManager object, no sorting
             * will be done. We have an uncaught exception that we need to work on, however.
             * @todo: HANDLE FILE IO EXCEPTIONS TO GET RID OF BAD PRACTICES. NO EXCEPTION SHOULD GO UNHANDLED (Done)*/
            fm.doTheThing(fileAddressField.getText());
            if (fm.unSortedList != null) {
                names = fm.unSortedList;
                namesArea.setText(String.valueOf(names));
            }


        }
    }

    public class SearchNameButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = JOptionPane.showInputDialog(null, "Enter the name you want to search for.");
            if (names != null) {
                String checkForName = FileManager.search(names, message);
                JOptionPane.showMessageDialog(null, checkForName);
            }
        }
    }
}
