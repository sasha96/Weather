package zhurylo.alex.usb;

import zhurylo.alex.frame.Window;
import zhurylo.alex.serializator.Serializator;

import java.io.IOException;

public class Usb {
    public static void main(String[] args) throws IOException {

        new DetectedDrive();
        if ( DetectedDrive.USBDetect() != null && ! DetectedDrive.USBDetect().isEmpty()) {
            Serializator.test(DetectedDrive.USBDetect());
        }else{
            Window window = new Window();
        }
    }
}
