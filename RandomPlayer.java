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
	
	char opponentColor = node.root.opponent(node.color);
	if(node.root.win(opponentColor)){
	    return opponent;
	}
	
	// if the computer won, return the computer as the winner
	else if(node.root.win(node.color)) return this;
	
	else{
	    // if there are no more moves, the opponent wins
	    if(node.children.isEmpty()){
		return opponent;
	    }
	    //choose a random move from the node's children
	    GameTree nextMove = node.children.get(random.nextInt(node.children.size())); 
	    return opponent.play(nextMove,this);
	}
    }
}
