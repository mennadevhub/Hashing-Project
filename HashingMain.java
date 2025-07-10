import java.io.IOException;
import java.util.List;

public class HashingMain {
    public static void main(String[] args) {
        try {
            // Read words from file
            String filename = "words.txt";
            List<String> words = FileReader.readWordsFromFile(filename);
            System.out.println("Words read from file: " + words);

          

            
            // Set table size
            int tableSize = 52; // A prime number is good for hash tables
            
            // Create hash table instances
            LinearProbingHash linearProbing = new LinearProbingHash(tableSize);
            QuadraticProbingHash quadraticProbing = new QuadraticProbingHash(tableSize);
            DoubleHashing doubleHashing = new DoubleHashing(tableSize);
            SeparateChaining separateChaining = new SeparateChaining(tableSize);
            
            // Insert words into hash tables
            for (String word : words) {
                linearProbing.insert(word);
                quadraticProbing.insert(word);
                doubleHashing.insert(word);
                separateChaining.insert(word);
            }

            // Display results
            System.out.println("\n----- HASH TABLE COMPARISON -----");
            linearProbing.display();
            quadraticProbing.display();
            doubleHashing.display();
            separateChaining.display();
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}