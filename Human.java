public class Human implements Player{
    
    protected char color;

    public Human(char color){
	this.color = color;
    }
    // pre: node is a non-null game tree node 
    // opponent is the player to play after this player
    // post: game is played from this node on; winning player is returned
	//opponent can be the switch of Human color in our HexBoard class
    public Player play(GameTree node, Player opponent){
	    //as long as nobody has won at that node
	if(!node.board.win(opponent.color) || !node.board.win(this.color))
	  {
		//look in the nodes children and print them out
		//choose one via Scanner 
		//set the new gametree with the root at that choice
		//return a GameTree
	    return opponent;
	}	
}

