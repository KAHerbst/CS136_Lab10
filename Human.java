import java.util.Scanner;

public class Human implements Player{
    
    char color;
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
	char opponentColor = node.root.opponent(color);
	if(!node.root.win(opponentColor) || !node.root.win(this.color))
	    {
		//this is a vector of HexMoves
		System.out.println(node.root.moves(this.color));
		System.out.println("Which move would you like to take");
		int input = scan.nextInt();
		GameTree nextTree = node.children.get(input-1);
		return opponent.play(nextTree, this);
	    }
	else if(node.root.win(opponentColor)){	    
	    return opponent;
	}
	return this;
    }
}

