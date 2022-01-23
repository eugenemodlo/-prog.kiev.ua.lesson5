package ua.kiev.prog.lesson5.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class FileUtility {
    public FileUtility() {
    }

    public void CopyFiles(String inputPath, String outputPath, String fileExtension) {
        FileExtensionFilter filter = new FileExtensionFilter(fileExtension);
        File inputDir = new File(inputPath);

        for (File file : Objects.requireNonNull(inputDir.listFiles(filter))) {
            File newFile = new File(outputPath, file.getName());
            if (copyFile(file, newFile)) {
                System.out.println("File: " + file.getName() + " was copied successfully.");
            }
        }

    }

    private boolean copyFile(File inputFile, File outputFile) {
        if (createNewFile(outputFile)) {
            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[1024];
                int byteRead = 0;

                while ((byteRead = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, byteRead);
                }
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean createNewFile(File file) {
        File dir = new File(file.getParent());
        if (!dir.exists()) {
            if (!dir.mkdir()){
                System.out.println("Can't create directory at: " + file.getPath());
                return false;
            }
        }

        try {
            if (file.createNewFile()) {
                System.out.println("Create");
                return true;
            } else {
                System.out.println("Can't create the file:" + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
