import java.util.Scanner;
public class HexaPawn{
    
    
    static private int round;
    protected static int player1wins;
    protected static int player2wins;

    public HexaPawn(){
	round = 1;
	player1wins = 0;
	player2wins = 0;
    }
    
    public static Player assignPlayer(String type){
	if(type.equals("comp")) return new Computer();
	else if(type.equals("human")) return new Human();
	else{ return new RandomPlayer(); }
    }
    
    public static void main(String[] args){
	int rows = Integer.parseInt(args[0]);
	int cols = Integer.parseInt(args[1]);
	Player player1 = assignPlayer(args[2]);
	Player player2 = assignPlayer(args[3]);
	
	// player1 will go first and always start as white
	HexBoard board = new HexBoard(rows,cols);
	GameTree game = new GameTree(board,board.WHITE);
	    
	while(true){
	    Player winner = player1.play(game, player2);
	    if(winner == player1){
		player1wins +=1;
		System.out.println("Player 1 has won!");
	    }
	    else{ 
		player2wins+=1;
		System.out.println("Player 2 has won!"); 
	    }	
	    round+=1;
	    System.out.println("Round: " + round+ "\nPlayer 1: " + player1wins +
			       "     |     Player 2: " + player2wins);
	}
    }
}