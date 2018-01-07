package serializator;

import frame.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializator {

    public static File test(String driver) throws IOException {

        Window window = new Window();
        File file = new File(driver + "weather.txt");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(window);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return file;
    }
}