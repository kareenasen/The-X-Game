// Student Name: Kareena Sen 
// Student Number: 251277984
/**  
 Description of Program: The Java program "Configurations", represents the state and rules 
 of the board game. The class implements the methods needed by the algorithm for the computer to play the game. 
 **/

 public class Configurations {
    private char[][] board; // Initializes 2D game board array 
    private int board_size; // Initializes game board size variable
    private int lengthToWin;
    private int max_levels;

    // Constructor initializes the game board with spaces ' ':
    public Configurations(int board_size, int lengthToWin, int max_levels) {
        this.board_size = board_size;
        this.lengthToWin = lengthToWin;
        this.max_levels = max_levels;
        
        // Initializes the 2D game board array with empty spaces:
        char[][] myBoardSize = new char[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                myBoardSize[i][j] = ' ';
            }
        }
        board = myBoardSize;
    }

    // Creates a new HashDictionary with a predefined size:
    public HashDictionary createDictionary() {
        return new HashDictionary(8087); // Prime number from the range 6000-10000
    }

    // Checks if the current board configuration is in the hashTable and returns the score:
    public int repeatedConfiguration(HashDictionary hashTable) {
        String boardString = convertBoardToString(board);
        int score = hashTable.get(boardString);
        return score;
    }

    // Adds the current game board configuration and score to the hashDictionary:
    public void addConfiguration(HashDictionary hashDictionary, int score) {
        String boardString = convertBoardToString(board);
        Data newConfig = new Data(boardString, score);
        hashDictionary.put(newConfig);
    }

    // Saves a play by updating the board at the given row and column with the given symbol:
    public void savePlay(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Checks if a given square on the game board is empty or not:
    public boolean squareIsEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    // Checks to see if there is a winning game configuration on the board for a given symbol:
    public boolean wins (char symbol) {
        int xLength;
        int plusLength;
        int maxLength = 0;
        boolean checkUp;
        boolean checkDown;
        boolean checkLeft;
        boolean checkRight;
        boolean checkUpAndLeft;
        boolean checkUpAndRight;
        boolean checkDownAndLeft;
        boolean checkDownAndRight;
        int incrementI;
        int incrementJ;

        for(int i = 0; i < board_size; i++) {
            for(int j = 0; j < board_size; j++) {
                if(board[i][j] == symbol) {
                    checkUp = true;
                    checkDown = true;
                    checkLeft = true;
                    checkRight = true;
                    checkUpAndLeft = true;
                    checkUpAndRight = true;
                    checkDownAndLeft = true;
                    checkDownAndRight = true;
                    xLength = 1;
                    plusLength = 1;
                    incrementJ = j;
                    while(checkUp) {
                        incrementJ++;
                        if(incrementJ < board_size && board[i][incrementJ] == symbol) {
                            plusLength++;
                        }
                        else{
                            checkUp = false;
                        }
                    }
                    incrementJ = j;
                    while(checkDown) {
                        incrementJ--;
                        if(incrementJ >= 0 && board[i][incrementJ] == symbol) {
                            plusLength++;
                        }
                        else {
                            checkDown = false;
                        }
                    }
                    incrementI = i;
                    while(checkRight) {
                        incrementI++;
                        if(incrementI < board_size && board[incrementI][j] == symbol) {
                            plusLength++;
                        }
                        else {
                            checkRight = false;
                        }
                    }
                    incrementI = i;
                    while(checkLeft){
                        incrementI--;
                        if(incrementI >= 0 && board[incrementI][j] == symbol) {
                            plusLength++;
                        }
                        else {
                            checkLeft = false;
                        }
                    }
                    incrementI = i;
                    incrementJ = j;
                    while(checkUpAndLeft){
                        incrementI--;
                        incrementJ++;
                        if(incrementI >= 0 && incrementJ < board_size && board[incrementI][incrementJ] == symbol) {
                            xLength++;
                        }
                        else{
                            checkUpAndLeft = false;
                        }
                    }
                    incrementI = i;
                    incrementJ = j;
                    while(checkUpAndRight){
                        incrementI++;
                        incrementJ++;
                        if(incrementI <board_size && incrementJ < board_size && board[incrementI][incrementJ] == symbol) {
                            xLength++;
                        }
                        else{
                            checkUpAndRight = false;
                        }
                    }
                    incrementI = i;
                    incrementJ = j;
                    while(checkDownAndLeft) {
                        incrementI--;
                        incrementJ--;
                        if(incrementI >= 0 && incrementJ >= 0 && board[incrementI][incrementJ] == symbol) {
                            xLength++;
                        }
                        else{
                            checkDownAndLeft = false;
                        }
                    }
                    incrementI = i;
                    incrementJ = j;
                    while(checkDownAndRight){
                        incrementI++;
                        incrementJ--;
                        if(incrementI < board_size && incrementJ >= 0 && board[incrementI][incrementJ] == symbol) {
                            xLength++;
                        }
                        else {
                            checkDownAndRight = false;
                        }
                    }
                    if(plusLength > maxLength) {
                        maxLength = plusLength;
                    }
                    if(xLength > maxLength) {
                        maxLength = xLength;
                    }
                }
            }
        }
        if(maxLength >= lengthToWin) {
            return true;
        }
        else {
            return false;
        }
    }

    // Checks if the played game is a draw or not:
    public boolean isDraw () {
        int emptyCount = 0;
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (squareIsEmpty(i, j)) {
                    emptyCount++;
                }
            }
        }
        if (emptyCount == 0 && !wins('X') && !wins('O')) {
            return true;
        }
        else {
            return false;
        }
    }

    // Forsees the current state of the board: 
   public int evalBoard() {
        if(wins('O')) {
            return 3;
        }
        else if(wins('X')) {
            return 0;
        }
        else if(isDraw()) {
            return 2;
        }
        else {
            return 1;
        }
   }

   // Helper private function that converts the 2D game board array to a String for hashing or comparison:
    private String convertBoardToString(char[][] board) {
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                boardString.append(board[i][j]);
            }
        }
        return boardString.toString();    
    }
}