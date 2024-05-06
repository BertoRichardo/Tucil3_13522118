import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;

public class Dictionary {
    private HashSet<String> words = new HashSet<>();

    // Constructor
    public Dictionary(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line.trim());
        }
        reader.close();
    }

    public boolean isWordValid(String word) {
        return this.words.contains(word);
    }

    public static int getCharacterDiff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return Integer.MIN_VALUE;
        }

        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}