import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	public static Member[] members = new Member[100];
    static ArrayList<Concert> concerts = new ArrayList<Concert>() ;
    static int number = 1;
    static int numberConcert = 1;
    
	
	public static void addMember() {
		System.out.println("enter new member name");
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String name = null;
        try {
            name = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList reserveList = new ArrayList() ;
        Member newMember = new Member(name, number, reserveList);
        members[number] = newMember;
        number++;
	}
	public static void addConcert() {
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("enter new Concert name");
        String name = null;
        try {
            name = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter new Concert genre");
        String genre = null;
        try {
            genre = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter new Concert date(format yyyy/mm/dd)");
        String date = null;
        try {
            date = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter new Concert place");
        String place = null;
        try {
            place = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter new Concert ticket price");
        String price_str = null;
        try {
            price_str = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter new Concert capacity");
        String capacity_str = null;
        try {
        	capacity_str = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int price = Integer.parseInt(price_str);
        int capacity = Integer.parseInt(capacity_str);
        ArrayList reserveList = new ArrayList() ;
        Concert concert = new Concert(name, genre, date, place, price, capacity, numberConcert);
        concerts.add(concert);
        numberConcert++;

	}
	public static void showMember() {
			 
	    System.out.println("enter searching member id");
	    Scanner scan = new Scanner(System.in);
	    int memberNumber = scan.nextInt();
	    if(memberNumber > number) {
	    	System.out.println("User does not exist");
	    	return;
	    }
	    Member targetMember = members[memberNumber];
	    System.out.println(targetMember.name); 
	    System.out.println(targetMember.reserveList); 
	}
	public static void showConcert() {
		for(int index = 0; index <numberConcert-1; index++) {
			Concert concert = concerts.get(index);
			System.out.println(concert.name);
			System.out.println(concert.genre);
			System.out.println(concert.date);
			System.out.println(concert.number);
			System.out.println();
		}
	}

	public static void deleteMember() {
		System.out.println("Enter the ID of the user you want to delete");
	    Scanner scan = new Scanner(System.in);
	    int memberNumber = scan.nextInt();
	    Member targetMember = members[memberNumber];
	    targetMember.name = "User has been deleted.";
	    System.out.println(targetMember.name);   
	}

	public static void reserveConcert() {
		System.out.println("Enter enter your number");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
        String memberNumberStr = null;
        try {
            memberNumberStr = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int memberNumber = Integer.parseInt(memberNumberStr);
        System.out.println("you are user number" + memberNumber);
        System.out.println("which concert do you want to reserve ?");
        System.out.println("enter concert number");
        String concertNumberStr = null;
        try {
            concertNumberStr = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int concertNumber = Integer.parseInt(concertNumberStr);
        Member member = members[memberNumber];
        member.reserveList.add(concertNumber);
        return;
	}
	public static void userMode() {
		System.out.println("Enter operation (search or reserve)");
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String userCommand = null;
        try {
            userCommand = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(userCommand) {
		case "search":
			showConcert();
			break;
		case "reserve":
			reserveConcert();
			break;
        default:
            System.out.println("Command not recognized!");
            break;
        }
        return;
	}
	public static void checkBooking() {
		System.out.println("Display the reserved member");
		System.out.println("enter the concert number");
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String concertNumberStr = null;
        try {
            concertNumberStr = br.readLine();
            //br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int concertNumber = Integer.parseInt(concertNumberStr);
        //System.out.println(members.length);
        for(int i=1; i<number;i++) {//member starts with 1
        	Member member = members[i];
        	//member.reserveList.contains(concertNumber)
        	if(member.reserveList.contains(concertNumber)) {
        		System.out.println(member.name);
        	}	
        }
        System.out.println("These are the members who have reserved concerts");
	}
	public static void main(String[] args) {
        boolean running = true;
    	for(int i=1;i<4; i++) {
			ArrayList reserveList = new ArrayList() ;
			Member member = new Member("user"+i, i, reserveList);
			Concert concert = new Concert("concert"+i,"genre"+i,"2020/8/"+i,"Tokyo", 1000*i, 1500*i, i);
			members[number] = member;
			number++;
			numberConcert++;
			concerts.add(concert);
		}
        while(running) {
        	System.out.println("Enter operation (add, show, allConcert, delete, user, booking or exit )");
        	InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String command = null;
            try {
                command = br.readLine();
                //br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        	switch(command) {
        		case "add":
        			addMember();
        			break;
        		case "show":
        			showMember();
        			break;
        		case "allConcert":
        			showConcert();
        			break;
        		case "delete":
        			deleteMember();
        			break;
        		case "user":
                    System.out.println("move to UserMode");
                    userMode();
                    break;
        		case "booking":
                    System.out.println("chech booking list");
                    checkBooking();
                    break;
        		case "exit":
                    System.out.println("Application Closed");
                    running = false;
                    break;
                default:
                    System.out.println("Command not recognized!");
                    break;
        	}
        }
	}
}
