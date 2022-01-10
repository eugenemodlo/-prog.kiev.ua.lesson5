import ua.kiev.prog.lesson5.utils.FileUtility;

public class Main {
    public static void main(String[] args) {
        final String INPUT_PATH = "/home/ye/Downloads/Telegram Desktop";
        final String OUTPUT_PATH = "/home/ye/Downloads/test";
        final String FILE_EXTENSION = "png";

        FileUtility fileUtility = new FileUtility();

        fileUtility.CopyFiles(INPUT_PATH, OUTPUT_PATH, FILE_EXTENSION);
    }
}
