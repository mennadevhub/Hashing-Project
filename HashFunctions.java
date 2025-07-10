public class HashFunctions {
    private static final int b = 31; // The BaseNumber for calculating the hash
    public static final int m = 1000000009; // m = 10^9 + 9 (large prime number)

    // Primary hash using the exact formula: H(s) = (s0*b^(n-1) + s1*b^(n-2) + ... + sn-1*b^0) % m
    public static int basicHash(String word, int tableSize) {
        long hash = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            int power = n - 1 - i;
            long term = (long) word.charAt(i) * modPow(b, power, m);
            hash = (hash + term) % m;
        }

        return (int) (hash % tableSize);
    }

    // Exponentiation function to calculate b^e % m
    public static long modPow(long base, int exponent, int mod) { // ex. modPow(31, 5, 1000000009) 
        long result = 1;
       
        while (exponent > 0) {
            if (exponent % 2 == 1) { // If exponent is odd --> ex. 5
                result = (result * base) % mod; // result = (1 * 31) % 1000000009 = 31
            }
            base = (base * base) % mod; // base = (31 * 31) % 1000000009 = 961
           exponent = exponent / 2; //  5 / 2 = 2
        }

        return result; //result = 31
    }

    // Secondary hash for double hashing --.> H2(s) = 97 - (s0*b^(n-1) + s1*b^(n-2) + ... + sn-1*b^0) % 97
    public static int secondHash(String word) {
        long hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash = (hash * b + word.charAt(i)) % m;
        }
        return 97 - (int) (hash % 97);
    }
}



