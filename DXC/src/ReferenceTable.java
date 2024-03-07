/**
 * ReferenceTable Class build the required Reference Table as a String.
 */
public class ReferenceTable {

    private String constructedString = "";

    public String buildTable() {

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

}
