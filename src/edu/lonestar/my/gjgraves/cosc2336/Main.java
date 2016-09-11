package edu.lonestar.my.gjgraves.cosc2336;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //MainWindow window = new MainWindow();
        //window.buildWindow();

        String sContent = null;
        byte[] buffer = null;
        File a_file = new File("/Users/Gjvon/Desktop/names.dat");
        try {
            FileInputStream fis = new FileInputStream("/Users/Gjvon/Desktop/names.dat");
            int length = (int) a_file.length();
            buffer = new byte[length];
            fis.read(buffer);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sContent = new String(buffer);
        System.out.println(sContent);
        TestSort t = new TestSort();
        String[] s = t.reader(sContent);
        System.out.println(s[0]);
    }
}
