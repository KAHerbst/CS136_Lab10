import java.util.Random;
public class Random implements Player{
    Random random;
    protected char color;
    public Random(char color){
	Random random = new Random();
	this.color = color;
    }

    // pre: node is a non-null game tree node                                                                
    // opponent is the player to play after this player                                                      
    // post: game is played from this node on; winning player is returned                                    
    public Player play(GameTree node, Player opponent){
	return null;
    }
}

