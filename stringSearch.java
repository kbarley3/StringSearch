import java.util.HashMap;

public class stringSearch {

    public static HashMap<String, String> findStrings(String longStr, String[] arrStr)
    {
        HashMap<String, String> location = new HashMap<String, String>();
        String lowerCaseLongStr = longStr.toLowerCase();

        for (String str : arrStr)
        {
            location.put(str, "Not found");
            str = str.toLowerCase();

            for (int i = 0; i < lowerCaseLongStr.length(); i++)
            {
                // Found the start of the string
                if (lowerCaseLongStr.charAt(i) == str.charAt(0))
                {
                    // Check the following characters to see if it is a match.
                    for (int j = 1; j < str.length(); j++)
                    {
                        if ((i + j) < lowerCaseLongStr.length() && lowerCaseLongStr.charAt(i + j) != str.charAt(j))
                        {
                            break;
                        }
                        else
                        {
                            if (j == str.length() - 1)
                            {
                                location.replace(str, "Indices " + i + " to " + (i + j));
                            }
                        }
                    }
                }
            }
        }

        return location;
    }

    public static void main(String[] args)
    {

        // Given string
        String str = "Time to search for some strings!";
        // Array of smaller strings
        String[] arrStr = new String[] {"hello", "ear", "for", "rings", "arch", "time"};

        // Locate smaller strings and display locations
        System.out.println(findStrings(str, arrStr));

    }

}
