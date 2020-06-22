
public class Concert {
	public String name;
	public String genre;
	public String date;
	public String place;
	public int price;
	public int capacity;
	public int number;
	public Concert(String name,String genre,String date,String place, int price, int capacity, int number){
		this.name = name;
		this.genre = genre;
		this.date = date;
		this.place = place;
		this.price = price;
		this.capacity = capacity;
		this.number = number;
	}
	void getName() {
		System.out.println(this.name);
	}
	void getDate() {
		System.out.println(this.genre);
	}
	void getPlace() {
		System.out.println(this.place);
	}
	void getPrice() {
		System.out.println(this.price);
	}
	void getCapacity() {
		System.out.println(this.capacity);
	}
	void getNumber() {
		System.out.println(this.number);
	}
	void print() {
		System.out.println("name: "+this.name);
		System.out.println("genre: "+this.genre);
		System.out.println("place: "+this.place);
		System.out.println("price: "+this.price);
		System.out.println("capacity: "+this.capacity);
	}
}
