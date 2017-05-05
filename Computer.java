import structure5.*;
import java.util.Random;
public class Computer implements Player{
    
    // the computer will pick random moves but remove losing moves
    Random random;
    char color;
    
    public Computer(char color){
	this.color = color;
	random = new Random();
    }
    
    // pre: node is a non-null game tree node 
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned    
    public Player play(GameTree node, Player opponent){
	
	// if the last move resulted in a loss or it leads to a dead end
	// prune the node and return next player
	if(node.board.win(opponent.color) ||
	  (!node.board.win(color) && !node.board.win(opponent.color)
		&& node.children.isEmpty())){
	    node.parent.children.remove(node);
	    return opponent;
	}
	
	// if the computer won, return the computer as the winner
	else if(node.board.win(this.color)) return this;

	else{
	    //choose a random move from the node's children
	    node = node.children.get(random.nextInt(node.children.size()));
	    return null;
	}
	
    }
}
