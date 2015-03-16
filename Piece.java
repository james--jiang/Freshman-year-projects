public class Piece {
	private Chess c;
	private String type;
	private int side;
	private boolean king;
	private int h;
	private int v;
	private boolean pawn_first_move = true;
	
	public Piece(Chess cz, String t,int s, boolean isKing,int x,int y){
		c = cz;
		type = t;
		side = s;
		king = isKing;
		h = x;
		v = y;
	}

	public String getType(){
		return type;
	}

	public int getSide(){
		return side;
	}

	public boolean isKing(){
		return king;
	}

	public boolean pawnfirstmove(){
		return pawn_first_move;
	}

	public void move(int x, int y){
		c.remove(h,v);
		if (c.pieceAt(x,y) != null){
			c.remove(x,y);
		}
		c.place(this,x,y);
		
		h = x;
		v = y;
	}


}