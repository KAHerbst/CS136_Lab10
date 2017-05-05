import structure5.*;
import java.util.Random;
public class RandomPlayer implements Player{
    
    Random random;
    public RandomPlayer(){
	this.random = new Random();
    }

    // pre: node is a non-null game tree node                                                                
    // opponent is the player to play after this player                                                      
    // post: game is played from this node on; winning player is returned                                    
    public Player play(GameTree node, Player opponent){
	char opponentColor = node.root.opponent(node.color);
	if(node.root.win(node.color)) return this;
	else if(node.root.win(opponentColor)) return opponent;
	else{ 
	    int randomChoice = random.nextInt(node.children.size());
	    GameTree nextMove = node.children.get(randomChoice);
	    return opponent.play(nextMove, this);
	} 
	    
    }
}

