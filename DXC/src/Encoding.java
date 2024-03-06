import java.util.Map;
import java.util.Random;

public class Encoding extends ReferenceTable {

    private String retrievedTable;

    private String constructedString = "";

    private String encodedString = "";

    public Encoding() {
        retrievedTable = super.buildTable();
    }

    public String buildString() {

        char currentChar = 'A';
        for (int i = 0; i < 26; i++) {
            constructedString += currentChar;
            currentChar++;
        }

        for (int i = 0; i < 10; i++) {
            constructedString += String.valueOf(i);
        }

        constructedString += "(";
        constructedString += ")";
        constructedString += "*";
        constructedString += "+";
        constructedString += ",";
        constructedString += "-";
        constructedString += ".";
        constructedString += "/";

        return constructedString;
    }

    public String shiftString() {

        String returnedString = buildString();

        Random random = new Random();

        String offsetChar = String.valueOf(returnedString.charAt(random.nextInt(44)));
        encodedString += offsetChar;
        Integer shiftAmt = retrievedTable.indexOf(offsetChar);

        String first = returnedString.substring(returnedString.length()-shiftAmt);
        String second = returnedString.substring(0, returnedString.length()-shiftAmt);
        String shiftedString = first + second;
        return shiftedString;
    }

    public String encode(String plainText) {

        String shiftedStringEn = shiftString();

        for (int i = 0; i < plainText.length(); i++) {
            if (retrievedTable.contains(String.valueOf(plainText.charAt(i)).toUpperCase())) {
                encodedString += shiftedStringEn.charAt(retrievedTable.indexOf(String.valueOf(plainText.charAt(i)).toUpperCase()));
            } else {
                encodedString += String.valueOf(plainText.charAt(i)).toUpperCase();
            }
        }
        return encodedString;
    }

}
