import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Main launch = new Main();
        launch.launchMethod();
    }

    public void launchMethod() throws FileNotFoundException {

        ReadText retrievedIO = new ReadText();

        Encoding secret = new Encoding();
        String encodedtext = secret.encode(retrievedIO.getText());
        System.out.println("Encoded Text: " + encodedtext);

        Decoding revealed = new Decoding();
        String decodedText = revealed.decode(encodedtext);
        System.out.println("Decoded Text: " + decodedText);

    }
}