package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleReader {
    private BufferedReader bufferedReader;

    public SimpleReader(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + filename);
        }
    }

    public String readLine() {
        try {
            if (bufferedReader != null) {
                return bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return null;
    }

    public void close() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file");
        }
        bufferedReader = null;
    }
}