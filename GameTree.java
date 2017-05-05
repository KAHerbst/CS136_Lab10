import structure5.*;
import java.util.Iterator;

public class GameTree{

    int level;
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

    GameTree(int rows, int cols){
	this.root = new HexBoard(rows, cols);
	this.children = new Vector<GameTree>();
	populate();
    }

    GameTree(HexBoard hex){
	this.root = hex;
	this.children = new Vector<GameTree>();
    }

    public boolean validMove(){
	return true;
    }

    public GameTree move(){
	return null;
    }

    public GameTree remove(){
	return null;
    }

    public void populate(){
	populateHelper(this,'*');
    }

    public void add(){

    }
    
    public void populateHelper(GameTree tree, char player){
	HexBoard currentBoard = tree.root;
	if(currentBoard.win('*') || currentBoard.win('o')) return;
	Iterator<HexMove> moves = currentBoard.moves(currentBoard.opponent(player)).iterator();
	while(moves.hasNext()){
	    GameTree nextMove = new GameTree(new HexBoard(currentBoard, moves.next()));
	    this.children.add(nextMove);
	    populateHelper(nextMove,currentBoard.opponent(player));	    
	}
    }

    public String toString(){
	return toStringHelper(this, "");
    }
    
    public String toStringHelper(GameTree current, String str){
	Iterator<GameTree> childrenIter = current.children.iterator();
	while(childrenIter.hasNext()){
	    GameTree next = childrenIter.next();
	    str = str + next.root.toString();
	    toStringHelper(next,str);
	}
	return str;
    }

    public static void main(String[] argv){
	GameTree dysron = new GameTree();
	System.out.println(dysron);
    }
    
}
