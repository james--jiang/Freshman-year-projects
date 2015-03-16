public class Calopoly {
	

	public Calopoly(){

	}
	
	public void DrawBoard(){
		StdDrawPlus.picture(8,8,"images/cal.jpg",20,20);
		
		StdDrawPlus.setPenColor(StdDrawPlus.RED);
		StdDrawPlus.text(2,0,"P1");
		StdDrawPlus.picture(3,0,"images/money.png",1.5,1.5);
		StdDrawPlus.text(4.5,0,": $2000");


		StdDrawPlus.setPenColor(StdDrawPlus.GREEN);

		StdDrawPlus.text(0,14,"P2");
		StdDrawPlus.setPenColor(StdDrawPlus.YELLOW);
		StdDrawPlus.text(2,16,"P3");
		StdDrawPlus.setPenColor(StdDrawPlus.BLUE);
		StdDrawPlus.text(16,14,"P4");

		/* Black Block */
		/* Foothill and Bowles Sucks to be you */
		StdDrawPlus.setPenColor(StdDrawPlus.BLACK);

		for (int i = 12; i >= 4; i -= 2){
		if (i == 8 || i == 4){StdDrawPlus.picture(2,i,"images/black" + i + ".jpg",2,2);}
		else {
		StdDrawPlus.filledSquare(2,i,1);
		StdDrawPlus.picture(2,i,"images/black" + i + ".jpg",1.5,1.5);}
	}

		/* Red Block * #classic buildings/
		/* Dwinelle, Wheeler, Evans */

		StdDrawPlus.setPenColor(StdDrawPlus.RED);
		for (int i = 2; i <= 6; i = i +2) {
			StdDrawPlus.filledSquare(i,2,1);
			StdDrawPlus.picture(i,2,"images/" + i + ".jpg",1.5,1.5);
		}
		StdDrawPlus.filledSquare(8,2,1);
		StdDrawPlus.picture(8,2,"images/facultyglade.jpg",2,2);

		/* Yellow Block * #science/
		/**hildebrand, vlsb,*/
		StdDrawPlus.setPenColor(StdDrawPlus.YELLOW);
		for (int i = 10; i <= 14; i = i +2) {
			if (i == 14){StdDrawPlus.picture(i,2,"images/freetuition.gif",2,2);}
			else {
			StdDrawPlus.filledSquare(i,2,1);
			StdDrawPlus.picture(i,2,"images/" + i + ".jpg",1.5,1.5);}
		}

		/* Pink Block * #units/
		/* Unit1,unit2,unit3 */
		StdDrawPlus.setPenColor(StdDrawPlus.PINK);
		for (int i = 4; i <= 14; i = i + 2){
			if (i == 8 || i == 12 || i == 14){StdDrawPlus.picture(14,i,"images/pink" + i + ".jpg",2,2);
			}



			else{
			StdDrawPlus.filledSquare(14,i,1);
			StdDrawPlus.picture(14,i,"images/pink" + i + ".jpg",1.5,1.5);}
		}

		/* White Block */
		/* haas, haas pav */
		StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
		for (int i = 12; i >= 10; i -=2){
			StdDrawPlus.filledSquare(i,14,1);
			StdDrawPlus.picture(i,14,"images/white" + i + ".jpg",1.5,1.5);


		}

		/* Blue Block */
		/* memorial stadium, campanile*/
		StdDrawPlus.setPenColor(StdDrawPlus.BLUE);
		for (int i = 8; i >= 2; i -= 2){
			if (i == 8){StdDrawPlus.picture(i,14,"images/memorial.jpg",2,2);}
			else if (i == 2){StdDrawPlus.picture(i,14,"images/start.gif",2,2);}
			else {
			StdDrawPlus.filledSquare(i,14,1);
			StdDrawPlus.picture(i,14,"images/blue" + i + ".jpg",1.5,1.5);}
		}
		
		StdDrawPlus.picture(2,12,"images/denero.jpg",1,1);
		StdDrawPlus.picture(2,10,"images/tommy.jpg",1,1);

	}

	public void GUI(){
		DrawBoard();
	}

	public static void main(String[] args){
		StdDrawPlus.setCanvasSize(700,700);

		StdDrawPlus.setScale(0,16);
		StdDrawPlus.setScale(0,16);

		UniLife game = new Calopoly();
		game.GUI();




	}
}