// Student Name: Kareena Sen 
// Student Number: 251277984
/**  
 Description of Program: The Java program "HashDictionary" is an implementation of "DictionaryADT". 
 It provides the functionality for a dictionary to handle collisions through seperate chaining. It also 
 uses a polynomial hash function to map configurations into positions within the hash table.
 **/

 import java.util.LinkedList;

 // HashDictionary class implement DictionaryADT class: 
 public class HashDictionary implements DictionaryADT {
     private LinkedList<Data>[] myHashDict; // Array of linked lists to implement seperate chaining 
     private int size; // Size of the hash table
     private int numRecords; // Number of records stored in the hash dictionary 
 
     // Constructor used to initialize the hash table and linked lists 
     public HashDictionary(int size) {
         myHashDict = new LinkedList[size];
         for (int i = 0; i < size; i++) {
             myHashDict[i] = new LinkedList<>();
         }
         this.size = size;
         numRecords = 0;
     }
 
     // Polynomial hash function that maps a string into a position within the hash table:
     private int polynomialHashFunction(String input, int x, int M) {
         int val = 0;
 
         for (int i = 0; i < input.length(); i++) {
             val = (val + (int) input.charAt(i)) * x % M;
         }
         val %= M;
         return val;
     }
 
     // Adds a record to the dictionary and handles collisions through seperate chaining:
     @Override
     public int put(Data record) throws DictionaryException {
         int x = polynomialHashFunction(record.getConfiguration(), 27, size);
         LinkedList<Data> myChain = myHashDict[x];
 
         //Checks for duplicates:
         for(int i = myHashDict[x].size() - 1; i >= 0; i--) { 
             if(myHashDict[x].get(i).getConfiguration().equals(record.getConfiguration())) {
                 throw new DictionaryException();
             }
         }
         myChain.add(record);
         numRecords++;
 
         if (myChain.size() > 1) {
             return 1; // Returns 1 for an occured collision 
         }
         else {
             return 0; // Returns 0 otherwise
         }
     }
 
     // Removes a record with the given configuration from the dictionary:
     @Override
     public void remove(String config) throws DictionaryException {
         int x = polynomialHashFunction(config, 27, size);
         LinkedList<Data> myChain = myHashDict[x];
         
         // Searches from the record and removes it:
         for (int i = myChain.size() - 1; i >= 0; i--) {
             if (myChain.get(i).getConfiguration().equals(config)) {
                 myChain.remove(i);
                 numRecords--;
                 return;
             }
         }
         // Throws an exception if the entry doesn't exist:
         throw new DictionaryException();
     }
 
     // Retrieves the game score that is stored in the record with the allotted configuration:
     @Override 
     public int get(String config) {
         int x = polynomialHashFunction(config, 27, size);
 
         // Creates a new linked list if it doesn't exist:
         if (myHashDict[x] == null) {
             myHashDict[x] = new LinkedList<>();
         }
         LinkedList<Data> myChain = myHashDict[x];
 
         // Searches for the given configuration and returns the score:
         for(int i = 0; i < myChain.size(); i++) {
             if(myChain.get(i).getConfiguration().equals(config)) {
                 return myChain.get(i).getScore();
             }
         }
         return -1; // Returns -1 if the configuration is not in the given dictionary
     }
 
     @Override
     public int numRecords() {
         return numRecords; // Returns the number of stored records in the dictionary
     }
 }