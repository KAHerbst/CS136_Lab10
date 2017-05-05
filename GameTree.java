import structure5.*;
import java.util.Iterator;

public class GameTree{

    GameTree parent;
    char color;
    HexBoard root;
    Vector<GameTree> children;

    /**
     * Creates a "full" GameTree representing every possible state of our hex-a-pawn game
     **/
    //white on top
    GameTree(){
	this.root = new HexBoard();
	this.children = new Vector<GameTree>();
	populate();
    }

    GameTree(HexBoard hex, char color){
	this.root = hex;
	this.color = color;
	this.children = new Vector<GameTree>();
	populate();
    }

    public boolean move(int index){
	return true;
    }

    /**
     * prunes the tree by removing a specified HexBoard leaf from the tree
     * @pre: HexBoard leaf is a valid HexBoard in the tree
     * @post: Returns an updated GameTree w/o the argument leaf
     **/
    //in the end I will set leaf.root to be null
    //I could also modify the moves vector for a specified node
    public GameTree remove(GameTree leaf){
	return null;
    }

    public void populate(){
	populateHelper(this,color);
    }

    public void populateHelper(GameTree tree, char player){
	HexBoard currentBoard = tree.root;
	if(currentBoard.win('*') || currentBoard.win('o')) return;
	Iterator<HexMove> moves = currentBoard.moves(player).iterator();
	while(moves.hasNext()){
	    HexBoard nextBoard = new HexBoard(currentBoard, moves.next());
	    nextBoard.setParent(currentBoard);
	    GameTree nextMove = new GameTree(nextBoard,player);
	    tree.children.add(nextMove);
	    populateHelper(nextMove,currentBoard.opponent(player));
	}
    }

    // post: sets a parent GameTree so you can go back up the tree (for pruning)
    public void setParent(GameTree parent){
	this.parent = parent;
    }

    public String toString(){
	return toStringHelper(this, ""+this.root.toString());
    }

    public String toStringHelper(GameTree current, String str){
	if(current.children.isEmpty()) return current.root.toString() + str;
	Iterator<GameTree> childrenIter = current.children.iterator();
	while(childrenIter.hasNext()){
	    GameTree next = childrenIter.next();
	    System.out.println(next.root);
	    toStringHelper(next,str+next.root.toString());
	}
	return str;
    }

    public static void main(String[] argv){
	GameTree dysron = new GameTree(new HexBoard(),'*');
	System.out.println(dysron);
    }

}
