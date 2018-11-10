
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class SystemData{
	public static HashMap<Integer,Integer> stats= new HashMap<Integer,Integer>();
        
	public SystemData() {
	
	}
        
	private HashSet <Integer>afile=new HashSet<Integer>();
	private HashSet <Integer>bfile=new HashSet<Integer>();
        private ArrayList<Integer> file= new ArrayList<Integer>();
        public static HashSet<ArrayList>library=new HashSet<ArrayList>();
                
	public void Check(HashSet<Integer> afile, HashSet<Integer> bfile) {
                int c= 0;
		this.afile = afile;
		this.bfile = bfile;
		for (Integer j : afile) {
			if (bfile.contains(j)) {
				//System.out.println("they have the same number "+ j); // το έβαλα για να δώ αυτά που είναι κοινά.
                                c++;
			}
		}
                if (c==6){
                    System.out.println("Player "+Player.Face.get(0)+" "+Player.Face.get(1));// ονομα - επιθετο
                    System.out.println("with ID: "+Player.Face.get(2)); // ID NUMBER
                    System.out.println("YOU ARE THE JACK POT WINNER.");
                }else if (c>3){
                    System.out.println("Player "+Player.Face.get(0)+" "+Player.Face.get(1));
                    System.out.println("with ID: "+Player.Face.get(2));
                    System.out.println("You are a winner with "+c+" matches.");
                }else{
                    System.out.println("Player "+Player.Face.get(0)+" "+Player.Face.get(1));
                    System.out.println("with ID: "+Player.Face.get(2));
                    System.out.println("Sorry. You will be lucky next time.");
                }
	}
        
        public ArrayList<Integer> twentyplays() {
                Scanner input = new Scanner(System.in);
		ArrayList<Integer> rndm = new ArrayList<Integer>();
		ArrayList<Integer> jackpot = new ArrayList<Integer>();
		ArrayList<Integer> jkr = new ArrayList<Integer>();
                int x=0;
                System.out.println("Do you want to start the 20-plays? (yes / no)"); // Δινω την επιλογη αν θελει να τρεξει.
                String choice=input.nextLine();
                if (choice.equals("yes")){
                    for (int i = 0; i<45; i++) {
			rndm.add(new Integer(i+1));
                    }		
                    while (x<20){ // κανω 20 AI.play().
                        Collections.shuffle(rndm);
                        for (int i = 0 ; i<5 ; i++) {
                            //System.out.println(" "+rndm.get(i)); // εμφανίζει τους αριθμούς στη loop. δεν χρειάζεται να φαίνεται νομιζω
                            jackpot.add(new Integer(rndm.get(i)));
                        }
                        x++;
                    }                           
                }
                return jackpot;   
            }
            public void counting(ArrayList<Integer> file){ //εδώ μετατρέπω την λίστα σε map.
                this.file=file;
                for (int i =1; i<45;i++){
                    int count=0;
                    for (int j=0; j<file.size(); j++){
                        if (file.get(j)==i){
                            count=count+1;
                        }
                    }
                    stats.put(i, count); //με τις 2 loops ανιχνεύω πόσες φορές εμφανίζεται κάθε αριθμός και τα αποθηκέυω στη map.
                } 
                //System.out.println("unsorted map: " + stats);// μ αυτό σ δείχνει την map που έφτιαξε πριν.
                int maxValueInMap=(Collections.max(stats.values()));
                int minValueInMap=(Collections.min(stats.values()));
                if(maxValueInMap!=0){ // το πρόσθεσα γιατι είχα πρόβλημα στην επιλογή του (yes/no) στο 20plays.
                    System.out.println("the max values and the numbers that repeated:");
                    for (int i=maxValueInMap; i>maxValueInMap-3; i--){
                        System.out.println("the numbers that appears "+i+" times :");
                        if(stats.values().contains(i)){
                            for (Entry<Integer, Integer> entry : stats.entrySet()) {  
                                if (i==entry.getValue()) {
                                    System.out.print(entry.getKey()+" ");     
                                }
                            }                 
                            System.out.println("");   
                        }else{
                            for (Entry<Integer, Integer> entry : stats.entrySet()) {  
                                if (i-2==entry.getValue()) {
                                    System.out.print(entry.getKey()+" ");     
                                }
                            }
                            System.out.println("");
                        }
                    }             
                // το μετρημα των min το εβαλα στην ιδια επιλογη(maxvalueinmap!=0) διότι μου τα εκτύπωνε στην επιλογή (no).
                    System.out.println("the min values and the numbers that repeated:");
                    if (minValueInMap==0){// δεν θελουμε τα 0 values.
                        minValueInMap=+1;
                    }
                    for (int i=minValueInMap; i<minValueInMap+3; i++){
                        System.out.println("the numbers that appears "+i+" times :");
                        if(stats.values().contains(i)){
                            for (Entry<Integer, Integer> entry : stats.entrySet()) {  
                                if (i==entry.getValue()) {
                                System.out.print(entry.getKey()+" ");     
                                }
                            }
                            System.out.println("");
                        }else{
                            for (Entry<Integer, Integer> entry : stats.entrySet()) {  
                                if (i+2==entry.getValue()) {
                                    System.out.print(entry.getKey()+" ");     
                                }
                            }
                        System.out.println("");
                        }
                    }                    
                }else if(maxValueInMap==0){
                    System.out.println("Thank you very much. Good Bye!");
                }
            }
        }
    

