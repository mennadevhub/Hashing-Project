public class DoubleHashing {
    private String[] table;
    private int[] collisions;
    private int size;
    
    // Constructor
    public DoubleHashing(int size) {
        this.size = size;
        table = new String[size];
        collisions = new int[size];
    }
    
    // Insert a word into the table
    public void insert(String word) {
        word = word.toLowerCase();
        int hash1 = HashFunctions.basicHash(word, size);
        int hash2 = HashFunctions.secondHash(word);

     System.out.println("Word: " + word + " | Hash1 = " + hash1 + " | Hash2 = " + hash2);


      

        int index = hash1;
        int collisionCount = 0;
        int i = 0;
        
        while (table[index] != null && !table[index].equals(word)) {
            collisionCount++;
            i++;
            index = (hash1 + i * hash2) % size;
            if (i >= size) {
                System.out.println("Cannot insert " + word + ". Table might be full!");
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
        System.out.println("\nDouble Hashing Hash Table:");
        System.out.println("Index\tWord\tCollisions");
        System.out.println("--------------------------");
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println(i + "\t" + table[i] + "\t" + collisions[i]);
            }
        }
    }
}