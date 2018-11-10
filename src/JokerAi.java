
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class JokerAi {

	public JokerAi() {
		
	}
	
	public HashSet<Integer> play() {
		ArrayList<Integer> rndm = new ArrayList<Integer>();
		HashSet<Integer> laiko = new HashSet<Integer>();
		ArrayList<Integer> jkr = new ArrayList<Integer>();
		for (int i = 0; i<45; i++) {
			rndm.add(new Integer(i+1));
		}
		for (int i = 0; i<20; i++) {
			jkr.add(new Integer(i+1));
		}
		Collections.shuffle(rndm);
		Collections.shuffle(jkr);
		for (int i = 0 ; i<5 ; i++) {
			System.out.print(" "+rndm.get(i));
			laiko.add(new Integer(rndm.get(i)));
		}
		laiko.add(new Integer(jkr.get(1)));
		System.out.println(" and the joker number is " + jkr.get(1));
		return laiko;
	}
}

