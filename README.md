# 🔐 Hashing Project – Java Implementation

This Java project demonstrates multiple **hashing techniques** using **open addressing** and **separate chaining** to resolve collisions. The program reads a list of words from a file and stores them in a hash table using your selected technique.

---

## 💡 What is Hashing?

**Hashing** is a data storage technique that maps data (like a word or number) to a specific location in a hash table using a **hash function**.

### Why is Hashing important?

- 🔍 Extremely fast data access (ideally O(1))
- 📦 Used in real-world systems like caches, databases, symbol tables
- 🔐 Plays a major role in encryption, password hashing, and file deduplication

---

## 📌 How the Project Works 

1. 🔄 The program reads words from `Words.txt` using `FileReader.java`.

2. 🧮 For each word, it computes the hash index using this function in `HashFunctions.java`:
```java
int hash = word.chars().sum() % tableSize;
```

## 🚀 How to Run
### 1. Clone the repository

```bash
git clone https://github.com/mennadevhub/Hashing-Project.git
```



