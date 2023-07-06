package in.ineuron.in;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroups {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Convert the string to char array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted string is already present in the map
            if (anagramGroups.containsKey(sortedStr)) {
                // If it exists, add the current string to the list of anagrams
                anagramGroups.get(sortedStr).add(str);
            } else {
                // If it doesn't exist, create a new list and add the current string
                List<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                anagramGroups.put(sortedStr, anagramList);
            }
        }

        // Return the values (anagram groups) from the map
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramGroups = groupAnagrams(strs);

        System.out.println(anagramGroups);
    }
}
