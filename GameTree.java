import structure5.*;
import java.util.Iterator;

public class GameTree{
    
    GameTree parent;
    char color;
    static int boardCount = 1;
    HexBoard root;
    Vector<GameTree> children;
    
    /**
     * Creates a "full" GameTree representing every possible state of our hex-a-pawn game
     **/
    GameTree(HexBoard hex, char color){
	this.root = hex;
	this.color = color;
	this.children = new Vector<GameTree>();
    }

    // post: constructs the entire GameTree
    public void populate(){
	populateHelper(this,color);
    }
    
    protected void populateHelper(GameTree tree, char player){
	HexBoard currentBoard = tree.root;
	if(currentBoard.win('*') || currentBoard.win('o')) return;
	Iterator<HexMove> moves = currentBoard.moves(player).iterator();

	GameTree.boardCount += currentBoard.moves(player).size();
	   
	while(moves.hasNext()){
	     HexBoard nextBoard = new HexBoard(currentBoard, moves.next());
	    char opponentColor = nextBoard.opponent(player);
	    GameTree nextMove = new GameTree(nextBoard,opponentColor);
	    nextMove.setParent(tree);
	    tree.children.add(nextMove);
	    populateHelper(nextMove,opponentColor);	    
	}
    }

    // post: sets a parent GameTree so you can go back up the tree (for pruning)
    public void setParent(GameTree parent){
	this.parent = parent;
    }

    /**
    public String toString(){
	return toStringHelper(this, ""+this.root.toString());
    }
    protected String toStringHelper(GameTree current, String str){
	if(current.children.isEmpty()) return current.root.toString() + str;
	Iterator<GameTree> childrenIter = current.children.iterator();
	while(childrenIter.hasNext()){
	    GameTree next = childrenIter.next();
	    System.out.println(next.root);
	    toStringHelper(next,str+next.root.toString());
	}
	return str;
    }
    **/
   
}
