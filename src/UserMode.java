import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMode extends Admin{
	public static void reserveConcert() {
		int number;
		System.out.println("Enter enter your number");
		
	}
	public static void userMode() {
		
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
			showConcert();;
			break;
		case "reserve":
			reserveConcert();
			break;
        default:
            System.out.println("Command not recognized!");
            break;
        }
	}
}
