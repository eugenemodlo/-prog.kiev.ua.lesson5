package ua.kiev.prog.lesson5.utils;

import java.io.File;
import java.io.FileFilter;

public class FileExtensionFilter implements FileFilter {
    private final String[] acceptedFileExtensions;

    public FileExtensionFilter(String[] array) {
        super();
        this.acceptedFileExtensions = array;
    }
    public FileExtensionFilter(String fileExtension) {
        super();
        this.acceptedFileExtensions = new String[] {fileExtension};
    }


    private boolean checkExtension(String ext) {
        for (String acceptedExtension : acceptedFileExtensions) {
            if (acceptedExtension.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathName) {
        String DOT = ".";
        int pointerIndex = pathName.getName().lastIndexOf(DOT);
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathName.getName().substring(pointerIndex + 1);
        return checkExtension(ext);
    }
}
