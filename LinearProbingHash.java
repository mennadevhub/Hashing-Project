public class LinearProbingHash {
    private String[] table;
    private int[] collisions;
    private int size;
    
    // Constructor
    public LinearProbingHash(int size) {
        this.size = size;
        table = new String[size];
        collisions = new int[size];
    }
    
    // Insert a word into the table
    public void insert(String word) {
        word = word.toLowerCase();
        int index = HashFunctions.basicHash(word, size);

        System.out.println("Word: " + word + " | Hash = " + HashFunctions.basicHash(word, HashFunctions.m) + " | Index = " + index);

        int originalIndex = index;
        int collisionCount = 0;
        
        while (table[index] != null && !table[index].equals(word)) {
            collisionCount++;
            index = (index + 1) % size;
            if (index == originalIndex) {
                System.out.println("Table is full!");
                return;
            }
        }
        
        if (table[index] == null) {
            table[index] = word;
            collisions[index] = collisionCount;
        }
    }
    
    // Display the hash table
    public void display() {
        System.out.println("\nLinear Probing Hash Table:");
        System.out.println("Index\tWord\tCollisions");
        System.out.println("--------------------------");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(i + "\t" + table[i] + "\t" + collisions[i]);
            }
        }
    }
}
