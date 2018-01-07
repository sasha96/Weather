package usb;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

public class DetectedDrive {
    public String USBDetect() {
        String driveLetter = "";
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] f = File.listRoots();
        for (int i = 0; i < f.length; i++) {
            String drive = f[i].getPath();

            String type = fsv.getSystemTypeDescription(f[i]);
            boolean isDrive = fsv.isDrive(f[i]);
            boolean isFloppy = fsv.isFloppyDrive(f[i]);
            boolean canRead = f[i].canRead();
            boolean canWrite = f[i].canWrite();
            if (canRead && canWrite && !isFloppy && isDrive && (type.contains("Съемный диск"))) {
                driveLetter = drive;
                break;
            }
        }
        return driveLetter;
    }
}