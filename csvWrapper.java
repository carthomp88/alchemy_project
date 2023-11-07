import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvWrapper implements csvReader {
    public String[] readFile(String filename) throws FileNotFoundException {
        Scanner scnr = new Scanner(new File(filename));
        String[] lines = new String[100];
        int counter = 0;
        while (scnr.hasNextLine()) {
            lines[counter] = scnr.nextLine();
            counter++;
        }
        return lines;
    }
}
