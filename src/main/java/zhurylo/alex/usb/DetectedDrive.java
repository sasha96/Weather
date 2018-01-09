package zhurylo.alex.usb;

import java.io.File;
import java.io.Serializable;
import javax.swing.filechooser.FileSystemView;

/*
The DetectedDrive class contains one static
 method of usbDetect that determines if a
 device has a portable drive, if so,
 returns its location
*/
public class DetectedDrive implements Serializable {
    public static String usbDetect() {
        String driveLetter = "";
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        File[] files = File.listRoots();
        for (File aF : files) {
            String drive = aF.getPath();
            String type = fileSystemView.getSystemTypeDescription(aF);
            boolean isDrive = fileSystemView.isDrive(aF);
            boolean isFloppy = fileSystemView.isFloppyDrive(aF);
            boolean canRead = aF.canRead();
            boolean canWrite = aF.canWrite();
            if (canRead && canWrite && !isFloppy && isDrive && (type.contains("Съемный диск") || type.contains("USB Drive"))) {
                driveLetter = drive;
                break;
            }
        }
        return driveLetter;
    }
}