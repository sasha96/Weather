package zhurylo.alex.usb;

import zhurylo.alex.frame.Window;
import zhurylo.alex.serializator.Serializator;

import javax.swing.*;
import java.io.IOException;

public class Usb {
    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        new DetectedDrive();
        if ( DetectedDrive.USBDetect() != null && ! DetectedDrive.USBDetect().isEmpty()) {
            Serializator.test(DetectedDrive.USBDetect(),new Window());
        }else{
            Serializator.test(DetectedDrive.USBDetect(),new Window());
        }
    }
}
