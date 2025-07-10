import java.util.*;

public class SeparateChaining {
    private List<String>[] table;
    private int size;
    
    // Constructor
    @SuppressWarnings("unchecked") //Tells the compiler to ignore raw type warning --> new LinkedList[size]
    public SeparateChaining(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    // Insert a word into the table
    public void insert(String word) {
        word = word.toLowerCase();
        int index = HashFunctions.basicHash(word, size);
 
        if (!table[index].contains(word)) {
            table[index].add(word);
        }
    }
    
    // Display the hash table
    public void display() {
        System.out.println("\nSeparate Chaining Hash Table:");
        System.out.println("Index\tWords in Chain");
        System.out.println("--------------------------");
        for (int i = 0; i < size; i++) {
            if (!table[i].isEmpty()) {
                System.out.print(i + "\t");
                for (String word : table[i]) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }
}