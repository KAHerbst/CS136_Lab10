public class Computer implements Player{
    protected char color;

    public Computer(char color){
	this.color = color;
    }
    // pre: node is a non-null game tree node 
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned    
    public Player play(GameTree node, Player opponent){
	return null;
	// basically going to pick the best move and return a new Player(the opponent)
    }
 
}
