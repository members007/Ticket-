import java.util.ArrayList;
public class Member {
	public String name;
	public int number;
	public ArrayList<Integer> reserveList = new ArrayList() ;
	public Member(String name, int number, ArrayList reserveList){
		this.name = name;
		this.number = number;
		this.reserveList = reserveList;
	}
	void getName() {
		System.out.println(this.name);
	}
	void getNumber() {
		System.out.println(this.number);
	}
	void getReserveList() {
		System.out.println(this.reserveList);
	}
	void print() {
		System.out.println(this.name + "'s ID is " + this.number);
		System.out.println("reserved concertID is " + this.reserveList);
	}
}
