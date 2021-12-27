import logger.FileReader;
import logger.Reader;

public class App {
    public static void main (String[] args) {
        Reader reader = new FileReader();
        String message = reader.read();

        System.out.println(message);
    }
}