import java.util.Scanner;

public class Human implements Player{
    
    protected char color;
    protected Scanner scan;

    public Human(char color){
	this.color = color;
	this.scan = new Scanner(System.in);
    }
    // pre: node is a non-null game tree node 
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned
    public Player play(GameTree node, Player opponent){
	    //as long as nobody has won at that node
	if(!node.board.win(opponent.color) || !node.board.win(this.color))
	  {
	      //this is a vector of HexMoves
	      System.out.println(node.moves(this.color));
	      System.out.println("Which move would you like to take");
	      String input = scan.nextLine();
	      GameTree nextTree = node.children.moves(this.color).get(input);
	      return opponent.play(nextTree, this);
	}
	else if(node.board.win(opponent.color)){	    
	    return opponent;
	}
	return this;
    }
}

