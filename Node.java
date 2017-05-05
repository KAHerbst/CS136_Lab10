/*hexboard and player
//white is moving first

public class Node{

    char player;
    HexBoard value;
    Vector<HexBoard> children;
    
    //if 'o' --> white
    //if '*' --> black
    Node(HexBoard board, int depth){
	this.value = board;
	this.children = board.moves();
	if(depth % 2 == 0){
	    this.player = 'o';
	}
	else{
	    this.player = '*';
	}
    }
}
*/
