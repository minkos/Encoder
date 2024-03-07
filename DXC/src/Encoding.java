import java.util.Random;

/**
 * Encoding Class encodes the characters read from the I/O operation.
 */
public class Encoding extends ReferenceTable {

    private String retrievedTable;

    private String constructedString = "";

    private String encodedString = "";

    /**
     * Constructor used to build the required reference table and initialises
     * class attribute; retrievedTable.
     */
    public Encoding() {
        retrievedTable = super.buildTable();
    }

    /**
     * Another String is built here for the offset to occur.
     */
    private String buildString() {

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

    /**
     * Method to offset the String based on a random number.
     */
    private String shiftString() {

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

    /**
     * Method to encode the read plain text, retrievedTable, based on the
     * offset String, shiftedStringEn.
     */
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
