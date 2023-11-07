import java.io.FileNotFoundException;

public interface csvReader {
    public abstract String[] readFile(String filename) throws FileNotFoundException;
}
