package edu.lonestar.my.gjgraves.cosc2336;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

/**
 * Created by Gjvon on 9/6/16.
 */
public class FileManager {
    public int numOfNamnes;
    public ArrayList listOfNames;
    public ArrayList unSortedList;
    private FileInputStream fis;
    boolean fileExists = false;

    public FileManager() {

    }

    public void setNumOfNames() {
        numOfNamnes = listOfNames.size();
        System.out.println("Size of list: " + numOfNamnes);
    }

    /*Function name is for flavor. "Do the thing" simply means, take the file's address/location, and attempt to read from
    * it. If we cannot read from it, throw an exception.
    * @TODO: WE NEED TO HANDLE THESE EXCEPTIONS (DONE)*/
    public void doTheThing(String filePath) {
        listOfNames = new ArrayList<String>();
        try {
            fis = new FileInputStream(filePath);
            DataInputStream dis = new DataInputStream(fis);
            listOfNames = FileManager.getNamesFromFile(dis);
            setNumOfNames();
            unSortedList = new ArrayList(listOfNames);
            doQuickSort(listOfNames, 0, numOfNamnes - 1);
            System.out.println("Sorted: " + listOfNames);
            System.out.println("UnSorted: " + unSortedList);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(("")), "That File does not exist!");

        }
    }

    public static ArrayList getNamesFromFile(DataInputStream fileData) {
        boolean endOfFile = false;
        String name;
        ArrayList names = new ArrayList<String>();
        while (!endOfFile) {
            try {
                name = fileData.readUTF();
                names.add(name);
            } catch (IOException e) {
                endOfFile = true;
            }

        }
        return names;
    }

    /*The following code is fairly straightforward if you know what quick sort does. I will not explain what these functions
    * do because there are many resources out there that will explain in greater detail. */
    public void doQuickSort(ArrayList<String> list, int start, int end) {
        int pivot;
        if (start < end) {
            pivot = arrayManager(list, start, end);
            doQuickSort(list, start, pivot - 1);
            doQuickSort(list, pivot + 1, end);
        }

    }

    public int arrayManager(ArrayList<String> names, int start, int end) {
        int midPoint = (start + end) / 2;
        swap(names, start, midPoint);
        String pivotValue = names.get(start);
        int endOfList = start;
        for (int i = start + 1; i <= end; i++) {
            /*The value 0 if the argument is a string lexicographically equal to this string; a value less than 0
            if the argument is a string lexicographically greater than this string; and a value greater than 0 if the
            argument is a string lexicographically less than this string. */
            if (names.get(i).compareTo(pivotValue) < 0) {
                endOfList++;
                Collections.swap(names, endOfList, i);
            }
        }
        //swap ArrayList values
        swap(names, start, endOfList);
        return endOfList;
    }

    //Function uses the Collections class to swap ArrayList values.
    public void swap(ArrayList<String> list, int x, int y) {
        Collections.swap(list, x, y);
    }
}
