import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadText {

    String sentences = "";

    public String getText() throws FileNotFoundException {

        String fileName = "D:\\DXC_Assessment\\text.txt";
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        while(input.hasNextLine()) {
            sentences += input.nextLine();
        }
        return sentences;
    }

}
