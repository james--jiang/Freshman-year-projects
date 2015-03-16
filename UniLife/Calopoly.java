
public class Calopoly {
	

	Property[] squares = new Property[24];
	boolean started = false;
	Player one = new Player("Tommy","images/tommy.jpg",1);
	Player two = new Player("Jose","images/jose.jpg",2);
	Player three = new Player("Fahad","images/fahad.jpg",3);
	Player four = new Player("Jack","images/jack.jpg",4);
	boolean dice_rolled = false;
	int current_square;
	int order = 1;
	int a = RollDice1();
	int b = RollDice1();
	Player current_player = one;


	public void InitializeProperties(){
	squares[0] = new Property("Start",0,"start",0,0,0,"start.gif"); 
	squares[1] = new Property("Bowles",2600,"black",80,160,1,"black12.jpg");
	squares[2] = new Property("Foothill",3200,"black",120,160,2,"black10.jpg");
    squares[3] = new Property("Hearst Mining",6000, "glade",150,0,3,"black8.jpg");
	squares[4] = new Property("Stern", 2800,"black", 90 ,160 ,4,"black6.jpg");
	squares[5] = new Property("Chance",0,"chance",0,0,5,"black4.jpg");
	squares[6] = new Property("Evans",3000, "red", 90,350,6,"2.jpg");
	squares[7] = new Property("Dwinelle", 4000, "red", 100 ,350 ,7,"4.jpg");
	squares[8] = new Property("Wheeler", 4500 ,"red",100, 350 ,8,"6.jpg");
	squares[9] = new Property("Faculty glade", 6000, "glade", 90, 0, 9,"facultyglade.jpg");
	squares[10] = new Property("Hildebrand", 5900, "yellow", 180 ,350 ,10,"10.jpg");
	squares[11] = new Property("VLSB", 7200, "yellow", 220, 350, 11,"12.jpg");
	squares[12] = new Property("Free tuition", 0, "free" ,0 ,0 ,12,"freetuition.jpg");
	squares[13] = new Property("Unit1", 6600, "pink", 450, 580, 13,"pink4.jpg");
	squares[14] = new Property("Unit2", 6400, "pink", 430, 580, 14,"pink6.jpg");
	squares[15] = new Property("Strawberry Creek",6000, "glade", 150, 580, 15,"pink8.jpg");
	squares[16] = new Property("Unit3",6200,"pink",420,580,16,"pink10.jpg");
	squares[17] = new Property("Community Chest", 0, "community", 420, 0, 17,"pink12.jpg");
	squares[18] = new Property("Main stacks", 0, "jail", 0, 0, 18,"pink14.jpg");
	squares[19] = new Property("Haas Pavilion", 9000, "white", 1100 ,1100, 19,"white12.jpg");
	squares[20] = new Property("Haas Business", 13000, "white", 1300, 1100, 20,"white10.jpg");
	squares[21] = new Property("Memorial Glade", 6000, "glade", 150, 0, 21,"memorial.jpg");
	squares[22] = new Property("Memorial Stadium", 18000, "blue", 2800, 1100 ,22,"blue6.jpg");
	squares[23] = new Property("Campanile", 22000, "blue", 3200, 1100, 23,"blue4.jpg");

	}
	

	public void DrawPlayers(){
		StdDrawPlus.picture(one.xc,one.yc,one.picture,2,2);
		StdDrawPlus.picture(two.xc,two.yc,two.picture,2,2);
		StdDrawPlus.picture(three.xc,three.yc,three.picture,2,2);
		StdDrawPlus.picture(four.xc,four.yc,four.picture,2,2);

	}
	public Calopoly(){
		

	}

	public void move(Player p, int number){
		int k = 0;
		while (k < number){
			p.position += 1;
			if (p.position >= 0 && p.position <= 6){
				p.yc = p.yc - 2;
			}

			else if (p.position > 6 && p.position <= 12){
				p.xc = p.xc + 2;
			}

			else if (p.position > 12 && p.position <= 18){
				p.yc = p.yc + 2;
			}

			else if (p.position > 18 && p.position < 24){
				p.xc = p.xc - 2;
			}

			else if (p.position == 24){
				p.position = 0;
				p.xc = p.xc - 2;
			}

			k++;
			}

		current_square = p.position;

		if (squares[current_square].owner != null && squares[current_square].owner != current_player){
			current_player.money -= squares[current_square].rent;
		}





	}

	public int RollDice1(){
		return (int)(Math.random() * 4) + 1;
}

	public int RollDice2(){
		return (int)(Math.random() * 6) + 1;
	}
	
	public void DrawBoard(){
		StdDrawPlus.picture(8,8,"images/cal.jpg",20,20);
		
		

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
		
		if (started == false){
		StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
		StdDrawPlus.filledSquare(8,8,1);
		StdDrawPlus.setPenColor(StdDrawPlus.BLACK);
		StdDrawPlus.text(8,8.7,"Start");}

		else {
		StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
		StdDrawPlus.filledSquare(8,10.5,1.5);
		StdDrawPlus.setPenColor(StdDrawPlus.BLACK);
		StdDrawPlus.text(8,11.7,"Info Panel");


		if (squares[current_square].owner == null){
		StdDrawPlus.text(8,11,"" + squares[current_square].name);
		StdDrawPlus.text(8,10.6,"price: " + squares[current_square].price);
		StdDrawPlus.text(8,10.2,"owner:" + squares[current_square].owner());}

		else {
			StdDrawPlus.text(8,11,"" + squares[current_square].name);
			StdDrawPlus.text(8,10.6,"rent: " + squares[current_square].rent);
			StdDrawPlus.text(8,10.2,"owner: " + squares[current_square].owner());
			StdDrawPlus.text(8,9.8,"houses: " + squares[current_square].house_additions);
		}

		StdDrawPlus.setPenColor(StdDrawPlus.GRAY);


		

		StdDrawPlus.picture(8,4,"images/dice.png",2,2);
		StdDrawPlus.setPenColor(StdDrawPlus.RED);
		StdDrawPlus.text(2,0,one.name);
		StdDrawPlus.picture(3.5,0,"images/money.png",1.5,1.5);
		StdDrawPlus.text(5,0,":$" + one.money);
		
		StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
		StdDrawPlus.text(0,14,two.name);
		StdDrawPlus.picture(0,12.5,"images/money.png",1.5,1.5);
		StdDrawPlus.text(0,11,":$" + two.money);
		
		StdDrawPlus.setPenColor(StdDrawPlus.YELLOW);
		StdDrawPlus.text(2,16,three.name);
		StdDrawPlus.picture(3.5,16,"images/money.png",1.5,1.5);
		StdDrawPlus.text(5,16,":$" + three.money);
		
		
		StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
		StdDrawPlus.text(16,14,four.name);
		StdDrawPlus.picture(16,12.5,"images/money.png",1.5,1.5);
		StdDrawPlus.text(16,11,":$" + four.money);

		/* Pointers */
		if (order == 1){
			StdDrawPlus.picture(0,0,"images/rightpointer.png",1,1);
		}
		
		else if (order == 2){
			StdDrawPlus.picture(0,16,"images/downpointer.png",1,1);
		}

		else if (order == 3){
			StdDrawPlus.picture(0,16,"images/rightpointer.png",1,1);
		}

		else if (order == 4){
			StdDrawPlus.picture(16,16,"images/downpointer.png",1,1);
		}

	}

		if (started == true && dice_rolled == true){
			/* Draws the Roll Dice*/
			StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			StdDrawPlus.filledSquare(10,4,0.8);
			StdDrawPlus.setPenColor(StdDrawPlus.BLACK);
			StdDrawPlus.text(9.5,4.5, "" + a);
			StdDrawPlus.text(10.5,4.5, "" + b);
			StdDrawPlus.text(10,3.5,"" + (a + b));

			/* Draws the buy, bank and negotiate buttons*/

			StdDrawPlus.setPenColor(StdDrawPlus.GREEN);
			StdDrawPlus.filledSquare(5,6,0.5);
			StdDrawPlus.setPenColor(StdDrawPlus.MAGENTA);
			StdDrawPlus.text(5,6,"buy");

			StdDrawPlus.setPenColor(StdDrawPlus.BLUE);
				StdDrawPlus.filledSquare(7.65,6,0.5);
			StdDrawPlus.setPenColor(StdDrawPlus.RED);
			StdDrawPlus.text(7.65,6,"bank");

			StdDrawPlus.setPenColor(StdDrawPlus.RED);
			StdDrawPlus.filledSquare(11,6,0.5);
			StdDrawPlus.setPenColor(StdDrawPlus.BLUE);
			StdDrawPlus.text(11,6,"trade");


		}

	}



	public void endTurn(){
		if (dice_rolled == false){}
		else {
		if (order == 1){
			order = 2;
			current_player = two;
		}

		else if (order == 2){
			order = 3;
			current_player = three;
		}
		else if (order == 3){
			order = 4;
			current_player = four;
		}

		else if (order == 4){
			order = 1;
			current_player = one;
		}

		System.out.println("Ended Turn");
		dice_rolled = false;}
	}
	
	public void place(Player p, int x, int y, int position){
		p.position = position;
		p.xc = x;
		p.yc = y;

	}

	public void buy(Player player, Property property){
		if (property.owned == true || property.price == 0 || property.price > player.money){}
		else {
		property.owned = true;
		property.owner = player;
		player.money -= property.price;
		player.properties[player.number_properties] = property;
		player.number_properties++;}
	}

	public void GUI(){
		InitializeProperties();

		while (true){
			DrawBoard();
			DrawPlayers();
		
			if (StdDrawPlus.mousePressed()){
				System.out.println(StdDrawPlus.mouseX());
				System.out.println(StdDrawPlus.mouseY());

			if (started == false){
				if (((int)(StdDrawPlus.mouseX()) >= 7  && (int) (StdDrawPlus.mouseX()) <= 9) &&
					((int)(StdDrawPlus.mouseY()) >= 7  && (int) (StdDrawPlus.mouseY()) <= 9)) {
					started = true;
				}
			}

			if (dice_rolled == false){
				if (((int)(StdDrawPlus.mouseX()) >= 7  && (int) (StdDrawPlus.mouseX()) <= 9) &&
				((int)(StdDrawPlus.mouseY()) >= 3  && (int) (StdDrawPlus.mouseY()) <= 5)){
					dice_rolled = true;
					a = RollDice1();
					b = RollDice1();
					if (order == 1){
						move(one,a+b);

					}

					else if (order == 2){
						move(two,a+b);
					}

					else if (order == 3){
						move(three, a+b);
					}

					else if (order == 4){
						move(four,a+b);
					}

					}

			}


			if (dice_rolled == true){
				if ((StdDrawPlus.mouseX() >= 4.50  && StdDrawPlus.mouseX() <= 5.66) &&
				(StdDrawPlus.mouseY() >= 5.36  && (StdDrawPlus.mouseY() <= 6.45))) {
					System.out.println("executed");
					if (order == 1){buy(one,squares[current_square]);}
					else if (order == 2){buy(two,squares[current_square]);}
					else if (order == 3){buy(three,squares[current_square]);}
					else if (order == 4){buy(four,squares[current_square]);}
				}

			}


		}

		if (StdDrawPlus.isSpacePressed()){
			endTurn();
		}
		StdDrawPlus.show(50);
	}
}

	public static void main(String[] args){

		StdDrawPlus.setCanvasSize(700,700);

		StdDrawPlus.setScale(0,16);
		StdDrawPlus.setScale(0,16);

		Calopoly game = new Calopoly();
		game.GUI();



	}
}