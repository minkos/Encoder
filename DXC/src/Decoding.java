/**
 * Decoding Class decodes the encoded text.
 */
public class Decoding extends ReferenceTable {

    private String retrievedTableDe;
    private String constructedStringDe = "";
    private String decodedString = "";

    /**
     * Constructor used to build the required reference table and initialises
     * class attribute; retrievedTableDe.
     */
    public Decoding() {
        retrievedTableDe = super.buildTable();
    }

    /**
     * Another String is built here for the offset to occur.
     */
    private String buildStringDe() {

        char currentChar = 'A';
        for (int i = 0; i < 26; i++) {
            constructedStringDe += currentChar;
            currentChar++;
        }

        for (int i = 0; i < 10; i++) {
            constructedStringDe += String.valueOf(i);
        }

        constructedStringDe += "(";
        constructedStringDe += ")";
        constructedStringDe += "*";
        constructedStringDe += "+";
        constructedStringDe += ",";
        constructedStringDe += "-";
        constructedStringDe += ".";
        constructedStringDe += "/";

        return constructedStringDe;
    }

    /**
     * Method to offset the String based on the offsetChar.
     */
    private String shiftStringDe(String offsetChar) {

        String returnedString = buildStringDe();

        Integer shiftAmt = retrievedTableDe.indexOf(offsetChar);

        String first = returnedString.substring(returnedString.length()-shiftAmt);
        String second = returnedString.substring(0, returnedString.length()-shiftAmt);
        String shiftedString = first + second;
        return shiftedString;
    }

    /**
     * Method to decode the encoded text based on the offset
     * String; shiftedStringDe.
     */
    public String decode (String encodedText) {

        String shiftedStringDe = shiftStringDe(String.valueOf(encodedText.charAt(0)));

        for (int i = 1; i < encodedText.substring(1).length()+1; i++) {
            if (shiftedStringDe.contains(String.valueOf(encodedText.charAt(i)))) {
                decodedString += retrievedTableDe.charAt(shiftedStringDe.indexOf(String.valueOf(encodedText.charAt(i))));
            } else {
                decodedString += String.valueOf(encodedText.charAt(i));
            }

        }
        return decodedString;
    }

}
