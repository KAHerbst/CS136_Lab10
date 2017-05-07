import structure5.*;
import java.util.Random;
public class RandomPlayer implements Player{
    
    // the computer will pick random moves but remove losing moves
    Random random;  
    
    public RandomPlayer(){
	random = new Random();
    }
    
    // pre: node is a non-null game tree node 
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned    
    public Player play(GameTree node, Player opponent){
	
	// if the last move resulted in a loss or it leads to a dead end
	// prune the node and return next player
	char opponentColor = node.root.opponent(node.color);
	if(node.root.win(opponentColor)){
	    return opponent;
	}
	
	// if the computer won, return the computer as the winner
	else if(node.root.win(node.color)) return this;
	
	else{
	    //choose a random move from the node's children
	    if(node.children.isEmpty()){
		return opponent;
	    }	 
		GameTree nextMove = node.children.get(random.nextInt(node.children.size())); 
		return opponent.play(nextMove,this);
	}
    }
}
