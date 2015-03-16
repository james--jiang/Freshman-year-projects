
public class Property {
	public String name;
	public String color;
	public int price;
	public int position;
	public int rent;
	public int house_additions;
	public String image;
	public Player owner = null;


	public boolean owned = false;
	public Property(String name, int price, String color, int rent, int house_additions, int position, String image){
		this.name = name;
		this.color = color;
		this.price = price;
		this.position = position;
		this.house_additions = house_additions;
		this.rent = rent;
		this.image = image;


	}

	public String owner(){
		if (owner == null){
			return "No one";
		}

		else {
			return owner.name;
		}
	}

}