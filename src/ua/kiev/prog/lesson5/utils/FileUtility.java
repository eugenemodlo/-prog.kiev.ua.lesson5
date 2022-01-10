package ua.kiev.prog.lesson5.utils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileUtility {
    public FileUtility() {
    }

    public void CopyFiles(String inputPath, String outputPath, String fileExtension) {

        final String DELIMITER = "/";
        final String DOT = ".";
        FileExtensionFilter filter = new FileExtensionFilter(fileExtension);
        File inputDir = new File(inputPath);

        for (File file : Objects.requireNonNull(inputDir.listFiles(filter))) {
            String copyFileFullPath = new StringBuilder(outputPath).
                    append(DELIMITER).
                    append(file.getName()).
                    append(DOT).append(fileExtension).toString();

            File newFile = new File(copyFileFullPath);


            System.out.println(file.getName());
        }


    }
}
