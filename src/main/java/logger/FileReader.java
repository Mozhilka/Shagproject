package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements Reader {
    final static Logger logger = LoggerFactory.getLogger(FileReader.class);

    @Override
    public String read () {
        String message = "";
        try {
            URI url = ClassLoader.getSystemResource("message.txt").toURI();
            logger.info("File URL have been gotten");

            byte[] fileBytes = Files.readAllBytes(Paths.get(url));
            logger.info("Byte array from file have been gotten");

            message = new String(fileBytes);
            logger.info("Message from file have been gotten");
        } catch (URISyntaxException | NullPointerException | IOException e) {
            logger.error(String.valueOf(e));
        }
        return message;
    }
}
