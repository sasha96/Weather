package zhurylo.alex.serializator;

import zhurylo.alex.frame.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
Class Serializer contains a single static serializatonfilse
 method which serializes files in the specified directory.
 */
public class Serializator {
    public static void serializationFiles(String driver, Window window) throws IOException {
        File file = new File(driver + "weather.properties");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(window);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}