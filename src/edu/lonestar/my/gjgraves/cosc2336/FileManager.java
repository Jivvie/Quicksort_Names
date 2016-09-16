package edu.lonestar.my.gjgraves.cosc2336;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

/**
 * Created by Gjvon on 9/6/16.
 */
public class FileManager{
    public int numOfNamnes;
    public ArrayList listOfNames;
    public ArrayList unSortedList;

    public FileManager()
    {

    }

    public void setNumOfNames()
    {
        numOfNamnes = listOfNames.size();
        System.out.println("Size of list: " + numOfNamnes);
    }

    public void doTheThing(String filePath)
    {
        listOfNames = new ArrayList<String>();
        FileInputStream fis;
        File a_file = new File("C:\\Users\\gjvon\\Desktop\\names.dat");
        try {
            fis = new FileInputStream("C:\\Users\\gjvon\\Desktop\\names.dat");
            DataInputStream dis = new DataInputStream(fis);
            listOfNames = FileManager.getNamesFromFile(fis, dis);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        setNumOfNames();
        unSortedList = new ArrayList(listOfNames);
        doQuickSort(listOfNames, 0, numOfNamnes - 1);
        System.out.println("Sorted: " + listOfNames);
        System.out.println("UnSorted: " + unSortedList);
    }

    public static ArrayList getNamesFromFile(FileInputStream inputStream, DataInputStream fileData){
        boolean endOfFile = false;
        String name;
        ArrayList names = new ArrayList<String>();
        while(!endOfFile)
        {
            try{
                name = fileData.readUTF();
                names.add(name);
                System.out.println(name);
            }catch(IOException e)
            {
                endOfFile = true;
            }
        }
        return names;
    }

    public void doQuickSort(ArrayList<String> list, int start, int end)
    {
        int pivot;
        if(start < end)
        {
            pivot = arrayManager(list, start, end);
            doQuickSort(list, start, pivot - 1);
            doQuickSort(list, pivot + 1, end);
        }

    }

    public int arrayManager(ArrayList<String> names, int start, int end)
    {
        int midPoint = (start + end) / 2;
        swap(names, start, midPoint);
        String pivotValue = names.get(start);
        int endOfList = start;
        for(int i = start + 1; i <= end; i++)
        {
            /*The value 0 if the argument is a string lexicographically equal to this string; a value less than 0
            if the argument is a string lexicographically greater than this string; and a value greater than 0 if the
            argument is a string lexicographically less than this string. */
            if(names.get(i).compareTo(pivotValue) < 0)
            {
                endOfList++;
                Collections.swap(names, endOfList, i);
            }
        }
        Collections.swap(names, start, endOfList);
        return endOfList;
    }

    public void swap(ArrayList<String> list, int x, int y)
    {
        Collections.swap(list, x, y);
    }
}
