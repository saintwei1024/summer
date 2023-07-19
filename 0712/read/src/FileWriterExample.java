import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String args[]) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            String str = "Hello, World!";
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
