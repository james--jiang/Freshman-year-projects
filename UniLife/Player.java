
public class Player {
	public int money;
	public Property[] properties = new Property[20];
	public String name;
	public String picture;
	public int order;
	public int position = 0;
	public int xc = 2;
	public int yc = 14;
	public int number_properties = 0;
	public boolean owned = false;

	public Player(String name,String picture,int order){
		this.name = name;
		money = 50000;
		this.picture = picture;
		this.order = order;
	}


}