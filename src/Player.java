

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Player {
	public static ArrayList <String> Face = new ArrayList<String>();
        public static ArrayList<String>Libraryid= new ArrayList<String>();
	public Player () {
	}
	public ArrayList<String> face () {
            Face.add(Name());
            Face.add(Lname());	
            Face.add(checkid(id()));
            return Face;    
	}
        public static String id() {
		Random random = new Random();
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		String id = timeStamp+Integer.toString((random.nextInt(9999) + 1));
		System.out.println("Your ID Number is " +id+".");
                return id;
	}
        public static String checkid(String d){
            if(Libraryid.contains(d)){
                Random random = new Random();
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		d = timeStamp+Integer.toString((random.nextInt(9999) + 1));
		return d; 
            }else{
                return d;
            }
        }
        public static String Name() {
		Scanner input = new Scanner(System.in);
		System.out.print(" Give me your name ");
                String name= input.nextLine();
                return name;
	}
        
        public static String Lname() {
		Scanner input = new Scanner(System.in);
		System.out.print(" Give me your last name ");
                String lname= input.nextLine();
                return lname;
	}
	
	public HashSet<Integer> play() {
		Scanner input= new Scanner(System.in);
		HashSet<Integer> Luck = new HashSet<Integer>();
                SystemData.library.add(face());
		for (int i = 0 ; i<6; i++) {
			if (i<5) {
				System.out.println("give me the "+(i+1)+" number. ");
				int a=input.nextInt();
				while((a<1) || (a>45)){
					System.out.println("give me the a number from 1 to 45. ");
					a=input.nextInt();
				}
				while (Luck.contains(a)) {
					System.out.println("You have already wrote it. Give me another number from 1 to 45. ");
					a=input.nextInt();
				}
				Luck.add(new Integer(a));
			}else if (i==5) {
				System.out.println("give me the joker number ");
				int a=input.nextInt();
				while((a<1) || (a>20)){
					System.out.println("give me the a number from 1 to 20. ");
					a=input.nextInt();
				}
				Luck.add(new Integer(a));
				
			}
		}
                
		return Luck;
	}

}
