import java.util.ArrayList;
import java.util.HashMap;

public class stringSearch {

    public static HashMap<String, ArrayList<String>> findStrings(String longStr, String[] arrStr) {
        HashMap<String, ArrayList<String>> stringLocations = new HashMap<String, ArrayList<String>>();
        String lowerCaseLongStr = longStr.toLowerCase();

        for (String str : arrStr) {
            ArrayList<String> locations = new ArrayList<String>();
            str = str.toLowerCase();
            stringLocations.put(str, locations);

            for (int i = 0; i < lowerCaseLongStr.length(); i++) {
                // Found the first character of the small string
                if (lowerCaseLongStr.charAt(i) == str.charAt(0)) {
                    // Check the following characters to see if it is a match.
                    for (int j = 1; j < str.length(); j++) {
                        if ((i + j) >= lowerCaseLongStr.length() || lowerCaseLongStr.charAt(i + j) != str.charAt(j)) {
                            break;
                        }
                        else {
                            // if last character in small string is matched, then add found location.
                            if (j == str.length() - 1) {
                                stringLocations.get(str).add("Indices " + i + " to " + (i + j));
                            }
                        }
                    }
                }
            }
        }
        return stringLocations;
    }

    public static void main(String[] args) {
        // Given string
        String str = "Time to search for some strings!";
        // Array of smaller strings
        String[] arrStr = new String[]{"hello", "ear", "For", "Rings", "Arch", "time", "me", "gs!", "gs!h"};
        // Locate smaller strings and display locations
        System.out.println(findStrings(str, arrStr));
    }

}
