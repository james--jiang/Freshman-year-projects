public class Chess {

	private Piece[][] piece_array = new Piece[8][8];
	private String turn = "White";
	private Piece selected_piece;
	private int prevx;
	private int prevy;
	private boolean moved = false;

	public Chess(boolean empty){
		if (empty == false){
			DrawBoard();
			PlacePieces();

		}

		else{
			DrawBoard();
		}
	}

	public void DrawBoard(){
		StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
		int x = 0;
		int y = 0;
		for (int i = 0; i < 8; i++){
			for (int h = 0; h < 8; h++){
				if (((i + h) %2) == 0){
					StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
				}
				else {
					StdDrawPlus.setPenColor(StdDrawPlus.MAGENTA);
				}
 				StdDrawPlus.filledSquare(x+.5,y+.5,.5);
				y = y + 1;

			}

			y = 0;
			x = x + 1;
				}
	}

	public void DrawPieces(){
		int i = 0;
		int j = 0;
		if (selected_piece != null){
			StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			StdDrawPlus.filledSquare(prevx+0.5,prevy+0.5,0.5);
		}
		while (i <= 7){
			while (j <= 7){
			Piece the_piece = piece_array[i][j];
			if (the_piece == null){}
			else if (the_piece.getType() == "bishop" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whitebishop.png",1,1);}
			else if (the_piece.getType() == "knight" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whiteknight.png",1,1);}
			else if (the_piece.getType() == "king" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whiteking.png",1,1);}
			else if (the_piece.getType() == "queen" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whitequeen.png",1,1);}
			else if (the_piece.getType() == "pawn" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whitepawn.png",1,1);}
			else if (the_piece.getType() == "rook" && the_piece.getSide() == 0) {StdDrawPlus.picture(i+0.5,j+0.5,"images/whiterook.png",1,1);}
			else if (the_piece.getType() == "bishop" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackbishop.png",1,1);}
			else if (the_piece.getType() == "knight" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackknight.png",1,1);}
			else if (the_piece.getType() == "king" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackking.png",1,1);}
			else if (the_piece.getType() == "queen" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackqueen.png",1,1);}
			else if (the_piece.getType() == "pawn" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackpawn.png",1,1);}
			else if (the_piece.getType() == "rook" && the_piece.getSide() == 1) {StdDrawPlus.picture(i+0.5,j+0.5,"images/blackrook.png",1,1);}
			j = j+1;
	}
	j = 0;
	i = i + 1;

	}}

	public void place(Piece p, int x, int y){

		if ((x > 7 || y > 7) || (p == null)){}
		else if (piece_array[x][y] == null){
		piece_array[x][y] = p;
		}

	}
	public Piece pieceAt(int x,int y){
		if (OutofBounds(x,y)) {return null;}

		else {return piece_array[x][y];}
	
	}
	public void PlacePieces(){
		int row1 = 0;
		int row2 = 1;
		for (int i = 0; i < 2; i++){
		
		Piece rook = new Piece(this,"rook",i,false,0,row1);
		piece_array[0][row1] = rook;
		Piece rook2 = new Piece(this,"rook",i,false,7,row1);
		piece_array[7][row1] = rook2;
		Piece knight = new Piece(this,"knight",i,false,1,row1);
		piece_array[1][row1] = knight;
		Piece knight2 = new Piece(this,"knight",i,false,6,row1);
		piece_array[6][row1] = knight2;
		Piece bishop = new Piece(this,"bishop",i,false,2,row1);
		piece_array[2][row1] = bishop;
		Piece bishop2 = new Piece(this,"bishop",i,false,5,row1);
		piece_array[5][row1] = bishop2;
		Piece queen = new Piece(this,"queen",i,false,3,row1);
		piece_array[3][row1] = queen;
		Piece king = new Piece(this,"king",i ,true,4,row1);
		piece_array[4][row1] = king;
		for (int j = 0; j < 8; j++){
			Piece pawn = new Piece(this,"pawn",i,false,j,row2);
			piece_array[j][row2] = pawn;

		}
		row1 = 7;
		row2 = 6;

	}}


	private boolean canSelect(int x,int y){

		if (selected_piece == null){
			if (pieceAt(x,y) == null){}

			else if (turn == "White" && pieceAt(x,y).getSide() == 0){
				return true;
			}
			else if (turn == "Black" && pieceAt(x,y).getSide() == 1){
				return true;
			}
		}


		else {

			if (prevx == x && prevy == y){return false;}
			if (moved == false){
			return true;}
		}

		return false;
	}

	private void select(int x, int y){
		if (selected_piece == null){
			selected_piece = pieceAt(x,y);
			prevx = x;
			prevy = y;
		}


		else {

			if (pieceAt(x,y) != null){
				if (turn == "White"){
					if (pieceAt(x,y).getSide() == 0){
						selected_piece = pieceAt(x,y);
						prevx = x;
						prevy = y;
					}}
				if (turn == "Black"){
					if (pieceAt(x,y).getSide() == 1){
						selected_piece = pieceAt(x,y);
						prevx = x;
						prevy = y;
					}}}

			else if (ValidMove(prevx,prevy,x,y)){
			System.out.println("Valid");

			selected_piece.move(x,y);
			moved = true;
			prevx = x;
			prevy = y;}
		}
	}


	private boolean ValidMove(int xi,int yi,int xf,int yf){
		/* Begin validmove for white pawns */
		/* This method will be very, very long */
		if (pieceAt(xi,yi).getType().equals("pawn") && pieceAt(xi,yi).getSide() == 0){
			if (pieceAt(xi,yi).pawnfirstmove()){
				if ((xf - xi == 0) && (yf - yi == 2) && (pieceAt(xf,yf) == null)) {
					return true;
				}
			}
			else {
				/* Not first move */
				if ((xf - xi == 0) && (yf - yi ==1)) {return true;}
				/* Pawn captures*/
				else if ((xf - xi == 1) && (yf - yi == 1) && (pieceAt(xf,yf) != null)) {
					if (pieceAt(xf,yf).getSide() == 1) {return true;}}
				else if ((xf - xi == -1) && (yf - yi == 1) && (pieceAt(xf,yf) != null)){
					if (pieceAt(xf,yf).getSide() == 1){return true;}}
			}

			return false;
		}

		/* Begin validmove for white bishops */
		if (pieceAt(xi,yi).getType().equals("bishop") && pieceAt(xi,yi).getSide() == 0){
			if (Math.abs(xf - xi) == Math.abs(yf - yi)){
				return true;
			}

			return false;
		}

		return true;
	}

	private boolean OutofBounds(int x, int y){
		if ((x > 7) || (y > 7) || (x < 0)|| (y < 0)){return true;}
		else {return false;}}


	public Piece remove(int x, int y){
		if (pieceAt(x,y) == null){
								  return null;}
		if (OutofBounds(x,y)){
							return null;}

		else {
			Piece pie = pieceAt(x,y);
			piece_array[x][y] = null;
			
			return pie;}
	}

	public boolean canEndturn(){
		if (moved == true){
			return true;
		}

		else {
			return false;
		}
	}

	public void endTurn(){
		moved = false;
		selected_piece = null;
		if (turn == "White"){
			turn = "Black";
		}

		else if (turn == "Black"){
			turn = "White";
		}

	}

	public void GUI(){
		while (true){
		DrawBoard();
		DrawPieces();
		if (StdDrawPlus.mousePressed()){
			if (canSelect((int) StdDrawPlus.mouseX(), (int) StdDrawPlus.mouseY())){
				select((int) StdDrawPlus.mouseX(),(int) StdDrawPlus.mouseY());}}
		
	     if (StdDrawPlus.isSpacePressed()){
	     		if (canEndturn()){
	     			endTurn();
	     		}
	        	}
	        

		StdDrawPlus.show(50);}

	}
	public static void main(String[] args){
		StdDrawPlus.setXscale(0,8);
		StdDrawPlus.setYscale(0,8);
		Chess c = new Chess(false);
		c.GUI();

	}
	}



