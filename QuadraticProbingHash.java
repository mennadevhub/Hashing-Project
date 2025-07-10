public class QuadraticProbingHash {
    private String[] table;
    private int[] collisions;
    private int size;
    
    // Constructor
    public QuadraticProbingHash(int size) {
        this.size = size;
        table = new String[size];
        collisions = new int[size];
    }
    
    // Insert a word into the table
    public void insert(String word) {
        word = word.toLowerCase();
        int index = HashFunctions.basicHash(word, size);
       
        int collisionCount = 0;
        int i = 0;
        
        int newIndex = index;
        while (table[newIndex] != null && !table[newIndex].equals(word)) {
            collisionCount++;
            i++;
            newIndex = (index + i*i) % size;
            if (i >= size) {
                System.out.println("Cannot insert " + word + ". Table might be full or quadratic probing failed!");
                return;
            }
        }
        
        if (table[newIndex] == null) {
            table[newIndex] = word;
            collisions[newIndex] = collisionCount;
        }
    }
    
    // Display the hash table
    public void display() {
        System.out.println("\nQuadratic Probing Hash Table:");
        System.out.println("Index\tWord\tCollisions");
        System.out.println("--------------------------");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(i + "\t" + table[i] + "\t" + collisions[i]);
            }
        }
    }
}