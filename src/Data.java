// Student Name: Kareena Sen 
// Student Number: 251277984
/**  
 Description of Program: The Java program "Data", represents a data structure for storing
 configurations and scores.
 **/

 public class Data {

    private String configuration; // Stores the game configuration information
    private int score; // Stores the score associated with the game configuration 

    // Constructor that initializes the Data object with configuration and game score:
    public Data(String configuration, int score) {
        this.configuration = configuration; 
        this.score = score;
    }

    // Getter method that retrieves the game configuration: 
    public String getConfiguration() {
        return configuration;
    }

    // Getter method to retrieve the game score:
    public int getScore() {
        return score; // Returns the game score
    }
}