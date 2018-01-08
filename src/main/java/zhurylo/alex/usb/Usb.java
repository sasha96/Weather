package zhurylo.alex.usb;

import zhurylo.alex.frame.Window;
import zhurylo.alex.serializator.Serializator;

import java.io.IOException;

public class Usb {
    public static void main(String[] args) throws IOException {
        Window window = new Window();
        String drive = (new DetectedDrive()).USBDetect();
        if (drive != null && !drive.isEmpty()) {
            Serializator.test(drive);
        }
    }
}
