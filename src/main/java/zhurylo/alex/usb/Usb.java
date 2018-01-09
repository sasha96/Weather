package zhurylo.alex.usb;

import zhurylo.alex.frame.Window;
import zhurylo.alex.serializator.Serializator;

import java.io.IOException;

/*
This class Usb : launches the entire program
*/
public class Usb {
    public static void main(String[] args) {
        try {
            Serializator.serializationFiles(DetectedDrive.usbDetect(), new Window());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

