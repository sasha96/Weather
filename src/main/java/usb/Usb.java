package usb;

import serializator.Serializator;

import java.io.IOException;

public class Usb {
    public static void main(String[] args) throws IOException {
        String drive = (new DetectedDrive()).USBDetect();
        if (drive != null && !drive.isEmpty()) {
            Serializator.test(drive);
        }
    }
}
