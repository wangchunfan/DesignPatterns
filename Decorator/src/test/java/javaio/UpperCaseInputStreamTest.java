package javaio;

import headfirst.javaio.UpperCaseInputStream;

import java.io.*;

public class UpperCaseInputStreamTest {

    public static void main(String[] args) throws IOException {
        File file = new File("test.iml");
        file.createNewFile();

        Writer writer = new FileWriter(file);
        writer.write("abcd");
        writer.close();

        InputStream in = new UpperCaseInputStream(new FileInputStream(file));
        int c;
        while ((c = in.read()) >= 0) {
            System.out.println(c);
            System.out.println((char) c);
        }
        in.close();
    }

}
