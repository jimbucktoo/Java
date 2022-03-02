import java.util.Scanner;
import java.io.FileInputStream;

public class KansasTowns {
    static void readTownsFile (String file) {
        FileInputStream fileByteStream = null;
        Scanner inFS = null;
        try {
            fileByteStream = new FileInputStream(file);
            inFS = new Scanner(fileByteStream);
            String cities = "";
            int population = 0;

            while (inFS.hasNextLine()) {
                cities += inFS.next() + " ";
                population += inFS.nextInt();
            }

            fileByteStream.close();
            System.out.printf("The total population of %sis %d.", cities, population);
        } catch (Exception e) {
            System.out.println(file + " does not exist.");
        }
    }

    public static void main(String[] args) {
        readTownsFile("KansasTownsPop1.txt");
    }
}
