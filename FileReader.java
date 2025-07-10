import java.io.*;
import java.util.*;

public class FileReader{
    public static List<String> readWordsFromFile(String filename) throws IOException {
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            words.add(sc.next().toLowerCase());
        }
        sc.close();
        return words;
    }
}

