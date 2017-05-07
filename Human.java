import java.util.Scanner;
import structure5.Vector;

public class Human implements Player{

    protected Scanner scan;

    public Human(){
	this.scan = new Scanner(System.in);
    }
    // pre: node is a non-null game tree node
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned
    public Player play(GameTree node, Player opponent){
	//as long as nobody has won at that node
	char opponentColor = node.root.opponent(node.color);
	if(node.root.win(node.color)) return this;
	else if(node.root.win(opponentColor)) return opponent;
	else{
	    System.out.println(node.root);
	    Vector<HexMove> moves = node.root.moves(node.color);	    
	    for(int i = 1; i <= moves.size(); i++){
		System.out.println("Move "+ i+ ": " + moves.get(i-1));
	    }
	    System.out.println("Which move would you like to take");
	    int input = scan.nextInt();
	    GameTree nextTree = node.children.get(input-1);
	    return opponent.play(nextTree, this);
	    }
    }
}

