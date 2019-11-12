import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class newSpaceInvader 
{
  static String [][] board = createBoard(7, 7);
  static String[] aliensOne = {"#","#","#","#","#","#","#",};
  static String[] aliensTwo = {"@","@","@","@","@","@","@",};
  static String [] player = {" "," "," ","^"," "," "," "};
  
  static int firstRow = 0;
  static int secondRow = 1;
  
  
  
  static int secondsPassed = 0;
  
  Timer myTimer = new Timer();
  TimerTask task = new TimerTask(){
    public  void run(){
      secondsPassed++;
      
      if (secondsPassed == 7){
        firstRow++;
        secondRow++;
        resetBoard(board);
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        printBoard(board);
        
        for (int i=0; i<=6; i++)
        {
          System.out.print("[" + player[i] + "]");
        }
        System.out.println();
        System.out.println(); 
      }
      if (secondsPassed == 14){
        firstRow++;
        secondRow++;
        resetBoard(board);
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        printBoard(board);
        
        for (int i=0; i<=6; i++)
        {
          System.out.print("[" + player[i] + "]");
        }
        System.out.println();
        System.out.println(); 
      }
      if (secondsPassed == 21){
        firstRow++;
        secondRow++;
        resetBoard(board);
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        printBoard(board);
        
        for (int i=0; i<=6; i++)
        {
          System.out.print("[" + player[i] + "]");
        }
        System.out.println();
        System.out.println(); 
      }
      if (secondsPassed == 28){
        firstRow++;
        secondRow++;
        resetBoard(board);
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        printBoard(board);
        
        for (int i=0; i<=6; i++)
        {
          System.out.print("[" + player[i] + "]");
        }
        System.out.println();
        System.out.println(); 
      }
      if (secondsPassed == 35){
        firstRow++;
        secondRow++;
        resetBoard(board);
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        printBoard(board);
        
        for (int i=0; i<=6; i++)
        {
          System.out.print("[" + player[i] + "]");
        }
        System.out.println();
        System.out.println(); 
      }
      
      if (secondsPassed > 45){
        System.out.println("THEY REACHED EARTH!"); 
        System.out.println("You Lose!"); 
        try{
          Thread.sleep(1100);
        } catch (InterruptedException ie)
        {
          System.out.println("Scanning...");
        }
        System.exit(0);
      }
    }
  };
  
  public void runTimer(){
    myTimer.schedule(task, 1000 , 1000);
    
  }
  
  public static void main(String[] args)
  {
    System.out.println("Hello welcome to Space Invaders!");
    System.out.println("Destroy the Aliens before they reach YOU!");
    System.out.println("Input your commands and press enter");
    System.out.println("A is to go Left, D is to go Right, S is to Shoot, Q is to Quit, R is to Reset");
    System.out.println("Enter any button to start or Q to Quit");
    
    Scanner myInput = new Scanner(System.in);
    String command; // user's name
    
    command = myInput.nextLine();
    
    if (command.equals("Q") || command.equals("q")){
      System.out.println("Thanks for playing!");
      try{
        Thread.sleep(2000);
      } catch (InterruptedException ie)
      {
        System.out.println("Scanning...");
      }
      
      System.exit(0);
    }
    
    
    newSpaceInvader spaceInvader = new newSpaceInvader();
    spaceInvader.runTimer();
    myInput.close();
    playGame();
  }
  
  public static void playGame(){
    Scanner myInput = new Scanner(System.in);
    int killCounter = 0;
    
    populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
    printBoard(board);
    
    
    int playerPosition = 3;
    
    for (int i=0; i<=6; i++)
    {
      System.out.print("[" + player[i] + "]");
    }
    System.out.println();
    System.out.println(); 
    
    
    String input = "";  
    
    while (!input.equals("Q") || !input.equals("q")){
      if (killCounter == 14){
        
        try{
          Thread.sleep(1100);
        } catch (InterruptedException ie)
        {
          System.out.println("Scanning...");
        }
        System.out.println("Congrats on winning the Game!");
        System.exit(0);
      }
      
      // Delay each input
      if (secondsPassed == 6 || secondsPassed == 13 || secondsPassed == 20 || secondsPassed == 27 
            || secondsPassed == 34)
      try{
          Thread.sleep(2000);
        } catch (InterruptedException ie)
        {
          System.out.println("Scanning...");
        }
        
      input = myInput.nextLine(); 
      if (input.equals("A") || input.equals("a")){
        if (playerPosition == 0){
          player = movePlayer(playerPosition);
        }
        else{
          playerPosition--;
          player = movePlayer(playerPosition);
        }
      }
      if ((input.equals("D") || input.equals("d")) && playerPosition <= 6){
        if (playerPosition == 6){
          player = movePlayer(playerPosition);
        }
        else{
          playerPosition++;
          player = movePlayer(playerPosition);
        }
      }
      if (input.equals("S") || input.equals("s")){
        if (board[playerPosition][secondRow] == "@"){
          aliensTwo[playerPosition] = " ";
          resetBoard(board);
          populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
          killCounter++;
        }
        else if (board[playerPosition][firstRow] == "#"){
          aliensOne[playerPosition] = " ";
          resetBoard(board);
          populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
          killCounter++;
        }
        
      }
      if (input.equals("Q") || input.equals("q")){
        System.out.println("Thanks for playing!");
        try{
          Thread.sleep(1000);
        } catch (InterruptedException ie)
        {
          System.out.println("Scanning...");
        }
        
        System.exit(0);
      }
      
      if (input.equals("R") || input.equals("r")){
        System.out.println("Resetting...");
        try{
          Thread.sleep(1000);
        } catch (InterruptedException ie)
        {
          System.out.println("Scanning...");
        }
        
        resetBoard(board);
        firstRow = 0;
        secondRow = 1;
        playerPosition = 3;
        secondsPassed = 0;
        
        for (int i=0; i<=6; i++)
        {
          player[i] = " ";
        }
        player[playerPosition] = "^";
        String[] aliensOne = {"#","#","#","#","#","#","#",};
        String[] aliensTwo = {"@","@","@","@","@","@","@",};
        populateBoard(board, firstRow, secondRow, aliensOne, aliensTwo);
        
      }
      
      printBoard(board);
      for (int i=0; i<=6; i++)
      {
        System.out.print("[" + player[i] + "]");
      }
      System.out.println();
      System.out.println(); 
    } 
    myInput.close();
  }
  
  public static String [] movePlayer(int playerPosition)
  {
    if (playerPosition < 0){
      playerPosition = 0; 
    }
    if (playerPosition > 6){
      playerPosition = 6; 
    }
    String[] defaultPos = {" "," "," "," "," "," "," ",};
    
    defaultPos[playerPosition] = "^";
    return defaultPos;
  }
  /*
   * Author: A. Bozic
   * Method Name: populateBoard
   * Method Type: void
   * Description: populates the board 2D array with aliens
   * Parameters: board (2D String Array), firstRow (where the first row of aliens is), 
   * secondRow (where the second row of aliens is)
   * Returns: n/a
   */
  public static void populateBoard(String[][] board, int firstRow, int secondRow, String[] aliensOne, String[] aliensTwo)
  {
    
    // nested for loop prints each row one at a time in the board
    
    for (int i = 0; i<=6; i++)
    {
      board[i][firstRow] = aliensOne[i];
      board[i][secondRow] = aliensTwo[i];
    }            
    //ends for
  }//ends method printBoard
  
  /*
   * Author: C. McCaffery
   * Method Name: printBoard
   * Method Type: void
   * Description: prints a 2 dimensional board to the screen
   * Parameters: board (2D String Array)
   * Returns: n/a
   */
  public static void printBoard(String[][] board)
  {
    
    // nested for loop prints each row one at a time in the board
    for (int r = 0; r<=board[0].length-1; r++)
    {
      for (int c = 0; c<=board.length-1; c++)
      {
        System.out.print("[" + board[c][r] + "]");
      }
      System.out.println();             
    }//ends for
  }//ends method printBoard
  
  
  /*
   * Author: C. McCaffery
   * Method Name: createBoard
   * Method Type: 2D Array of Strings
   * Description: creates a 2 dimensional board and assigns all of the
   *              initial values to " "
   * Parameters: columns (integer - number of columns in board),
   *             rows (integer - number of rows in board
   * Returns: 2D Array of Strings all with values " "
   */   
  public static String [][] createBoard(int columns, int rows)
  {
    //creates the two dimentional array for the board
    String [][] board = new String[columns][rows];
    //assigns each position an initial value of " "
    for  (int r = 0; r<=rows-1; r++)
    {
      for (int c = 0; c<=columns-1; c++)
      {
        board[c][r]= " ";
      }
    }
    return board;
  }
// ends method createBoard
  /*
   * 
   * Author: C. McCaffery
   * Method Name: resetBoard
   * Method Type: 2D Array of Strings
   * Description: resets a 2 dimensional board and assigns all of the
   *              initial values to " "
   * Parameters: board
   * Returns: 2D Array of Strings all with values " "
   */   
  public static String [][] resetBoard(String [][] board)
  {
    // sets the columns and rows to their current length
    int columns = board.length;
    int rows = board[0].length;
    // at each position [c][r], reset value to " "
    for (int r = 0; r<=rows-1; r++)
    {
      for (int c = 0; c<=columns-1; c++)
      {
        board[c][r]=" ";
      }
    }
    return board;
  }// ends method resetBoard
  
  /*
   * Author: C. McCaffery
   * Method Name: printBoard
   * Method Type: void
   * Description: prints a 2 dimensional board to the screen
   * Parameters: board (2D int Array)
   * Returns: n/a
   */
  public static void printBoard(int[][] board)
  {
    // nested for loop prints each row one at a time in the board
    for (int r = 0; r<=board[0].length-1; r++)
    {
      for (int c = 0; c<=board.length-1; c++)
      {
        System.out.print("[" + board[c][r] + "]");
      }
      System.out.println();             
    }//ends for
  }//ends method printBoard
  
  /*
   * Author: C. McCaffery
   * Method Name: resetBoard
   * Method Type: 2D Array of Strings
   * Description: resets a 2 dimensional board and assigns all of the
   *              initial values to " "
   * Parameters: board
   * Returns: 2D Array of Strings all with values " "
   */   
  public static int [][] resetBoard(int [][] board)
  {
    // sets the columns and rows to their current length
    int columns = board.length;
    int rows = board[0].length;
    // at each position [c][r], reset value to " "
    for (int r = 0; r<=rows-1; r++)
    {
      for (int c = 0; c<=columns-1; c++)
      {
        board[c][r]=0;
      }
    }
    return board;
  }// ends method resetBoard
}// ends class Mem
