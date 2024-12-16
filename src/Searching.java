import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Searching {
    public static Set<Character> numbers (String file) {
        Set <Character> res = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        res.add(c);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
